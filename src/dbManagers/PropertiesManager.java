package dbManagers;

import interfaces.IPropertiesManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.PropertiesBean;

public class PropertiesManager implements IPropertiesManager 
{
	//PropertiesManager class responsible for all the Properties methods
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

	// method that updating a value of system properties in the database by
	//propertiesKey and propertiesNewValue
	@Override
	public void updateSystemProperty(String propertiesKey,String propertiesNewValue) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE properties SET prop_value=?"
					+ " WHERE prop_key='"+propertiesKey+"'";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setString(1, propertiesNewValue);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("property details updated");
		} 
		finally 
		{
			//close the connection
			connection.close();
		}
	}

	// method that views system property by propertiesKey
	@Override
	public String viewSystemProperty(String propertiesKey) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			// execute a query
			String sql = "SELECT prop_value FROM "
					+ "mbank.properties WHERE prop_key ='"+propertiesKey+"'";

			Statement stmt = connection.createStatement();

			// executing creation query
			rs = stmt.executeQuery(sql);
			PropertiesBean property = null;
			while (rs.next()) 
			{
				String propertyValue = rs.getString("prop_value");
				property = new PropertiesBean(propertiesKey, propertyValue);
			}
			return property.getPropertiesValue();
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}
	
	// method that returns a list of all system properties keys in string
	@Override
	public List<String> viewAllProperties() throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			// execute a query
			String sql = "SELECT prop_key FROM mbank.properties ";

			Statement stmt = connection.createStatement();

			// executing creation query
			rs = stmt.executeQuery(sql);
			List<String> keysList = new ArrayList<String>();

			while (rs.next()) 
			{
				String key = rs.getString("prop_key");
				keysList.add(key);
				
			}
			return keysList;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}
}
