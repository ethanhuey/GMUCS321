/*
 * if you are confused on the content number:
 * the first number in the array represents what we will do when we read in the string array
 * if we read in a content number 1, we know the information in the string array is information regarding making a reservation
 * if number is 4, we read that in and do a management report
 * the content numbers are first position in string array and tells us what we are going to do
 * 
 * how the parser works:
 * the parser reads a file and stores it into an array until an @ symbol shows up
 * the @ symbol lets us know the content number
 */
import java.io.FileNotFoundException;

public class DemoMain 
{
	public static void main(String[] args)
	{

		System.out.println("Demo\n");

		//parser to read file
		Parser parser = null;
		try {
			parser = new Parser("person.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] foo = parser.getNextInstruction();//string to hold file instructions

		/* print order (for the month of january): 
		 * 0. customer content 1 (see framework guide for details)
		 * 1. name
		 * 2. address
		 * 3. check in date (1-31) 
		 * 4. check out date (1-31)
		 * 5. room type (1 or 2)
		 * 6. number of occupants (1-4)
		 * 7. guaranteed? (0 = no, 1 = yes)
		 * 8. credit info (if 1 above)
		 * 9. credit expiration date
		 * 10. credit card number
		 * note: size of array varies if customer has credit card or not
		 */
		System.out.println("Make Reservation");
		for(int i = 0; i < foo.length; i++)
		{
			System.out.println(i + ": " + foo[i]);//print out first loop through file		
		}

		System.out.println("\n");


		/*
		 *  print order
		 *  0. content number
		 *  1. name
		 *  2. updated credit card info
		 *  3. credit card expiration date
		 *  4. credit card number
		 *  note: 2-4 do not need to be provided if customer initially gave credit card info
		 */
		System.out.println("Check In");
		String[] foo1 = parser.getNextInstruction();

		for(int i = 0; i < foo1.length; i++)
		{
			System.out.println(i + ": " + foo1[i]);			
		}

		System.out.println("\n");

		/*
		 * print order
		 * 0. content number
		 * 1. name
		 */
		System.out.println("Check Out");
		String[] foo2 = parser.getNextInstruction();

		for(int i = 0; i < foo2.length; i++)
		{
			System.out.println(i + ": " + foo2[i]);			
		}

		System.out.println("\n");


		/*
		 * pint order
		 * 0. content number
		 */
		System.out.println("Print Management Report");
		String[] foo3 = parser.getNextInstruction();

		for(int i = 0; i < foo3.length; i++)
		{
			System.out.println(i + ": " + foo3[i]);			
		}

		System.out.println("\n");


		/*
		 * print order
		 * 0. content number
		 * note in the file, this field lets us keep track of days until they check in
		 */
		System.out.println("Day Change Signal");
		String[] foo4 = parser.getNextInstruction();

		for(int i = 0; i < foo4.length; i++)
		{
			System.out.println(i + ": " + foo4[i]);			
		}

		System.out.println("\n");


		/*
		 * print order
		 * 0. 6pm Signal
		 * note this field lets us track not guaranteed reservation and make cancellations as needed
		 */
		System.out.println("6pm Signal");
		String[] foo5 = parser.getNextInstruction();

		for(int i = 0; i < foo5.length; i++)
		{
			System.out.println(i + ": " + foo5[i]);			
		}

	}
}

