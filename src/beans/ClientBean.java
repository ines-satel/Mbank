package beans;

public class ClientBean 
{
	//ClientBean class contains all the basic details of a client

	// Attributes
	private long clientId;
	private String clientName;
	private String password;
	private ClientType type; // Enum ClientType: REGULAR,GOLD,PLATINUM
	private String address;
	private String email;
	private long phone;
	private String comment;

	// Constructors
	public ClientBean() 
	{

	}

	public ClientBean(ClientType type) 
	{
		this.type = type;
	}

	public ClientBean(long clientId, String clientName, String password,
			ClientType type, String address, String email, long phone,
			String comment) 
	{
		this.clientId = clientId;
		this.clientName = clientName;
		this.password = password;
		this.type = type;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.comment = comment;
	}

	// Setters & Getters

	public long getClientId() 
	{
		return clientId;
	}

	public void setClientId(long clientId) 
	{
		this.clientId = clientId;
	}

	public String getClientName() 
	{
		return clientName;
	}

	public void setClientName(String clientName) 
	{
		this.clientName = clientName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public ClientType getType() 
	{
		return type;
	}

	public void setType(ClientType type) 
	{
		this.type = type;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public long getPhone() 
	{
		return phone;
	}

	public void setPhone(long phone) 
	{
		this.phone = phone;
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
		return "ClientBean [clientId=" + clientId + ", clientName=" +
				clientName + ", password=" + password + ", type="
				+ type + ", address=" + address + ", email=" + email +
				", phone=" + phone + ", comment=" + comment+ "]";
	}
}
