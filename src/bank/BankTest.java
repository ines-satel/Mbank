package bank;

import java.sql.SQLException;
import exceptions.LoginException;

public class BankTest 
{
	public static void main(String[] args) 
	{
		MBankSingletone bank = MBankSingletone.getInstance();

		//test for login
		try 
		{
			bank.adminLogin("system", "admin");
			//bank.clientLogin(22133244, moria oz-gilboa, newSecret7);
		} 
		catch (SQLException | LoginException e) 
		{
			e.printStackTrace();
		}
		
	}

}
