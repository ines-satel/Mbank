package actions;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import beans.ActivityBean;
import beans.ClientBean;
import beans.DepositBean;
import beans.DepositType;
import beans.ClientType;
import interfaces.IAccountManager;
import interfaces.IActivityManager;
import interfaces.IClientManager;
import interfaces.IDepositManager;
import interfaces.IPropertiesManager;
import dbManagers.AccountManager;
import dbManagers.ActivityManager;
import dbManagers.ClientManager;
import dbManagers.DepositManager;
import dbManagers.PropertiesManager;
import exceptions.ClientDoesNotExistException;
import exceptions.DepositException;
import exceptions.WithdrawException;

public class ClientActions extends Actions 
{
	//ClientActions class extends Action super class
	//It contains methods which only clients have access to them

	// constructor
	public ClientActions() 
	{

	}

	//method that checks if client login and returns true/false
	public boolean login(long clientId, String clientName, String password) throws SQLException
	{
		boolean isLoggedIn;
		IClientManager clientManager = new ClientManager();
		isLoggedIn = clientManager.clientLogin(clientId, clientName, password);
		return isLoggedIn;	
	}

	//method that updates client password by clientId and new password
	public void updateClientPassword(long clientId, String clientPassword)
			throws SQLException, ClientDoesNotExistException
	{
		IClientManager clientManager = new ClientManager();
		ClientBean clientDetails = new ClientBean();
		clientDetails = clientManager.viewClientDetails(clientId);
		//check if the client exist in the system
		if (clientDetails == null)
		{
			throw new ClientDoesNotExistException();
		}
		clientManager.updatePassword(clientId, clientPassword);
	}

	//method that withdraws sum of money from account
	public void withdrawFromAccount(long clientId, double withdrawAmount)
			throws SQLException, ClientDoesNotExistException, WithdrawException 
	{
		IClientManager clientManager = new ClientManager();
		ClientBean clientDetails = new ClientBean();
		clientDetails = clientManager.viewClientDetails(clientId);
		//check if the client exist in the system
		if (clientDetails == null)
		{
			throw new ClientDoesNotExistException();
		}
		else
		{
			ClientType clientType;
			clientType = clientManager.getClientType(clientId);

			IAccountManager accountManager = new AccountManager();
			double currentBalance;
			currentBalance = accountManager.getBalance(clientId);

			IActivityManager withdrawActivity = new ActivityManager();
			ActivityBean activity = new ActivityBean();

			IPropertiesManager propertiesManager = new PropertiesManager();
			double creditLimit = Double.MAX_VALUE;
			if (clientType != ClientType.PLATINUM) 
			{
				creditLimit = Double.parseDouble(propertiesManager
						.viewSystemProperty(clientType + "_credit_limit"));
			}

			double commissionRate = Double.parseDouble(propertiesManager
					.viewSystemProperty("commission_rate"));
			double newBalance = currentBalance - withdrawAmount - commissionRate;
			//check if there enough money in the account to withdraw
			if (creditLimit*-1 > newBalance)
			{
				throw new WithdrawException();
			}
			else
			{
				accountManager.accountUpdate(clientId, newBalance);
				System.out.println("withdrow of " + withdrawAmount + "$ completed");
				System.out.println("Your current balance is: " + newBalance + "$");

				// updateClientType if necessary
				checkClientType(clientId, newBalance);

				activity.setClientId(clientId);
				activity.setAmount(withdrawAmount);
				activity.setActivityDate(new Date(Calendar.getInstance()
						.getTimeInMillis()));
				activity.setCommission(commissionRate);
				activity.setDescription("withdraw from account");
				withdrawActivity.recordActivity(activity);
			}
		}
	}

	//method that deposits to account
	public void depositToAccount(long clientId, double depositAmount)
			throws SQLException, ClientDoesNotExistException
	{
		IClientManager clientManager = new ClientManager();
		ClientBean clientDetails = new ClientBean();
		clientDetails = clientManager.viewClientDetails(clientId);
		//check if the client exist in the system
		if (clientDetails == null)
		{
			throw new ClientDoesNotExistException();
		}
		else
		{
			IAccountManager accountManager = new AccountManager();
			double currentBalance;
			currentBalance = accountManager.getBalance(clientId);

			IPropertiesManager propertiesManager = new PropertiesManager();
			double commissionRate = Double.parseDouble(propertiesManager
					.viewSystemProperty("commission_rate"));
			double newBalance = currentBalance + depositAmount - commissionRate;

			IActivityManager depositActivity = new ActivityManager();
			ActivityBean activity = new ActivityBean();

			accountManager.accountUpdate(clientId, newBalance);
			System.out.println("Deposit of " + depositAmount + "$ completed");
			System.out.println("Your current balance is: " + newBalance + "$");

			// updateClientType if necessary
			checkClientType(clientId, newBalance);

			activity.setClientId(clientId);
			activity.setAmount(depositAmount);
			activity.setActivityDate(new Date(Calendar.getInstance().getTimeInMillis()));
			activity.setCommission(commissionRate);
			activity.setDescription("deposit to account");
			depositActivity.recordActivity(activity);
		}
	}

	//method that create a new deposit to a client (the deposit type generate automatically)
	public void createNewDeposit(long clientId, double balance, Date openingDate, Date closingDate)
			throws SQLException, ClientDoesNotExistException, DepositException 
	{
		IClientManager clientManager = new ClientManager();
		ClientBean clientDetails = new ClientBean();
		clientDetails = clientManager.viewClientDetails(clientId);
		//check if the client exist in the system
		if (clientDetails == null)
		{
			throw new ClientDoesNotExistException();
		}
		else
		{
			IDepositManager depositManager = new DepositManager();
			DepositBean newDeposit = new DepositBean();
			IPropertiesManager propertiesManager = new PropertiesManager();
			IAccountManager accountManager = new AccountManager();
			IActivityManager depositActivity = new ActivityManager();
			ActivityBean activity = new ActivityBean();

			//check if there enough money in the account to deposit
			if (accountManager.getBalance(clientId) < balance) 
			{
				System.out.println("There is not enough money in the account to deposit");
				throw new DepositException();
			} 
			else 
			{
				//use the method differenceInDays(Date one, Date two) that returns an integer
				//and determine the deposit type
				int depositLength = differenceInDays(openingDate, closingDate);
				if (depositLength <= 365) 
				{
					newDeposit.setType(DepositType.SHORT);
				} 
				else if (depositLength <= (365 * 40)) 
				{
					newDeposit.setType(DepositType.LONG);
				} 
				else 
				{
					System.out.println("The maximum dseposit period is up to 40 years."
							+ " Please enter a defferent closing date");
					throw new DepositException();
				}

				String clientType = String
						.valueOf(clientManager.getClientType(clientId)); 
				clientType = clientType.toLowerCase();
				double daily_interest = Double.parseDouble(propertiesManager
						.viewSystemProperty(clientType + "_daily_interest"));

				double estimatedBalance = ((daily_interest / 365) * depositLength)+ balance;

				newDeposit.setClientId(clientId);
				newDeposit.setBalance(balance);
				newDeposit.setOpeningDate(openingDate);
				newDeposit.setClosingDate(closingDate);
				newDeposit.setEstimatedBalance(estimatedBalance);
				depositManager.createDeposit(newDeposit);

				// Decrease the amount of money from the account
				accountManager.accountUpdate(clientId,
						(accountManager.getBalance(clientId) - balance));

				activity.setClientId(clientId);
				activity.setAmount(balance);
				activity.setActivityDate(new Date(Calendar.getInstance().getTimeInMillis()));
				activity.setCommission(0.0);
				activity.setDescription("Create deposit");
				depositActivity.recordActivity(activity);
			}
		}
	}

	//method that returns an integer which represent the remainder between two given dates 
	public int differenceInDays(Date one, Date two) 
	{
		long diff = one.getTime() - two.getTime();
		int diffInDays = (int) (diff / (1000 * 3600 * 24));
		return Math.abs(diffInDays);
	}

	//method that pre opens a deposit before it's ending date 
	//(only long term deposits allowed to be open)
	public void preOpenDeposit(long depositId) throws SQLException, DepositException 
	{
		IPropertiesManager propertiesManager = new PropertiesManager();
		IAccountManager accountManager = new AccountManager();
		IDepositManager depositManager = new DepositManager();

		DepositBean deposit = depositManager.getDeposit(depositId);
		//check the type of deposit
		if (deposit.getType() != DepositType.LONG) 
		{
			System.out.println("Only long deposits may be pre-opened");
			throw new DepositException();
		}

		double preOpenFee = Double.parseDouble(propertiesManager
				.viewSystemProperty("pre_open_fee"));
		double balanceAfterFee = deposit.getBalance() * (1 - preOpenFee / 100);

		// Add the close depesit's balance to the account
		double accountBalance = accountManager.getBalance(deposit.getClientId());
		accountManager.accountUpdate(deposit.getClientId(),(accountBalance + balanceAfterFee));
		depositManager.removeDeposit(depositId);
	}

	//method that checks client type (when calculating total amount within account and deposits)
	//we use this method when money is transfered into or out from client account
	//so that in every update of client's amounts his type will update if necessary
	public void checkClientType(long clientId, double newBalance) throws SQLException 
	{
		IClientManager client = new ClientManager();
		ClientType currentClientType = client.getClientType(clientId);
		IPropertiesManager propertiesManager = new PropertiesManager();
		IDepositManager depositManager = new DepositManager();
		List<DepositBean> clientDepositList = new ArrayList<DepositBean>();
		clientDepositList = depositManager.viewClientDeposits(clientId);
		double sumOfDeposits = 0.0;

		for (DepositBean elem : clientDepositList) 
		{
			sumOfDeposits = sumOfDeposits + (elem.getBalance());
		}

		double sumOfMoney = sumOfDeposits + newBalance;

		double regular_limit = Double.parseDouble(propertiesManager
				.viewSystemProperty("regular_deposit_rate"));
		double gold_limit = Double.parseDouble(propertiesManager
				.viewSystemProperty("gold_deposit_rate"));

		if (sumOfMoney < regular_limit && currentClientType != ClientType.REGULAR) 
		{
			client.updateClientType(clientId, ClientType.REGULAR);
			System.out.println("Your clientType has been just updated to REGULAR clientType");
		} 
		else if (sumOfMoney < gold_limit&&sumOfMoney >= regular_limit
				&& currentClientType != ClientType.GOLD) 
		{
			client.updateClientType(clientId, ClientType.GOLD);
			System.out.println("Your clientType has been just updated to GOLD clientType");
		} 
		else if (sumOfMoney >= gold_limit && currentClientType != ClientType.PLATINUM) 
		{
			client.updateClientType(clientId, ClientType.PLATINUM);
			System.out.println("Your clientType has been just updated to PLATINIUM clientType");
		}
	}
	
	// method that returns a list of all system properties keys in List<String>
	public List<String> viewAllPropertiesKeys() throws SQLException
	{
		IPropertiesManager propertiesManager = new PropertiesManager();
		return propertiesManager.viewAllProperties();
	}
}
