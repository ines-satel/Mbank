package exceptions;

public class WithdrawException extends Exception 
{
	String message= "You are not allowed to withdrow from your account"
			+ "Your account balance is lower then your credit limit";

	public WithdrawException()
	{

	}

	public WithdrawException(String message, Throwable cause) 
	{
		super(cause);
		this.message=message;
	}

	public String getMessage() 
	{ 
		return message; 
	}
}
