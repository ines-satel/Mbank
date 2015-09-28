package beans;

import java.sql.Date;

public class ActivityBean 
{
	//ActivityBean class contains all the basic details of an activity
	
	// Attributes
	private long id;
	private long clientId;
	private double amount;
	private Date activityDate;
	private double commission;
	private String description;

	// Constructors
	public ActivityBean() 
	{

	}

	public ActivityBean(long id, long clientId, double amount,
			Date activityDate, double commission, String description) 
	{
		this.id = id;
		this.clientId = clientId;
		this.amount = amount;
		this.activityDate = activityDate;
		this.commission = commission;
		this.description = description;
	}

	// Setters & Getters

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public long getClientId() 
	{
		return clientId;
	}

	public void setClientId(long clientId) 
	{
		this.clientId = clientId;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public Date getActivityDate() 
	{
		return activityDate;
	}

	public void setActivityDate(Date activityDate) 
	{
		this.activityDate = activityDate;
	}

	public double getCommission() 
	{
		return commission;
	}

	public void setCommission(double commission) 
	{
		this.commission = commission;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	// toString method
	@Override
	public String toString() 
	{
		return "ActivityBean [id=" + id + ", clientId=" + clientId
				+ ", amount=" + amount + ", activityDate=" + activityDate
				+ ", commission=" + commission + ", description=" + description
				+ "]";
	}

}
