
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * To ask the player in the console
 * @author chamboug
 *
 */
public class EntryConsole implements PlayerEntry
{
	

	public Direction getDirectionToGo()
	{
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = "";
		try
		{
			str = bufferedReader.readLine();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	    

		if (str.equals("d"))
			return Direction.RIGHT;
		else if (str.equals("q"))
			 return Direction.LEFT;
		else if (str.equals("z"))
			return Direction.UP;
		else if (str.equals("s"))
			return Direction.DOWN;
		else if (str.equals("give up"))
			return null;
		
		return Direction.NOWHERE;
	}
}
