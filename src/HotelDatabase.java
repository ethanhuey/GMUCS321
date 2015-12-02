
public class HotelDatabase
{
	Customer customer;
	Reservation reservation;
	
	public HotelDatabase(Customer customer, Reservation reservation)
	{
				
		this.customer = customer;
		this.reservation = reservation;
	}
	
	public boolean validateCustomerInfo(Customer c1)
	{
		return false;
	}
	
	public String[] getReservationInfo(Customer c1, Reservation r1)
	{
		return null;
	}
	
	public String[] sendReservationInfo(Customer c1, Reservation r1)
	{
		String[] s1 = getReservationInfo(c1, r1);
		return s1;
	}
	
	public String[] getCustomerInfo(Customer c1, Reservation r1)
	{
		return null;
	}
	
	public boolean validateReservationInfo(Customer c1, Room r1)
	{
		return false;
	}
	
	

}
