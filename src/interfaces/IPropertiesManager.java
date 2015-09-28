package interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IPropertiesManager 
{
	//PropertiesManager interface
	public void updateSystemProperty(String propertiesKey,
			String propertiesValue) throws SQLException;
	public String viewSystemProperty(String propertiesKey) throws SQLException;
	public List<String> viewAllProperties() throws SQLException;
}
