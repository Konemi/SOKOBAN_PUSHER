
/**
 * Display messages in the console
 * @author chamboug
 *
 */
public class DisplayConsole implements PlayerDisplay
{
	public void displayDirectionChoice()
	{
		System.out.println("Please choose a direction using Z,Q,S,D");
	}
	
	public void displayMap(String formattedMap)
	{
		Map map = Map.parseMap(formattedMap);
		
		String toReturn = "";

		for (int columnNumber = 0; columnNumber < map.getNumberOfColumns() * 5; columnNumber++)
		{
			toReturn += "-";
		}
		toReturn += "\n";


		for (int rowNumber = 0; rowNumber < map.getNumberOfRows(); rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < map.getNumberOfColumns(); columnNumber++)
			{
				if (map.getSquareAt(new Position(rowNumber, columnNumber)).getFixedContent() == null)
					toReturn += "  ";
				else if (map.getSquareAt(new Position(rowNumber, columnNumber)).getFixedContent() instanceof Wall)
					toReturn += " X";
				else if (map.getSquareAt(new Position(rowNumber, columnNumber)).getFixedContent() instanceof Exit)
					toReturn += "E" + ((Exit)map.getSquareAt(new Position(rowNumber, columnNumber)).getFixedContent()).getExitNumber();
				
				if (map.getSquareAt(new Position(rowNumber, columnNumber)).getMovableContent() == null)
					toReturn += "  ";
				else if (map.getSquareAt(new Position(rowNumber, columnNumber)).getMovableContent() instanceof Player)
					toReturn += " P";
				else if (map.getSquareAt(new Position(rowNumber, columnNumber)).getMovableContent() instanceof Box)
					toReturn += "B" + ((Box)map.getSquareAt(new Position(rowNumber, columnNumber)).getMovableContent()).getNumber();
				
				toReturn += "|";
			}
			
			toReturn += "\n";
			for (int columnNumber = 0; columnNumber < map.getNumberOfColumns() * 5; columnNumber++)
			{
				toReturn += "-";
			}
			toReturn += "\n";
		}
		
		System.out.println(toReturn);
	}
	
	public void displayVictoryMessage()
	{
		System.out.println("Victory !");
	}
	
	public void displayInvalidDirectionMessage()
	{
		System.out.println("Invalid direction");
	}
	
	public void displayHowToGiveUpMessage()
	{
		System.out.println("Type \"give up\" to stop your game");
	}
	
	public void displayGiveUpMessage()
	{
		System.out.println("You give up, pusher's stronger than you!");
	}


}
