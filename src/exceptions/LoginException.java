package exceptions;

public class LoginException extends Exception 
{
	String message= "Password / username is not correct";

	public LoginException()
	{

	}
	
	public LoginException(String message, Throwable cause) 
	{
		super(cause);
		this.message=message;
	}

	public String getMessage() 
	{ 
		return message; 
	}
}
