
/**
 * This class represents a grid where a Pusher game is played
 * @author chamboug
 * 
 */
public class Map {
	
	/**
	 * number of columns 
	 */
	private final int numberOfColumns;
	/**
	 *number of rows 
	 */
	private final int numberOfRows;
	
	/**
	 *  Square array which compose the map
	 */
	private final Square[][] map;
	
	
	/**
	 * Current player position
	 */
	private Position playerPosition;
	
	
	/**
	 * Return a new map ready to play
	 * @param squares which composes the map
	 */
	public Map(Square[][] squares)
	{
		this.numberOfRows = squares.length;
		this.numberOfColumns = squares[0].length;
		this.map = squares;
		
		this.playerPosition = this.searchPlayerPosition();
		
	}

	
	
	/**
	 * Return the current position of the player (used only once at the creation of the map)
	 * @return position of the player
	 */
	private Position searchPlayerPosition() 
	{

		for (int rowNumber = 0; rowNumber < this.numberOfRows; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < this.numberOfColumns; columnNumber++)
			{
				if (this.map[rowNumber][columnNumber].getMovableContent() instanceof Player)
					return new Position(rowNumber, columnNumber);
			}
		}
		
		return null;
		
	}
	
	/**
	 * Return the current position of the player
	 * @return position of the player
	 */
	public Position getPlayerPosition()
	{
		return this.playerPosition;
	}
	
	
	/**
	 * Change the player's position field
	 * @param p_playerPosition new player position
	 */
	public void setPlayerPosition(Position p_playerPosition)
	{
		this.playerPosition = p_playerPosition;
	}
	
	/**
	 * Return number of columns
	 * @return number of columns
	 */
	public int getNumberOfColumns()
	{
		return this.numberOfColumns;
	}
	
	/**
	 * Return number of rows
	 * @return numberOfRows
	 */
	public int getNumberOfRows()
	{
		return this.numberOfRows;
	}
	
	/**
	 * Return the quare at the given position
	 * @param p_position the position to search
	 * @return square at the position
	 */
	public Square getSquareAt(Position p_position)
	{
		return this.map[p_position.getX()][p_position.getY()];
	}
	
	
	/**
	 * Return the object Player when found in the map
	 * @return the player instance
	 */
	public Player getPlayer()
	{
		for (int rowNumber = 0; rowNumber < this.numberOfRows; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < this.numberOfColumns; columnNumber++)
			{
				if (this.map[rowNumber][columnNumber].getMovableContent() instanceof Player)
					return (Player)this.map[rowNumber][columnNumber].getMovableContent();
			}
		}
		
		return null;
	}
	
	
	/**
	 * Return the movable content at the position given in parameter
	 * @param p_position the position to look for
	 * @return movable content at the position
	 */
	public MovableItem getMovableContentAt(Position p_position)
	{
		return this.map[p_position.getX()][p_position.getY()].getMovableContent();
	}
	
	
	/**
	 * Return the fixed content at the position given in parameter
	 * @param p_position the position to look for
	 * @return fixed content at the position
	 */
	public FixedItem getFixedContentAt(Position p_position)
	{
		return this.map[p_position.getX()][p_position.getY()].getFixedContent();
	}
	
	
	/**
	 * Set the movable content at the position given in parameter
	 * @param p_position the position to look for
	 * @param p_movableItem the new movable content to put
	 */
	public void setMovableContentAt(Position p_position, MovableItem p_movableItem)
	{
		this.map[p_position.getX()][p_position.getY()].setMovableContent(p_movableItem);
	}
	
	public String toString()
	{
		String toReturn = "";

		for (int rowNumber = 0; rowNumber < this.numberOfRows; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < this.numberOfColumns; columnNumber++)
			{
				toReturn += this.map[rowNumber][columnNumber];
				if (columnNumber < this.numberOfColumns-1) toReturn+=";";
			}
			toReturn += "\n";
		}
		
		return toReturn;
	}


	
	/**
	 * Return a new Map ready to play
	 * @param fixedContentOfTheMap the formatted string to interpret
	 * @return new Map ready to play
	 */
	public static Map parseMap(String fixedContentOfTheMap) {
		
		int numberOfRows = fixedContentOfTheMap.split("\n").length;
		// int numberOfColumns = fixedContentOfTheMap.split("\n")[0].split(";").length;
		
		Square[][] squares = new Square[numberOfRows][];
		
		String lines[] =  fixedContentOfTheMap.split("\n");
		

		for (int currentRow = 0; currentRow < numberOfRows; currentRow++)
			squares[currentRow] = parseMapRow(lines[currentRow]);
		
		return new Map(squares);
		
	}



	/**
	 * Return a square array corresponding a row of the map
	 * @param rowAscii the string containing the formatted text of the row to parse
	 * @return new square array
	 */
	private static Square[] parseMapRow(String rowAscii) {
		
		String cellsAscii[] = rowAscii.split(";");
		Square[] squares = new Square[cellsAscii.length];
		
		for (int currentColumn = 0; currentColumn < squares.length; currentColumn++)
			squares[currentColumn] = Square.parseSquare(cellsAscii[currentColumn]);
		return squares;
			
	}
	
	
	/**
	 * Check if all boxes are on their exit
	 * @return true if all boxes are on their exit, false otherwise
	 */
	public boolean areAllBoxesOnExit()
	{
		for (int currentRow = 0; currentRow < this.numberOfRows; currentRow++)
		{
			for (int currentColumn = 0; currentColumn < this.numberOfColumns; currentColumn++)
			{
				FixedItem fixedCurrentSquareContent = this.map[currentRow][currentColumn].getFixedContent();
				MovableItem movableCurrentSquareContent = this.map[currentRow][currentColumn].getMovableContent();
				
				if (fixedCurrentSquareContent instanceof Exit)
				{
					if (!(movableCurrentSquareContent instanceof Box))
					{
						return false;
					}
					else if (movableCurrentSquareContent instanceof Box) 
					{
						if (((Box) movableCurrentSquareContent).getNumber() != ((Exit)fixedCurrentSquareContent).getExitNumber())
						{
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

}
