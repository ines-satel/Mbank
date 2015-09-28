package interfaces;

import java.sql.SQLException;
import java.util.List;
import beans.AccountBean;

public interface IAccountManager 
{
	//AccountManager interface
	
	public void creatNewAccount(AccountBean account) throws SQLException;
	public void removeAccount(long clientId) throws SQLException;
	public void accountUpdate(long clientId, double newBalance) throws SQLException;
	public double getBalance(long accountId) throws SQLException;
	public AccountBean viewAccountDetails(long accountId) throws SQLException;
	public List<AccountBean> viewAllAccountDetails() throws SQLException;
}
