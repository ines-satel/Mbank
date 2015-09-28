package beans;

public class PropertiesBean 
{
	//PropertiesBean class contains all the basic details of a property

	// Attributes
	private String propertiesKey;
	private String propertiesValue;

	// Constructors
	public PropertiesBean() 
	{

	}

	public PropertiesBean(String propertiesKey, String propertiesValue) 
	{
		this.propertiesKey = propertiesKey;
		this.propertiesValue = propertiesValue;
	}

	// Setters & Getters

	public String getPropertiesKey() 
	{
		return propertiesKey;
	}

	public void setPropertiesKey(String propertiesKey) 
	{
		this.propertiesKey = propertiesKey;
	}

	public String getPropertiesValue() 
	{
		return propertiesValue;
	}

	public void setPropertiesValue(String propertiesValue) 
	{
		this.propertiesValue = propertiesValue;
	}

	// toString method
	@Override
	public String toString() 
	{
		return "PropertiesBean [propertiesKey=" + propertiesKey 
				+ ", propertiesValue=" + propertiesValue + "]";
	}
	

}
