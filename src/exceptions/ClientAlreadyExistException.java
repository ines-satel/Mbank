package exceptions;

public class ClientAlreadyExistException extends Exception 
{
	String message= "The client already exist";

	public ClientAlreadyExistException()
	{

	}

	public ClientAlreadyExistException (String message, Throwable cause) 
	{
		super (cause);
		this.message=message;
	}

	public String getMessage() 
	{ 
		return message; 
	}
}
