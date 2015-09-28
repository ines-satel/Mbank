package dbManagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.AccountBean;
import interfaces.IAccountManager;

public class AccountManager implements IAccountManager 
{
	//AccountManager class responsible for all the account methods
	//and work with data base and data base connection

	// method that gets a connection to the database
	public static Connection getConnection() throws SQLException 
	{
		String connectionUrl = "jdbc:mysql://localhost/mbank";
		String user = "root";
		String password = "mela";
		Connection connection = DriverManager.getConnection(connectionUrl,
				user, password);
		return connection;
	}

	// method that creates new account in the database when getting AccountBean object
	@Override
	public void creatNewAccount(AccountBean account) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for INSERT
			String sql = "INSERT INTO accounts(account_id,client_id,balance,credit_limit,comment)"
					+ " VALUES (?,?,?,?,?)";

			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setNString(1, null);
			pst.setLong(2, account.getClientId());
			pst.setDouble(3, account.getBalance());
			pst.setDouble(4, account.getCreditLimit());
			pst.setString(5, account.getComment());

			// execute a query
			pst.executeUpdate();
			System.out.println("new account was generated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that removes account from the database by clientId
	@Override
	public void removeAccount(long clientId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// execute a query
			String sql = "DELETE FROM accounts WHERE client_id = ?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setLong(1, clientId);
			pst.executeUpdate();
			System.out.println("account has been removed from DB");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that updates balance of an account when getting clientId and newBalance
	@Override
	public void accountUpdate(long clientId, double newBalance) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE accounts SET balance=? WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setDouble(1, newBalance);
			pst.setDouble(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("account of clientId num: " + clientId
					+ " is updated. The new balance of account is: "
					+ newBalance);
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that returns balance of account by clientId (every client has only one account)
	@Override
	public double getBalance(long clientId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();
			// query for SELECT
			// String sql = "SELECT client_name, password, type, address,"
			// + "email, phone, comment FROM clients WHERE client_id = ? ";
			String sql = "SELECT balance FROM mbank.accounts where client_id ="
					+ clientId;

			// execute a query
			rs = stmt.executeQuery(sql);
			// AccountBean account = null;
			double balance = 0.0;
			while (rs.next()) 
			{
				balance = rs.getDouble("balance");
			}
			return balance;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns account details (AccountBean object) by clientId (every client has only one account)
	@Override
	public AccountBean viewAccountDetails(long clientId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();

			// query for SELECT
			// String sql = "SELECT client_name, password, type, address,"
			// + "email, phone, comment FROM clients WHERE client_id = ? ";
			String sql = "SELECT account_id, client_id,balance,credit_limit,comment "
					+ "FROM mbank.accounts where client_id =" + clientId;

			// execute a query
			rs = stmt.executeQuery(sql);
			AccountBean account = null;
			while (rs.next()) 
			{
				long accountId = rs.getLong("account_id");
				double balance = rs.getDouble("balance");
				double credit_limit = rs.getDouble("credit_limit");
				String comment = rs.getString("comment");

				account = new AccountBean(accountId, clientId, balance,
						credit_limit, comment);
			}
			return account;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns a list of all accounts details (ccountBean objects)
	@Override
	public List<AccountBean> viewAllAccountDetails() throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();

			// query for SELECT
			String sql = "SELECT account_id, client_id,balance,credit_limit,comment FROM mbank.accounts";

			// execute a query
			rs = stmt.executeQuery(sql);

			List<AccountBean> accountList = new ArrayList<AccountBean>();
			while (rs.next()) 
			{
				AccountBean clientAccount = null;
				long account_id = rs.getLong("account_id");
				long client_id = rs.getLong("client_id");
				double balance = rs.getDouble("balance");
				double credit_limit = rs.getDouble("credit_limit");
				String comment = rs.getString("comment");

				clientAccount = new AccountBean(account_id, client_id, balance,
						credit_limit, comment);
				accountList.add(clientAccount);
			}
			return accountList;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

}
