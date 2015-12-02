
public class Customer {

	public static String name;
	public int customerID;
	public String[] address;
	public String ccType;
	public String ccExpiration;
	public String ccNumber;
	
	
	public Customer()
	{
		
	}
	
	public Customer(int customerID, String[] address, String ccType, String ccExpiration, String ccNumber)
	{
		
		this.customerID = customerID;
		this.address = address;
		this.ccType = ccType;
		this.ccExpiration = ccExpiration;
		this.ccNumber = ccNumber;
	}
	
	public String toString()
	{
		
		return "";
	}
	
	

	
}
