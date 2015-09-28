package interfaces;

import java.sql.SQLException;
import java.util.List;
import beans.ActivityBean;

public interface IActivityManager 
{
	//ActivityManager interface
	
	public List<ActivityBean> viewClientActivities(long clientId) throws SQLException;
	public List<ActivityBean> viewAllActivities() throws SQLException;
	public void recordActivity(ActivityBean activity) throws SQLException;

}
