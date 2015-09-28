package tests;

import java.sql.SQLException;

import dbManagers.DepositManager;
import beans.DepositBean;
import beans.DepositType;

public class TestDepositManager {
	public static void main(String[] args) throws SQLException {
		
		DepositManager deposit=new DepositManager();
		//DepositType type=DepositType.SHORT;
		//DepositBean depo=new DepositBean(8,232,244.0,444.5,type,new java.sql.Date(2014-11-14) , new java.sql.Date(2025-06-14));
		//depo=deposit.getDeposit(8);
		System.out.println(deposit.getDeposit(8));
		
		//System.out.println(deposit.depositExist(1223244));
		//System.out.println(depo);
//		try {
//			System.out.println(deposit.viewClientDeposits(1223244));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//System.out.println(deposit.viewClientDeposits(1223244));
		
	}

}
