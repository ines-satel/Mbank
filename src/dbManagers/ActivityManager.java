package dbManagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.ActivityBean;
import interfaces.IActivityManager;

public class ActivityManager implements IActivityManager 
{
	//ActivityManager class responsible for all the activity methods
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
	
	//method that inserts new activity to the data base when getting ActivityBean object
	@Override
	public void recordActivity(ActivityBean activity) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for INSERT
			String sql = "INSERT INTO activity(id,client_id,amount,activity_date,"
					+ "commission,description) VALUES (?,?,?,?,?,?)";

			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setNString(1, null);
			pst.setLong(2, activity.getClientId());
			pst.setDouble(3, activity.getAmount());
			pst.setDate(4, activity.getActivityDate());
			pst.setDouble(5, activity.getCommission());
			pst.setString(6, activity.getDescription());

			// execute a query
			pst.executeUpdate();
			System.out.println("activity saved in the system");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that returns list of client activities by clientId
	@Override
	public List<ActivityBean> viewClientActivities(long clientId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			// query for SELECT
			String sql = "SELECT id, client_id, amount, activity_date,"
					+ "commission, description FROM mbank.activity WHERE client_id = "
					+ clientId;

			Statement stmt = connection.createStatement();

			// execute a query
			rs = stmt.executeQuery(sql);
			List<ActivityBean> activitiesList = new ArrayList<ActivityBean>();
			ActivityBean activity = null;
			while (rs.next()) 
			{
				long id = rs.getLong("id");
				double amount = rs.getDouble("amount");
				java.sql.Date activityDate = rs.getDate("activity_date");
				double commission = rs.getDouble("commission");
				String description = rs.getString("description");

				activity = new ActivityBean(id, clientId, amount, activityDate,
						commission, description);
				activitiesList.add(activity);
			}
			return activitiesList;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns a list of all activities in the data base
	@Override
	public List<ActivityBean> viewAllActivities() throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			// query for SELECT
			Statement stmt = connection.createStatement();
			String sql = "SELECT id, client_id, amount, activity_date,"
					+ "commission, description FROM mbank.activity";
			rs = stmt.executeQuery(sql);
			List<ActivityBean> activityList = new ArrayList<ActivityBean>();

			while (rs.next()) 
			{
				ActivityBean activity = null;
				long id = rs.getLong("id");
				Long clientId = rs.getLong("client_id");
				double amount = rs.getDouble("amount");
				java.sql.Date activityDate = rs.getDate("activity_date");
				double commission = rs.getDouble("commission");
				String description = rs.getString("description");

				activity = new ActivityBean(id, clientId, amount, activityDate,
						commission, description);
				activityList.add(activity);
			}
			return activityList;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

}