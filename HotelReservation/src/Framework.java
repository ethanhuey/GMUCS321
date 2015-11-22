import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Framework
{
  public static final int NUM_SINGLE_ROOMS = 5;//number of rooms
  public static final int NUM_DOUBLE_ROOMS = 5;//number of rooms
  public static final int NUM_DAYS = 31;//month of january
  public static final int SINGLE_RATE = 80;//single room cost
  public static final int DOUBLE_RATE = 100;//double room cost
  public static final int STATUS_RESERVED = 1;//status code for reserved
  public static final int STATUS_CHECKED_IN = 2;
  public static final int STATUS_CHECKED_OUT = 3;
  public static final int STATUS_NO_SHOW = 4;//status code for no show
  public static final int STATUS_MUST_PAY = 5;
  
  private static ArrayList<Reservation> reservations = new ArrayList();
  private static int reservationIDCount = 0;
  
  private static ArrayList<Customer> customers = new ArrayList();
  private static int customerIDCount = 0;
  private static Parser parser;
  
  public static int storeReservation(Reservation res)
  {
    Reservation resCopy = copyReservation(res);
    resCopy.reservationID = reservationIDCount;
    reservationIDCount += 1;
    reservations.add(resCopy);
    return resCopy.reservationID;
  }
  
  public static boolean deleteReservation(int reservationID)
  {
    int indexToRemove = -1;
    for (int i = 0; i < reservations.size(); i++) {
      if (((Reservation)reservations.get(i)).reservationID == reservationID)
      {
        indexToRemove = i;
        break;
      }
    }
    if (indexToRemove == -1) {
      return false;
    }
    reservations.remove(indexToRemove);
    return true;
  }
  
  public static Reservation getReservationByID(int reservationID)
  {
    for (int i = 0; i < reservations.size(); i++) {
      if (((Reservation)reservations.get(i)).reservationID == reservationID) {
        return copyReservation((Reservation)reservations.get(i));
      }
    }
    return null;
  }
  
  public static Reservation getReservationByCID(int customerID)
  {
    for (int i = 0; i < reservations.size(); i++) {
      if (((Reservation)reservations.get(i)).customerID == customerID) {
        return copyReservation((Reservation)reservations.get(i));
      }
    }
    return null;
  }
  
  public static boolean modifyReservation(int reservationID, Reservation res)
  {
    int indexToReplace = -1;
    for (int i = 0; i < reservations.size(); i++) {
      if (((Reservation)reservations.get(i)).reservationID == reservationID)
      {
        indexToReplace = i;
        break;
      }
    }
    if (indexToReplace == -1) {
      return false;
    }
    Reservation resCopy = copyReservation(res);
    deleteReservation(reservationID);
    resCopy.reservationID = reservationID;
    reservations.add(resCopy);
    return true;
  }
  
  public static int storeCustomer(Customer cus)
  {
    Customer cusCopy = copyCustomer(cus);
    cusCopy.customerID = customerIDCount;
    customerIDCount += 1;
    customers.add(cusCopy);
    return cusCopy.customerID;
  }
  
  public static boolean deleteCustomer(int customerID)
  {
    int indexToRemove = -1;
    for (int i = 0; i < customers.size(); i++) {
      if (((Customer)customers.get(i)).customerID == customerID)
      {
        indexToRemove = i;
        break;
      }
    }
    if (indexToRemove == -1) {
      return false;
    }
    customers.remove(indexToRemove);
    return true;
  }
  
  public static Customer getCustomerByID(int customerID)
  {
    for (int i = 0; i < customers.size(); i++) {
      if (((Customer)customers.get(i)).customerID == customerID) {
        return copyCustomer((Customer)customers.get(i));
      }
    }
    return null;
  }
  
  public static Customer getCustomerByName(String name)
  {
    for (int i = 0; i < customers.size(); i++) {
      if (((Customer)customers.get(i)).name.equals(name)) {
        return copyCustomer((Customer)customers.get(i));
      }
    }
    return null;
  }
  
  public static boolean modifyCustomer(int customerID, Customer cus)
  {
    int indexToReplace = -1;
    for (int i = 0; i < customers.size(); i++) {
      if (((Customer)customers.get(i)).customerID == customerID)
      {
        indexToReplace = i;
        break;
      }
    }
    if (indexToReplace == -1) {
      return false;
    }
    Customer cusCopy = copyCustomer(cus);
    deleteCustomer(customerID);
    cusCopy.customerID = customerID;
    customers.add(cusCopy);
    return true;
  }
  
  private static Customer copyCustomer(Customer cus)
  {
    Customer cus2 = new Customer();
    cus2.customerID = cus.customerID;
    cus2.name = cus.name;
    cus2.address = cus.address;
    cus2.ccType = cus.ccType;
    cus2.ccNumber = cus.ccNumber;
    cus2.ccExpiration = cus.ccExpiration;
    return cus2;
  }
  
  private static Reservation copyReservation(Reservation res)
  {
    Reservation res2 = new Reservation();
    res2.reservationID = res.reservationID;
    res2.status = res.status;
    res2.startDate = res.startDate;
    res2.endDate = res.endDate;
    res2.roomType = res.roomType;
    res2.numOccupants = res.numOccupants;
    res2.guaranteed = res.guaranteed;
    res2.roomNumber = res.roomNumber;
    res2.customerID = res.customerID;
    return res2;
  }
  
  public static void init(String filename)
    throws FileNotFoundException
  {
    parser = new Parser(filename);
  }
  
  public static boolean hasNextInstruction()
  {
    return parser.hasNextInstruction();
  }
  
  public static String[] nextInstruction()
  {
    return parser.getNextInstruction();
  }
}