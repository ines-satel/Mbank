package actions;

import java.sql.SQLException;
import java.util.List;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientDoesNotHaveDeposit;
import exceptions.PropertyDoesNotExistException;
import beans.AccountBean;
import beans.ActivityBean;
import beans.ClientBean;
import beans.DepositBean;
import dbManagers.AccountManager;
import dbManagers.ActivityManager;
import dbManagers.ClientManager;
import dbManagers.DepositManager;
import dbManagers.PropertiesManager;
import interfaces.IAccountManager;
import interfaces.IActivityManager;
import interfaces.IClientManager;
import interfaces.IDepositManager;
import interfaces.IPropertiesManager;

public abstract class Actions 
{
	//Actions class contains methods which clients and administrators have access to them 

	public Actions() 
	{

	}

	//method that update client name
	public void updateClientName(long clientId, String clientName) throws SQLException, ClientDoesNotExistException
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		clientManager.updateName(clientId, clientName);
	}

	//method that update client address
	public void updateClientAddress(long clientId, String clientAddress) throws SQLException, ClientDoesNotExistException
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		clientManager.updateAddress(clientId, clientAddress);
	}

	//method that update client email
	public void updateClientEmail(long clientId, String clientEmail) throws SQLException, ClientDoesNotExistException
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		clientManager.updateEmail(clientId, clientEmail);
	}

	//method that update client phone
	public void updateClientPhone(long clientId, long clientPhone) throws SQLException, ClientDoesNotExistException 
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		clientManager.updatePhone(clientId, clientPhone);
	}

	//method that update client comment
	public void updateClientComment(long clientId, String comment) throws SQLException, ClientDoesNotExistException 
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		clientManager.updateComment(clientId, comment);
	}

	//method that returns client details
	public ClientBean viewClientDetails(long clientId) throws SQLException, ClientDoesNotExistException 
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		return client;
	}

	//method that returns account details (the validity check is by clientId because every
	//client has one account that connected to him)
	public AccountBean viewAccountDetails(long clientId) throws SQLException, ClientDoesNotExistException 
	{
		IAccountManager accountManager = new AccountManager();
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		return accountManager.viewAccountDetails(clientId);
	}

	//method that returns a list of all deposits (List of DepositBean objects)
	//that a client own by clientId
	public List<DepositBean> viewClientDeposits(long clientId) throws SQLException, ClientDoesNotHaveDeposit, ClientDoesNotExistException 
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		
		IDepositManager depositManager = new DepositManager();
		List<DepositBean> deposits = depositManager.viewClientDeposits(clientId);
		if (deposits==null)
		{
			throw new ClientDoesNotHaveDeposit();
		}
		return deposits;
	}

	//method that returns a list of client activities (List of ActivityBean objects)
	public List<ActivityBean> viewClientActivities(long clientId) throws SQLException, ClientDoesNotExistException 
	{
		IClientManager clientManager = new ClientManager();
		ClientBean client = new ClientBean();
		client = clientManager.viewClientDetails(clientId);
		if (client==null)
		{
			throw new ClientDoesNotExistException();
		}
		IActivityManager activityManager = new ActivityManager();
		return activityManager.viewClientActivities(clientId);
	}

	//method that returns system property value
	public String viewSystemProperty(String propertiesKey) throws SQLException, PropertyDoesNotExistException 
	{
		IPropertiesManager propertiesManager = new PropertiesManager();
		String property = propertiesManager.viewSystemProperty(propertiesKey);
		//check if the property exist in the system
		if (property == null)
		{
			throw new PropertyDoesNotExistException();
		}
		return property;
	}

}
