package actions;

import interfaces.IAccountManager;
import interfaces.IDepositManager;
import java.sql.SQLException;
import java.util.HashSet;
import dbManagers.AccountManager;
import dbManagers.DepositManager;
import beans.DepositBean;

public class closeDepositThread extends Thread 
{
	//CloseDepositThread runs on all deposits and check if there is a deposit that it's 
	//closing date is the current day (The thread runs once a day).
	//when a deposit closes the amount of money in it transfered to client's account.

	private static int DAY = 86400000;

	@Override
	public void run() 
	{

		IDepositManager depositManager = new DepositManager();
		HashSet<DepositBean> allExpired = null;

		try 
		{
			allExpired = depositManager.getExpiredDeposits();
		} 
		catch (SQLException e1) 
		{
			// TODO: Announce details of the exception to the log
			e1.printStackTrace();
		}

		for (DepositBean deposit : allExpired) 
		{

			try 
			{
				closeDeposit(deposit);
			} 
			catch (SQLException e) 
			{
				// TODO: Announce details of the exception to the log
				e.printStackTrace();
			}
		}
		try 
		{
			Thread.sleep(DAY);
		} 
		catch (InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}

	}

	//method that closes a deposit automatically (with run method which call it)
	//and updates the balance within the account after the deposit release.
	private void closeDeposit(DepositBean deposit) throws SQLException 
	{
		IAccountManager accountManager = new AccountManager();

		double newBalance = accountManager.getBalance(deposit.getClientId())
				+ deposit.getBalance();
		accountManager.accountUpdate(deposit.getClientId(), newBalance);

		IDepositManager depositManager = new DepositManager();
		depositManager.removeDeposit(deposit.getDepositId());
	}
}
