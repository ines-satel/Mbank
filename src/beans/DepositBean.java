package beans;

import java.sql.Date;

public class DepositBean 
{
	//DepositBean class contains all the basic details of a deposit

	// Attributes
	private long depositId;
	private long clientId;
	private double balance;
	private DepositType type; // Enum DepositType: SHORT,LONG
	private double estimatedBalance;
	private Date openingDate;
	private Date closingDate;
	
	// Constructors
	public DepositBean() 
	{

	}

	public DepositBean(long depositId, long clientId, double balance,
			double estimatedBalance, DepositType type, Date openingDate,
			Date closingDate) 
	{
		this.depositId = depositId;
		this.clientId = clientId;
		this.balance = balance;
		this.type = type;
		this.estimatedBalance = estimatedBalance;
		this.openingDate = openingDate;
		this.closingDate = closingDate;
	}
	

	// Setters & Getters

	public long getDepositId() 
	{
		return depositId;
	}

	public void setDepositId(long depositId) 
	{
		this.depositId = depositId;
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

	public DepositType getType() 
	{
		return type;
	}

	public void setType(DepositType type) 
	{
		this.type = type;
	}

	public double getEstimatedBalance() 
	{
		return estimatedBalance;
	}

	public void setEstimatedBalance(double estimatedBalance) 
	{
		this.estimatedBalance = estimatedBalance;
	}

	public Date getOpeningDate() 
	{
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) 
	{
		this.openingDate = openingDate;
	}

	public Date getClosingDate() 
	{
		return closingDate;
	}

	public void setClosingDate(Date closingDate) 
	{
		this.closingDate = closingDate;
	}
	
	// toString method
	@Override
	public String toString() 
	{
		return "DepositBean [depositId=" + depositId + ", clientId=" + clientId
				+ ", balance=" + balance + ", type=" + type
				+ ", estimatedBalance=" + estimatedBalance + ", openingDate="
				+ openingDate + ", closingDate=" + closingDate + "]";
	}

}
