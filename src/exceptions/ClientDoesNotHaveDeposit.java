package exceptions;

public class ClientDoesNotHaveDeposit extends Exception
{
	String message= "Client does not hava deposits";

	public ClientDoesNotHaveDeposit()
	{

	}
	
	public ClientDoesNotHaveDeposit (String message, Throwable cause) 
	{
		super(cause);
		this.message=message;
	}

	public String getMessage() 
	{ 
		return message; 
	}
}
