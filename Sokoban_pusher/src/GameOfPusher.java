

/**
 * Create a pusher game
 * @author chamboug
 * 
 */

public class GameOfPusher
{
	/**
	 * The map containing game items
	 */
	private Map map;
	
	/**
	 * console player
	 */
	private PlayerEntry playerEntry;
	
	/**
	 * display console information
	 */
	private PlayerDisplay playerDisplay;
	
	/**
	 * Creation of a new pusher game
	 * with an initialized map
	 * @param p_map the map to be used
	 * @param p_playerEntry the player entry interface
	 * @param p_playerDisplay the player display interface
	 */
	public GameOfPusher(Map p_map, PlayerEntry p_playerEntry, PlayerDisplay p_playerDisplay)
	{
		this.map = p_map;
		
		this.playerEntry = p_playerEntry;
		this.playerDisplay = p_playerDisplay;
		
	}
	
	
	/**
	 * Start the game
	 */
	public void play()
	{
		
		boolean isFinished = false;
		while(!isFinished)
		{
			this.playerDisplay.displayMap(this.map.toString());
			this.playerDisplay.displayDirectionChoice();
			this.playerDisplay.displayHowToGiveUpMessage();
			
			Direction directionToGo = this.playerEntry.getDirectionToGo();

			if (directionToGo == null)
			{				
				this.playerDisplay.displayGiveUpMessage();
				return;
			}
			else
			{
				this.moveTo(directionToGo);
			}
				
			
			if (this.map.areAllBoxesOnExit())
			{
				this.playerDisplay.displayMap(this.map.toString());
				this.playerDisplay.displayVictoryMessage();
				return;
			}

		}
		
	}
	
	
	/**
	 * move a movable item into a direction
	 * @param p_direction direction to go
	 * @return if their was a move or not
	 */
	public boolean moveTo(Direction p_direction)
	{
		
		
		Position playerPosition = this.map.getPlayerPosition();
		
		if (p_direction == Direction.RIGHT)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1)) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1)) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 2)) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 2)) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 2), this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1)));
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() + 1));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() + 1), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() + 1));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
			
			
			
		}
		else if (p_direction == Direction.LEFT)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1)) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1)) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 2)) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 2)) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 2), this.map.getMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1)));
					this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() - 1));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX(), playerPosition.getY() - 1), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX(), playerPosition.getY() - 1));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
		}
		else if (p_direction == Direction.UP)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY())) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY())) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX() - 2, playerPosition.getY())) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX() - 2, playerPosition.getY())) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX() - 2, playerPosition.getY()), this.map.getMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY())));
					this.map.setMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY()), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX() - 1, playerPosition.getY()));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX() - 1, playerPosition.getY()), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX() - 1, playerPosition.getY()));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
			
			
			
		}
		else if (p_direction == Direction.DOWN)
		{
			
			if (this.map.getFixedContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY())) instanceof Wall)
			{
				return false;
			}

			if (this.map.getMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY())) instanceof Box)
			{
				if (!(this.map.getMovableContentAt(new Position(playerPosition.getX() + 2, playerPosition.getY())) instanceof Box) && 
					!(this.map.getFixedContentAt(new Position(playerPosition.getX() + 2, playerPosition.getY())) instanceof Wall))
				{
					this.map.setMovableContentAt(new Position(playerPosition.getX() + 2, playerPosition.getY()), this.map.getMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY())));
					this.map.setMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY()), this.map.getPlayer());
					this.map.setMovableContentAt(playerPosition, null);
					
					this.map.setPlayerPosition(new Position(playerPosition.getX() + 1, playerPosition.getY()));
					
					return true;
				}
				return false;
			}
				
			this.map.setMovableContentAt(new Position(playerPosition.getX() + 1, playerPosition.getY()), this.map.getPlayer());
			this.map.setPlayerPosition(new Position(playerPosition.getX() + 1, playerPosition.getY()));
			this.map.setMovableContentAt(playerPosition, null);
			return true;
			
			
			
		}
		else
		{
			this.playerDisplay.displayInvalidDirectionMessage();
		}
		
		return false;
	}
}
