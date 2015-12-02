
public class TimeStayed
{
	Customer customer;
	Room room;
	double timeStayed;
	
	public TimeStayed(Customer c1, Room r1, double time)
	{
		this.customer = c1;
		this.room = r1;
		this.timeStayed = time;
	}
	
	public boolean unreserve(Customer c1, Room r1)
	{
		return false;
	}	
	

}
