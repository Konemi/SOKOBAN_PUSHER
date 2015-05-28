
/**
 * Contains a final fixed item, and could also contains a movable item which can change during the game
 * @author chamboug
 * 
 */
public class Square 
{
	/**
	 *  Initial content
	 */
	private final FixedItem fixedContent;
	
	/**
	 * Movable content
	 */
	private MovableItem movableContent;
	
	/**
	 * Creation of a square
	 * @param p_fixedItem the initial fixed item in the square
	 * @param p_movableItem the initial movable item on the square
	 */
	public Square(FixedItem p_fixedItem, MovableItem p_movableItem)
	{
		this.fixedContent = p_fixedItem;
		this.movableContent = p_movableItem;
	}
	
	/**
	 * get current fixed content
	 * @return fixedContent
	 */
	public FixedItem getFixedContent()
	{
		return this.fixedContent;
	}

	/**
	 * set movable content
	 * @param p_movableItem the new movable item
	 */
	public void setMovableContent(MovableItem p_movableItem)
	{
		this.movableContent = p_movableItem;
	}
	
	/**
	 * get current movable content
	 * @return movableContent
	 */
	public MovableItem getMovableContent()
	{
		return this.movableContent;
	}

	/**
	 * create fixed and movable items of a square by interpreting its associated character
	 * @param squareAscii the ascii form of the square
	 * @return Square quare created from the formatted text
	 */
	public static Square parseSquare(String squareAscii) {
		String[] tokens = squareAscii.split(",");
		
		char fixedItemChar = tokens[0].charAt(1);
		char movableItemChar = tokens[1].charAt(0);
		
		FixedItem fixedItem = null;
		MovableItem movableItem = null;
		
		
		if (Character.isDigit(fixedItemChar))
		{
			fixedItem = new Exit(Character.getNumericValue(fixedItemChar));
		}
		else if (fixedItemChar == 'f')
		{
			fixedItem = null;
		}
		else if (fixedItemChar == 'w')
		{
			fixedItem = new Wall();
		}
		
		
		if (Character.isDigit(movableItemChar))
		{
			movableItem = new Box(Character.getNumericValue(movableItemChar));
		}
		else if (movableItemChar == '-')
		{
			movableItem = null;
		}
		else if (movableItemChar == 'p')
		{
			movableItem = new Player();
		}

		return new Square(fixedItem, movableItem);

	}
	
	public String toString()
	{
		String toReturn = "[";
		
		if (this.getFixedContent() == null)
			toReturn += "f";
		else if (this.getFixedContent() instanceof Wall)
			toReturn += "w";
		else if (this.getFixedContent() instanceof Exit)
			toReturn += ((Exit)this.getFixedContent()).getExitNumber();
		
		toReturn += ",";
		
		if (this.getMovableContent() == null)
			toReturn += "-";
		else if (this.getMovableContent() instanceof Player)
			toReturn += "p";
		else if (this.getMovableContent() instanceof Box)
			toReturn += ((Box)this.getMovableContent()).getNumber();
		
		toReturn += "]";
		
		return toReturn;
	}
	
}