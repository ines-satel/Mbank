package exceptions;

public class ClientDoesNotExistException  extends Exception
{
	String message= "Client does not exist, please enter defferent client id";
	
	public ClientDoesNotExistException()
	{
		
	}
	
    public ClientDoesNotExistException (String message, Throwable cause) 
    {
    	super(cause);
    	this.message=message;
    }
    
    public String getMessage() 
    { 
    	return message; 
    }
}
