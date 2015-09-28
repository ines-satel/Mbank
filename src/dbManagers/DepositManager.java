package dbManagers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import beans.DepositBean;
import beans.DepositType;
import interfaces.IDepositManager;

public class DepositManager implements IDepositManager 
{
	//DepositManager class responsible for all the deposit methods
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

	// method that creates a new deposit in the data base when getting DepositBean object
	@Override
	public void createDeposit(DepositBean deposit) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for INSERT
			String sql = "INSERT INTO deposits(deposit_id,client_id,balance,type,"
					+ "estimated_balance,opening_date,closing_date) VALUES (?,?,?,?,?,?,?)";

			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setLong(1, deposit.getDepositId());
			pst.setLong(2, deposit.getClientId());
			pst.setDouble(3, deposit.getBalance());
			pst.setString(4, deposit.getType().toString());
			pst.setDouble(5, deposit.getEstimatedBalance());
			pst.setDate(6, deposit.getOpeningDate());
			pst.setDate(7, deposit.getClosingDate());

			// execute a query
			pst.executeUpdate();
			System.out.println("new deposit was generated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that removes a deposit from the data base by depositId
	@Override
	public void removeDeposit(long depositId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for DELETE
			String sql = "DELETE FROM deposits WHERE deposit_id =? ";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setLong(1, depositId);

			// execute a query
			pst.executeUpdate();
			System.out.println("deposit id: " + depositId
					+ " has been removed from DB");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that returns deposit (DepositBean object) from the data base by depositId
	@Override
	public DepositBean getDeposit(long depositId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();

			// query for SELECT
			String sql = "SELECT deposit_id,client_id,balance,type,"
					+ "estimated_balance,opening_date,closing_date "
					+ "FROM mbank.deposits WHERE deposit_id=" + depositId;

			// execute a query
			rs = stmt.executeQuery(sql);
			DepositBean deposit = null;
			while (rs.next()) 
			{
				long clientId = rs.getLong("client_id");
				double balance = rs.getDouble("balance");
				String strType = rs.getString("type");
				double estimatedBalance = rs.getDouble("estimated_balance");
				Date openingDate = rs.getDate("opening_date");
				Date closingDate = rs.getDate("closing_date");
				DepositType type = DepositType.valueOf(strType);
				deposit = new DepositBean(depositId, clientId, balance,
						estimatedBalance, type, openingDate, closingDate);

			}
			return deposit;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns list of all deposits (List<DepositBean> objects) of one client by clientId
	@Override
	public List<DepositBean> viewClientDeposits(long clientId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();

			// query for SELECT
			String sql = "SELECT deposit_id,client_id,balance,type,"
					+ "estimated_balance,opening_date,closing_date FROM mbank.deposits WHERE client_id="
					+ clientId; 
			rs = stmt.executeQuery(sql);
			List<DepositBean> depositList = new ArrayList<DepositBean>();

			while (rs.next()) 
			{
				DepositBean deposit = null;
				long depositId = rs.getLong("deposit_id");
				double balance = rs.getDouble("balance");
				String strType = rs.getString("type");
				double estimatedBalance = rs.getDouble("estimated_balance");
				Date openingDate = rs.getDate("opening_date");
				Date closingDate = rs.getDate("closing_date");
				DepositType type = DepositType.valueOf(strType);
				deposit = new DepositBean(depositId, clientId, balance,
						estimatedBalance, type, openingDate, closingDate);
				depositList.add(deposit);
			}
			return depositList;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns list of all deposits of all clients in the data base (List<DepositBean> objects)
	@Override
	public List<DepositBean> viewAllDeposits() throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();

			// query for SELECT
			String sql = "SELECT deposit_id,client_id,balance,type,"
					+ "estimated_balance,opening_date,closing_date FROM"
					+ " mbank.deposits";
			rs = stmt.executeQuery(sql);
			List<DepositBean> depositList = new ArrayList<DepositBean>();

			while (rs.next()) {
				DepositBean deposit = null;
				long depositId = rs.getLong("deposit_id");
				long clientId = rs.getLong("client_id");
				double balance = rs.getDouble("balance");
				String strType = rs.getString("type");
				double estimatedBalance = rs.getDouble("estimated_balance");
				Date openingDate = rs.getDate("opening_date");
				Date closingDate = rs.getDate("closing_date");
				DepositType type = DepositType.valueOf(strType);
				deposit = new DepositBean(depositId, clientId, balance,
						estimatedBalance, type, openingDate, closingDate);
				depositList.add(deposit);
			}
			return depositList;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns hash set of all deposits which expired (HashSet<DepositBean> objects)
	@Override
	public HashSet<DepositBean> getExpiredDeposits() throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();
			HashSet<DepositBean> allExpiredDeposits = new HashSet<DepositBean>();
			Date today = new Date(Calendar.getInstance().getTimeInMillis());

			// query for SELECT
			String sql = "SELECT * FROM mbank.deposits WHERE closing_date < "
					+ today;
			rs = stmt.executeQuery(sql);

			while (rs.next()) 
			{
				DepositBean deposit = null;
				long depositId = rs.getLong("deposit_id");
				long clientId = rs.getLong("client_id");
				double balance = rs.getDouble("balance");
				String strType = rs.getString("type");
				double estimatedBalance = rs.getDouble("estimated_balance");
				Date openingDate = rs.getDate("opening_date");
				Date closingDate = rs.getDate("closing_date");
				DepositType type = DepositType.valueOf(strType);
				deposit = new DepositBean(depositId, clientId, balance,
						estimatedBalance, type, openingDate, closingDate);
				allExpiredDeposits.add(deposit);
			}
			return allExpiredDeposits;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}		
}


