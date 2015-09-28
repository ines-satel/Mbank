package beans;

public class AccountBean 
{
	//AccountBean class contains all the basic details of an account

	// Attributes
	private long accountId;
	private long clientId;
	private double balance;
	private double creditLimit;
	private String comment;

	// Constructors
	public AccountBean() 
	{

	}

	public AccountBean(long accountId, long clientId) 
	{
		this.accountId = accountId;
		this.clientId = clientId;
	}

	public AccountBean(long accountId, long clientId, double balance,
			double creditLimit, String comment) 
	{
		this.accountId = accountId;
		this.clientId = clientId;
		this.balance = balance;
		this.creditLimit = creditLimit;
		this.comment = comment;
	}

	// Setters & Getters

	public long getAccountId() 
	{
		return accountId;
	}

	public void setAccountId(long accountId) 
	{
		this.accountId = accountId;
	}

	public long getClientId() 
	{
		return clientId;
	}

	public void setClientId(long clientId) 
	{
		this.clientId = clientId;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public double getCreditLimit() 
	{
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) 
	{
		this.creditLimit = creditLimit;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment) 
	{
		this.comment = comment;
	}
	
	// toString method
	@Override
	public String toString() 
	{
		return "AccountBean [accountId=" + accountId + ", clientId=" + clientId
				+ ", balance=" + balance + ", creditLimit=" + creditLimit
				+ ", comment=" + comment + "]";
	}

}
