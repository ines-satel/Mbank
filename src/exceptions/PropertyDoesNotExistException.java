package exceptions;

public class PropertyDoesNotExistException extends Exception
{
	String message= "The property key you entered does not exist";

	public PropertyDoesNotExistException()
	{

	}
	
	public PropertyDoesNotExistException(String message, Throwable cause) 
	{
		super(cause);
		this.message=message;
	}

	public String getMessage() 
	{ 
		return message; 
	}
}
