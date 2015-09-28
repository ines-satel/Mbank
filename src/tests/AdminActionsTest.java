package tests;

import java.sql.SQLException;
import exceptions.CannotGenerateClientException;
import exceptions.ClientAlreadyExistException;
import exceptions.ClientDoesNotExistException;
import exceptions.PropertyDoesNotExistException;
import actions.AdminActions;
import beans.ClientBean;
import beans.ClientType;

public class AdminActionsTest 
{
	public static void main(String[] args)
	{

		AdminActions admin = new AdminActions();


		ClientType cType = null;
		try {
//			// test for add new clients
//			// new client 1:
//			double firstAmount = 7700;
//			String accountComment = "client like to be reached over e-mails only";
//			ClientBean newClient = new ClientBean(1223244, "Alex ben David",
//					"tempSecret1", cType, "rehovJava, 8 , beer sheva",
//					"albeda@email.com", 12345678,
//					"the client_id is a french passport num");
//
//			//new client 2:
//			double firstAmount=1540000;
//			String accountComment="the client_id use account rarely";
//			ClientBean newClient=new
//					ClientBean(33433604,"dov nahum","tempSecret2",
//							cType,"rehovHagan, 18 , dimona","dovna@email.com",785473647,
//							"noComment");
//
//			//new client 3:
//			double firstAmount=89779000;
//			String accountComment="";
//			ClientBean newClient=new
//					ClientBean(23437652,"avi farhi","tempSecret3",
//							cType,"rehovArlozorov, 11 , tel aviv","avarhi@email.com",87654321,
//							"client require special attention");
//
//			//new client 4:
//			double firstAmount=1220;
//			String accountComment="";
//			ClientBean newClient=new
//					ClientBean(22432317,"beny gemer","tempSecret4",
//							cType,"rehovShaked, 15 , tveria","bengem@email.com",43255678,
//							"client live abroad Israel");
//
//			//new client 5:
//			double firstAmount=500000;
//			String accountComment="";
//			ClientBean newClient=new
//					ClientBean(33534604,"ibrahim hamude","tempSecret5",
//							cType,"rehovJava, 8 , umilfahem","ibmude@email.com",42245178,
//							"");
//
//			//new client 6:
//			double firstAmount=11550;
//			String accountComment="";
//			ClientBean newClient=new
//					ClientBean(64533604,"Shahar ben eliezer","tempSecret6",
//							cType,"rehovYefet, 8 , Eilat","shalie@email.com",12345678,
//							"client is deployed");
//
			//new client 7:
			double firstAmount=500;
			String accountComment="client like to reached over cellular only";
			ClientBean newClient=new
					ClientBean(22133244,"moria oz","tempSecret7",
							cType,"rehovHatikva, 12 , petach Tikva","moroz@email.com",12345678,
							" ");
//
			admin.addNewClient(newClient, firstAmount, accountComment);
//			admin.removeClient(33534604);
			System.out.println(admin.viewAccountDetails(22133244));
			System.out.println(admin.viewAllAccountDetails());
			System.out.println(admin.viewAllClientDetails());
			System.out.println(admin.viewAllDeposits());
			System.out.println(admin.viewAllActivities());
//			admin.updateSystemProperty("gold _daily_interest", "10");
		}
		catch (SQLException | ClientDoesNotExistException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientAlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotGenerateClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
