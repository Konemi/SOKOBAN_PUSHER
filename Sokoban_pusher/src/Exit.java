
/**
 * is a Ground where there is a number associate to a unique box
 * @author chamboug
 *
 */
public class Exit extends FixedItem
{
	/**
	 * Number of the exit
	 */
	private int exitNumber;
	
	/**
	 * Return a new exit associated to a number
	 * @param p_exitNumber the number to associate
	 */
	public Exit (int p_exitNumber)
	{
		this.exitNumber = p_exitNumber;
	}
	
	/**
	 * Return the exit number
	 * @return the exit number
	 */
	public int getExitNumber()
	{
		return this.exitNumber;
	}
}
