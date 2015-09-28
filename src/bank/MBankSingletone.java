package bank;

import interfaces.IClientManager;
import interfaces.IPropertiesManager;
import java.sql.SQLException;
import actions.Actions;
import actions.AdminActions;
import actions.ClientActions;
import actions.closeDepositThread;
import beans.ClientBean;
import dbManagers.ClientManager;
import dbManagers.PropertiesManager;
import exceptions.LoginException;

public class MBankSingletone 
{
	//MBankSingletone class holds the information and the responsibilities of the bank

	private static MBankSingletone instance;
	private static closeDepositThread thread;

	//method that compare between the given details and the client details in the 
	//data base. If there is a match a new object of ClientAction is created
	public void clientLogin(long clientId, String name, String password) 
			throws SQLException, LoginException
	{
		IClientManager clientManager= new ClientManager();
		ClientBean clientDeatils = clientManager.viewClientDetails(clientId);

		if (clientDeatils.getClientName().equals(name) &&
				clientDeatils.getPassword().equals(password))
		{
			System.out.println("successful connected to the system");
			Actions clientAction = new ClientActions();
		}
		else
		{
			throw new LoginException();
		}
	}

	//method that compare between the given details and the client details in the data base
	//in the properties table
	//If there is a match a new object of AdminAction is created
	public void adminLogin(String name, String password) throws SQLException, LoginException
	{
		IPropertiesManager propertiesManager = new PropertiesManager();

		if (propertiesManager.viewSystemProperty("admin_username").equals(name) &&
				propertiesManager.viewSystemProperty("admin_password").equals(password))
		{
			System.out.println("successful connected to the system");
			Actions adminAction = new AdminActions();
		}
		else
		{
			throw new LoginException();
		}
	}

	//MBankSingletone
	public static MBankSingletone getInstance()
	{
		if(instance == null)
		{
			instance = new MBankSingletone();
			thread= new closeDepositThread(); 
			thread.start();
		}
		return instance;
	} 	
}
