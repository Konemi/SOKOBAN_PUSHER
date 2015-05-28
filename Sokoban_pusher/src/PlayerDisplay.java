
/**
 * display message interface
 * @author chamboug
 *
 */
public interface PlayerDisplay
{

	
	/**
	 * Display the message that the game wait the player's direction choice
	 */
	public void displayDirectionChoice();

	/**
	 * Display the map
	 * @param formattedMap formatted text version of the map to display
	 */
	public void displayMap(String formattedMap);

	/**
	 * Display that the player won 
	 */
	public void displayVictoryMessage();
	
	/**
	 * Display that the direction choosen is invalid
	 */
	public void displayInvalidDirectionMessage();

	/**
	 * Display how the player can give up
	 */
	public void displayHowToGiveUpMessage();
	
	/**
	 * Display that the player gived up
	 */
	public void displayGiveUpMessage();

}
