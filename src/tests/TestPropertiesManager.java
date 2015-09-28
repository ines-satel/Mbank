package tests;

import java.sql.SQLException;

import dbManagers.ClientManager;
import dbManagers.PropertiesManager;

public class TestPropertiesManager 
{
	public static void main(String[] args)
	{

		PropertiesManager propertiesManager=new PropertiesManager();
		//	String typeC = String
		//			.valueOf(clientManager.getClientType(clientId)); 
		//	typeC=typeC.toLowerCase();
		String typeC="platinum";
		double daily_interest;
		try 
		{
			daily_interest = Double.parseDouble(propertiesManager
					.viewSystemProperty(typeC + "_daily_interest"));

			//System.out.println(daily_interest);
			

			PropertiesManager prop=new PropertiesManager();
			ClientManager client=new ClientManager();
			
			System.out.println(prop.viewAllProperties());
			//prop.updateSystemProperty("platinum_daily_interest", "0.08");
			
			//System.out.println(daily_interest);

//			System.out.println(client.viewAllClientsDetails());
//			System.out.println(prop.viewSystemProperty("gold_deposit_rate"));	
//			System.out.println(prop.viewSystemProperty("admin_username"));
//			System.out.println(prop.viewSystemProperty("admin_password"));
//			
//			System.out.println(prop.viewAllProperties());
			
		} 
		catch (NumberFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
