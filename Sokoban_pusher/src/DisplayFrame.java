
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


/**
 * Display messages in a frame
 * @author omelj
 *
 */
public class DisplayFrame extends JFrame implements PlayerDisplay
{
	private JPanel panelMap, menu, annexe;
	private JSplitPane separator;
	private HashMap<Position,JLabel> PlayerNBox = new HashMap<Position, JLabel>();

	public DisplayFrame()
	{
		setTitle("Sukoban");
		setResizable(false);
		setSize(1000,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Map
		this.panelMap = new JPanel();
		
		// annexes
		annexe = new JPanel();
		
		this.getContentPane().add(panelMap);
		this.getContentPane().add(annexe);
		
		this.setVisible(true);
	}

	public void displayMap(String formattedMap)
	{
		Map map = Map.parseMap(formattedMap);
		JLabel imageDelaCase;
		int rowNumber = map.getNumberOfRows();
		int columnNumber = map.getNumberOfColumns();
		GridLayout theMap = new GridLayout(rowNumber , columnNumber);
		this.panelMap.setLayout(theMap);
		panelMap.setSize(50*rowNumber, 60* columnNumber);

		for (int currentRow = 0; currentRow < map.getNumberOfRows(); currentRow++)
		{
			for (int currentColumn = 0; currentColumn < map.getNumberOfColumns(); currentColumn++)
			{
			
			if (map.getSquareAt(new Position(currentRow,currentColumn)).getFixedContent() == null)
			{
				imageDelaCase = new JLabel();
				this.panelMap.add(imageDelaCase);
				imageDelaCase.setBounds(0 + currentColumn *50, currentRow*50, 100, 100);
			}
			else if (map.getSquareAt(new Position(currentRow,currentColumn)).getFixedContent() instanceof Wall)
			{
				imageDelaCase = new JLabel(new ImageIcon(getClass().getResource("/img/mur.png")));
				this.panelMap.add(imageDelaCase);				
				imageDelaCase.setBounds(0 + currentColumn*50, currentRow*50, 100, 100);
			}
			else if (map.getSquareAt(new Position(currentRow,currentColumn)).getFixedContent() instanceof Exit)
			{
				imageDelaCase = new JLabel(new ImageIcon(getClass().getResource("/img/objectif.png")));
				this.panelMap.add(imageDelaCase);
				imageDelaCase.setBounds(0 + currentColumn*50, currentRow*50, 100, 100);
			}
			
			if (map.getSquareAt(new Position(currentRow,currentColumn)).getMovableContent() == null)
			{
				imageDelaCase = new JLabel();
				this.panelMap.add(imageDelaCase);
				imageDelaCase.setBounds(0 + currentColumn*50, currentRow*50, 100, 100);
			}
			else if (map.getSquareAt(new Position(currentRow,currentColumn)).getMovableContent() instanceof Player)
			{
				imageDelaCase = new JLabel(new ImageIcon(getClass().getResource("/img/mario_bas.png")));
				this.panelMap.add(imageDelaCase);
				imageDelaCase.setBounds(0 + currentColumn*50, currentRow*50, 100, 100);
				this.PlayerNBox.put(new Position(currentRow,currentColumn), imageDelaCase);
			}
			else if (map.getSquareAt(new Position(currentRow,currentColumn)).getMovableContent() instanceof Box)
			{
				imageDelaCase = new JLabel(new ImageIcon(getClass().getResource("/img/caisse.png")));
				this.panelMap.add(imageDelaCase);
				imageDelaCase.setBounds(0 + currentColumn*50, currentRow*50, 100, 100);
				this.PlayerNBox.put(new Position(currentRow,currentColumn), imageDelaCase);
			}
		}	
		}
	}

	@Override
	public void displayDirectionChoice()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayVictoryMessage()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayInvalidDirectionMessage()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayHowToGiveUpMessage()
	{
		
		
	}

	@Override
	public void displayGiveUpMessage()
	{
		JButton giveUp = new JButton("Give up..");
		annexe.add(giveUp);
		
	}
}

