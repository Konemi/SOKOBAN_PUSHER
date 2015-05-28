
/**
 * Position composed by 2 integer : x and y
 * @author chamboug
 *
 */
public class Position {
	
	/**
	 * The x component
	 */
	private final int x;
	
	/**
	 * The y component
	 */
	private final int y;
	
	/**
	 * Return a new position ready to be used
	 * @param p_x x component
	 * @param p_y y component
	 */
	public Position(int p_x, int p_y)
	{
		this.x = p_x;
		this.y = p_y;
	}
	
	/**
	 * Return x component
	 * @return x component
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Return y component
	 * @return y component
	 */
	public int getY()
	{
		return this.y;
	}
	
	public String toString()
	{
		return "X : " + this.x + "      Y : " + this.y;
	}
}
