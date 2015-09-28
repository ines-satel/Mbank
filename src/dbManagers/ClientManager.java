package dbManagers;

import interfaces.IClientManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.ClientBean;
import beans.ClientType;

public class ClientManager implements IClientManager 
{
	//ClientManager class responsible for all the client methods
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

	// method that adds new client to the data base whet getting ClientBean object
	@Override
	public void createClient(ClientBean client) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for INSERT
			String sql = "INSERT INTO clients(client_id,client_name,password,type,address,"
					+ "email,phone,comment) VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setLong(1, client.getClientId());
			pst.setString(2, client.getClientName());
			pst.setString(3, client.getPassword());
			pst.setString(4, client.getType().toString());
			pst.setString(5, client.getAddress());
			pst.setString(6, client.getEmail());
			pst.setLong(7, client.getPhone());
			pst.setString(8, client.getComment());

			// execute a query
			pst.executeUpdate();
			System.out.println("new client was generated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that removes client by clientId
	@Override
	public void deleteClient(long clientId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for DELETE
			String sql = "DELETE FROM clients WHERE client_id = ?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setLong(1, clientId);

			// execute a query
			pst.executeUpdate();
			System.out.println("client id: " + clientId
					+ " has been removed from DB");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that returns client details (ClientBean object) by clientId
	@Override
	public ClientBean viewClientDetails(long clientId) throws SQLException 
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
			String sql = "SELECT client_id, client_name,password,type,address,email,"
					+ "phone,comment FROM mbank.clients where client_id ="
					+ clientId;

			// execute a query
			rs = stmt.executeQuery(sql);
			ClientBean client = null;
			while (rs.next()) 
			{
				String clientName = rs.getString("client_name");
				String password = rs.getString("password");
				String strType = rs.getString("type");
				String address = rs.getString("address");
				String email = rs.getString("email");
				Long phone = rs.getLong("phone");
				String comment = rs.getString("comment");
				ClientType type = ClientType.valueOf(strType);
				client = new ClientBean(clientId, clientName, password, type,
						address, email, phone, comment);
			}
			return client;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns a list of all clients details (List<ClientBean> objects)
	@Override
	public List<ClientBean> viewAllClientsDetails() throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();

			// query for SELECT
			String sql = "SELECT client_id, client_name,password,type,address,email"
					+ ",phone,comment FROM mbank.clients";
			rs = stmt.executeQuery(sql);
			List<ClientBean> clientList = new ArrayList<ClientBean>();

			while (rs.next()) 
			{
				ClientBean client = null;
				Long client_id = rs.getLong("client_id");
				String clientName = rs.getString("client_name");
				String password = rs.getString("password");
				String strType = rs.getString("type");
				String address = rs.getString("address");
				String email = rs.getString("email");
				Long phone = rs.getLong("phone");
				String comment = rs.getString("comment");
				ClientType type = ClientType.valueOf(strType);
				client = new ClientBean(client_id, clientName, password, type,
						address, email, phone, comment);
				clientList.add(client);
			}
			return clientList;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that returns client Type by clientId
	@Override
	public ClientType getClientType(long clientId) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();

			// query for SELECT
			String sql = "SELECT type FROM mbank.clients" + " where client_id="
					+ clientId;

			// execute a query
			rs = stmt.executeQuery(sql);
			ClientType clientType = null;
			while (rs.next()) 
			{
				clientType = ClientType.valueOf(rs.getString("type"));
			}
			return clientType;
		} 
		finally 
		{
			// close the connection
			rs.close();
			connection.close();
		}
	}

	// method that updates client name by clientId and clientNewName
	@Override
	public void updateName(long clientId, String clientNewName) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE clients SET client_name=?"
					+ " WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setString(1, clientNewName);
			pst.setLong(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("client " + clientId + " details updated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that updates client password by clientId and clientNewPassword
	@Override
	public void updatePassword(long clientId, String clientNewPassword) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE clients SET password=?" + " WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setString(1, clientNewPassword);
			pst.setLong(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("client " + clientId + " details updated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that updates client type by clientId and clientNewType
	@Override
	public void updateClientType(long clientId, ClientType clientNewType) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE clients SET type=?" + " WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setString(1, clientNewType.toString());
			pst.setLong(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("client " + clientId + " type updated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that updates client address by clientId and clientNewAddress
	@Override
	public void updateAddress(long clientId, String clientNewAddress) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE clients SET address=?" + " WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setString(1, clientNewAddress);
			pst.setLong(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("client " + clientId + " details updated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that updates client email by clientId and clientNewEmail
	@Override
	public void updateEmail(long clientId, String clientNewEmail) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE clients SET email=?"
					+ " WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setString(1, clientNewEmail);
			pst.setLong(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("client " + clientId + " details updated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that updates client phone by clientId and clientNewPhone
	@Override
	public void updatePhone(long clientId, long clientNewPhone) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE clients SET phone=?" + " WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setLong(1, clientNewPhone);
			pst.setLong(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("client " + clientId + " details updated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that updates client comment by clientId and clientNewComment
	@Override
	public void updateComment(long clientId, String clientNewComment) throws SQLException 
	{
		// get database connection from getConnection function
		Connection connection = getConnection();
		try 
		{
			// query for UPDATE
			String sql = "UPDATE clients SET comment=?" + " WHERE client_id=?";
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setString(1, clientNewComment);
			pst.setLong(2, clientId);

			// executes UPDATE
			pst.executeUpdate();
			System.out.println("client " + clientId + " details updated");
		} 
		finally 
		{
			// close the connection
			connection.close();
		}
	}

	// method that checks if client verified and returns true/false
	@Override
	public boolean clientLogin(long clientId, String clientName, String clientPassword) throws SQLException 
	{
		boolean isClientVerified = false;

		// get database connection from getConnection function
		Connection connection = getConnection();
		try
		{
			//Create the SQL query to execute
			String sql = "SELECT * FROM Clients WHERE client_id=? and client_name=? and password=?";

			PreparedStatement pstmt = null;
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, clientId);
			pstmt.setString(2, clientName);
			pstmt.setString(3, clientPassword);

			//Execute the SELECT Query
			ResultSet rs=pstmt.executeQuery();
			if (rs.next())
			{
				isClientVerified = true;
			}
			return isClientVerified;
		}
		finally
		{
			// close the connection
			connection.close();
		}
	}
}
