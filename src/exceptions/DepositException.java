package exceptions;

public class DepositException extends Exception
{
	String message= "Problem accoured when trying to proccess a deposit action";

	public DepositException()
	{

	}
	
	public DepositException(String message, Throwable cause) 
	{
		super(cause);
		this.message=message;
	}

	public String getMessage() 
	{ 
		return message; 
	}
}
