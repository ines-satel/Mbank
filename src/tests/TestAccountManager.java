package tests;


import java.sql.SQLException;

import dbManagers.AccountManager;

public class TestAccountManager {
	public static void main(String[] args) throws SQLException {
		
		
		AccountManager account= new AccountManager();
		
		System.out.println(account.viewAllAccountDetails());
		System.out.println(account.getBalance(22133244));
	}

}
