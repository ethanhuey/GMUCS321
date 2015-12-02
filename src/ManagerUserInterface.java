
public class ManagerUserInterface extends ReservationClerkUserInterface
{
	String[] login;
	Object manager;
	

	
	public ManagerUserInterface(String[] login, Object manager) {
		super(login, manager);
		this.login = login;
		this.manager = manager;
	}



	public void login(Object manager)
	{
		
	}
}
