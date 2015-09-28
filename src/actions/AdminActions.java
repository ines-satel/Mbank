package actions;

import interfaces.IAccountManager;
import interfaces.IActivityManager;
import interfaces.IClientManager;
import interfaces.IDepositManager;
import interfaces.IPropertiesManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.AccountBean;
import beans.ActivityBean;
import beans.ClientBean;
import beans.ClientType;
import beans.DepositBean;
import dbManagers.AccountManager;
import dbManagers.ActivityManager;
import dbManagers.ClientManager;
import dbManagers.DepositManager;
import dbManagers.PropertiesManager;
import exceptions.CannotGenerateClientException;
import exceptions.ClientAlreadyExistException;
import exceptions.ClientDoesNotExistException;
import exceptions.PropertyDoesNotExistException;

public class AdminActions extends Actions 
{
	//AdminActions class extends Action super class
	//It contains methods which only administrators have access to them

	// constructor
	public AdminActions() 
	{

	}

	// method that adds new client to the data base and opens new account to the new client
	public void addNewClient(ClientBean newClient, double firstAmount, String accountComment) 
			throws SQLException, ClientAlreadyExistException, CannotGenerateClientException
	{
		IClientManager clientManager = new ClientManager();
		AccountBean newAccount = new AccountBean();
		IAccountManager AccountManager = new AccountManager();
		IPropertiesManager propertiesManager = new PropertiesManager();

		//check if the new client is already exist in the system
		if (clientManager.viewClientDetails(newClient.getClientId()) != null)
		{
			throw new ClientAlreadyExistException();
		}
		else
		{
			double regular_limit = Double.parseDouble(propertiesManager
					.viewSystemProperty("regular_deposit_rate"));
			double gold_limit = Double.parseDouble(propertiesManager
					.viewSystemProperty("gold_deposit_rate"));

			if (firstAmount < 1) // can't generated new client and account when the
								 // first amount is lower then 1$
			{
				throw new CannotGenerateClientException();
			} 
			else if (firstAmount < regular_limit) // 1$-100,000$ is regular
			{
				newClient.setType(ClientType.REGULAR);
			} 
			else if (firstAmount < gold_limit) // 100,000$-1,000,000$ is gold
			{
				newClient.setType(ClientType.GOLD);
			} 
			else // 1,000,000$ and higher amounts is platinum
			{
				newClient.setType(ClientType.PLATINUM);
			}

			clientManager.createClient(newClient);

			String clientType = String.valueOf(newClient.getType());
			if (clientType == "PLATINUM")
			{
				double credit_limit=Double.MAX_VALUE;
				newAccount.setCreditLimit(credit_limit);
			}
			else
			{
				double credit_limit = Double.parseDouble(propertiesManager
						.viewSystemProperty(clientType + "_credit_limit"));
				newAccount.setCreditLimit(credit_limit);
			}

			newAccount.setClientId(newClient.getClientId());
			newAccount.setBalance(firstAmount);
			newAccount.setComment(accountComment);
			AccountManager.creatNewAccount(newAccount);

			System.out.println("New client and account generated");
		}
	}

	// method that removes client from data base and removes his account and deposits
	public void removeClient(long clientId) throws SQLException, ClientDoesNotExistException
	{
		IPropertiesManager propertiesManager = new PropertiesManager();
		IAccountManager accountManager = new AccountManager();
		IClientManager clientManager = new ClientManager();
		ClientBean clientDetails = new ClientBean();
		IDepositManager depositManager = new DepositManager();
		clientDetails = clientManager.viewClientDetails(clientId);
		//check if the client exist in the system
		if (clientDetails == null)
		{
			throw new ClientDoesNotExistException();
		}
		else
		{
			List<DepositBean> clientDepositList = new ArrayList<DepositBean>();
			double sumOfDeposits = 0.0;
			clientDepositList = depositManager.viewClientDeposits(clientId);
			for (DepositBean elem : clientDepositList) 
			{
				sumOfDeposits = sumOfDeposits + (elem.getBalance());
				depositManager.removeDeposit(elem.getDepositId());
			}

			String type = String.valueOf(clientDetails.getType());
			double commission = Double.parseDouble(propertiesManager
					.viewSystemProperty(type + "_deposit_commission"));
			sumOfDeposits = sumOfDeposits - (sumOfDeposits * commission);
			double accountBalance = accountManager.getBalance(clientId);
			double sumOfMoney = sumOfDeposits + accountBalance;

			if (sumOfMoney < 0) 
			{
				System.out.println("Client has negative balance of " +sumOfMoney+"$");
				System.out.println(sumOfMoney * commission+ "$ commission charged due"
						+ " to negative balance account on client removal");
				System.out.println("Total charge: "+(sumOfMoney * commission + sumOfMoney)+ "$");
			} 
			else 
			{
				System.out.println("Total money withdrows in closing account process: " 
						+ sumOfMoney + "$");
			}

			accountManager.removeAccount(clientId);
			clientManager.deleteClient(clientId);
		}
	}

	//method that returns a list of all clients details (ClientBean objects)
	public List<ClientBean> viewAllClientDetails() throws SQLException 
	{
		IClientManager client = new ClientManager();
		return client.viewAllClientsDetails();
	}

	//method that returns a list of all accounts details (AccountBean objects)
	public List<AccountBean> viewAllAccountDetails() throws SQLException 
	{
		IAccountManager accountManager = new AccountManager();
		return accountManager.viewAllAccountDetails();
	}

	//method that returns a list of all deposits details (DepositBean objects)
	public List<DepositBean> viewAllDeposits() throws SQLException 
	{
		IDepositManager depositManager = new DepositManager();
		return depositManager.viewAllDeposits();
	}

	//method that returns a list of all activities details (ActivityBean objects)
	public List<ActivityBean> viewAllActivities() throws SQLException 
	{
		IActivityManager activityManager = new ActivityManager();
		return activityManager.viewAllActivities();
	}
	
	//method that update system property by property key and a new property value
	public void updateSystemProperty(String propertiesKey, String propertiesValue) 
			throws SQLException, PropertyDoesNotExistException 
	{
		IPropertiesManager propertiesManager = new PropertiesManager();
		String property = propertiesManager.viewSystemProperty(propertiesKey);
		//check if the property exist in the system
		if (property == null)
		{
			throw new PropertyDoesNotExistException();
		}
		propertiesManager.updateSystemProperty(propertiesKey, propertiesValue);
	}
	
	// method that returns a list of all system properties keys in List<String>
	public List<String> viewAllPropertiesKeys() throws SQLException
	{
		IPropertiesManager propertiesManager = new PropertiesManager();
		return propertiesManager.viewAllProperties();
	}
}
