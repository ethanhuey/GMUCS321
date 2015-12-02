
public class FrontDeskClerkUserInterface 
{
	double registerCash;//cash in the register
	String[] loginInformation;//login credentials
	CheckoutScreen checkout;
	CheckinScreen checkin;
	
	//constructor
	public FrontDeskClerkUserInterface(double cash, String[] login, CheckoutScreen out, CheckinScreen in)
	{
		this.registerCash = cash;
		this.loginInformation = login;
	}
	
	//print statement for customer
	public String printStatement(Customer customer, Room room)
	{
		String s1 = "";
		return s1;
	}

}
