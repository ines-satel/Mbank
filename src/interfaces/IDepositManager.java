package interfaces;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import beans.DepositBean;

public interface IDepositManager 
{
	//DepositManager interface

	public void createDeposit(DepositBean deposit) throws SQLException;
	public void removeDeposit(long depositId) throws SQLException;
	public List<DepositBean> viewClientDeposits(long clientId) throws SQLException;
	public List<DepositBean> viewAllDeposits() throws SQLException;
	public DepositBean getDeposit(long depositId) throws SQLException;
	public HashSet<DepositBean> getExpiredDeposits() throws SQLException;

}
