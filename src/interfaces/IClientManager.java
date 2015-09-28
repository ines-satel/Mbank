package interfaces;

import java.sql.SQLException;
import java.util.List;

import beans.ClientBean;
import beans.ClientType;

public interface IClientManager 
{
	//ClientManager interface
	
	public void createClient(ClientBean client) throws SQLException;
	public void deleteClient(long clientId) throws SQLException;
	public ClientBean viewClientDetails(long clientId) throws SQLException;
	public List<ClientBean> viewAllClientsDetails() throws SQLException;
	public ClientType getClientType(long clientId) throws SQLException;
	public void updateName(long clientId, String clientName) throws SQLException;
	public void updatePassword(long clientId, String clientPassword) throws SQLException;
	public void updateClientType(long clientId, ClientType clientType) throws SQLException;
	public void updateAddress(long clientId, String clientAddress) throws SQLException;
	public void updateEmail(long clientId, String clientEmail) throws SQLException;
	public void updatePhone(long clientId, long ClientPhone) throws SQLException;
	public void updateComment(long clientId, String clientComment) throws SQLException;
	public boolean clientLogin(long clientId, String clientName, String clientPassword) throws SQLException;
}
