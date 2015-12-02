import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser
{
  private String filename;
  private Scanner scan;
  private Integer nextInstruction;
  
  public Parser(String filename)
    throws FileNotFoundException
  {
    this.filename = filename;
    this.scan = new Scanner(new FileReader(filename));
    this.nextInstruction = Integer.valueOf(-1);
    if (this.scan.hasNextLine())
    {
      String nextLine = this.scan.nextLine();
      if (nextLine.startsWith("@")) {
        this.nextInstruction = Integer.valueOf(Integer.parseInt(nextLine.substring(1)));
      }
    }
  }
  
  public boolean hasNextInstruction()
  {
    if (this.nextInstruction.intValue() == -1) {
      return false;
    }
    return true;
  }
  
  public String[] getNextInstruction()
  {
    if (!hasNextInstruction()) {
      return null;
    }
    ArrayList<String> data = new ArrayList();
    
    data.add(this.nextInstruction.toString());
    while (this.scan.hasNextLine())
    {
      String nextLine = this.scan.nextLine().trim();
      if (!nextLine.isEmpty())
      {
        if (nextLine.startsWith("@"))
        {
          this.nextInstruction = Integer.valueOf(Integer.parseInt(nextLine.substring(1)));
          return (String[])data.toArray(new String[data.size()]);
        }
        data.add(nextLine);
      }
    }
    this.nextInstruction = Integer.valueOf(-1);
    return (String[])data.toArray(new String[data.size()]);
  }
}
