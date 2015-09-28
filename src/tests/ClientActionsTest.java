package tests;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import actions.ClientActions;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientDoesNotHaveDeposit;
import exceptions.DepositException;
import exceptions.WithdrawException;

public class ClientActionsTest 
{
	public static void main(String[] args)
	{

		ClientActions client=new ClientActions();
		try {

			client.updateClientPassword(22133244, "newSecret1");
			client.updateClientAddress(22133244, "new address");
			client.updateClientEmail(22133244, "new email");
			client.updateClientComment(22133244, "new comment");
			client.updateClientPhone(22133244, 9988877);
			client.updateClientName(22133244, "moria oz-gilboa");


			client.withdrawFromAccount(22133244, 50);


			client.depositToAccount(22432317, 150);

			client.createNewDeposit(33433604, 500000.0, new java.sql.Date(2014-11-14) , new java.sql.Date(2025-06-14) );


			client.createNewDeposit(22133244, 100.0,new Date(Calendar.getInstance()
					.getTimeInMillis()),new Date(Calendar.getInstance()
							.getTimeInMillis()+31536000L * 1000) );

			client.preOpenDeposit(8);

			System.out.println(client.viewClientDetails(23437652));
			System.out.println(client.viewAccountDetails(23437652));
			System.out.println(client.viewClientActivities(23437652));
			System.out.println(client.viewClientDeposits(23437652));

		} catch (WithdrawException | SQLException | ClientDoesNotExistException | 
				DepositException | ClientDoesNotHaveDeposit e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}