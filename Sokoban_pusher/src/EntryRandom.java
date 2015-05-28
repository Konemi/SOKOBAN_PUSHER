
import java.util.Random;


/**
 * Player with automatic random choices, allows the game to play alone
 * @author chamboug
 *
 */
public class EntryRandom implements PlayerEntry{

	/**
	 * Random to generate choices
	 */
	private Random randomChoice;
	
	/**
	 * Moves counter
	 */
	private int counter;
	
	/**
	 * Return an EntryRandom ready to be used
	 */
	public EntryRandom()
	{
		this.randomChoice = new Random();
		this.counter = 0;
	}


	public Direction getDirectionToGo() {
		
		
		this.counter++;
		if (this.counter == 1000)
			return null;
		
		int choice = this.randomChoice.nextInt(4);
		
		
		if (choice == 1)
			return Direction.UP;
		else if (choice == 2)
			return Direction.DOWN;
		else if (choice == 3)
			return Direction.LEFT;
		
		return Direction.RIGHT;
		

	}

}
