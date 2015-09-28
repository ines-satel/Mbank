package exceptions;

public class CannotGenerateClientException extends Exception
{
	String message= "cannot generated new client and account"
					+ " when the first amount is lower then 1$";

	public CannotGenerateClientException()
	{

	}

	public CannotGenerateClientException (String message, Throwable cause) 
	{
		super (cause);
		this.message=message;
	}

	public String getMessage() 
	{ 
		return message; 
	}
}
