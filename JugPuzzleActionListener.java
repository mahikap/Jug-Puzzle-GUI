package ca.utoronto.utm.jugpuzzle;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * JugPuzzleActionListener is called when buttons are pressed in
 * JugPuzzleGUIController. 
 * User can "Quit", "Restart", or click on Jug Buttons to
 * spill from one Jug to another. These JugButtons 
 * stop functioning once JugPuzzle is solved, however users can still
 * Quit or Restart after solving a puzzle. 
 * 
 * @author csc207 student
 *
 */
public class JugPuzzleActionListener implements ActionListener{
	
	JugPuzzle J;
	JLabel result;
	int from_click;
	boolean is_from_click;
	DrawPanel rectPanel;
	JFrame f;
	
	/**
	 * Constructs an instance of JugPuzzleActionListener, 
	 * with attributes defined in Controller. 
	 * Set all Jug amounts at the beginning when new game is created,
	 * ie. Jug 0 is fully filled, and Jug1 and Jug2 are empty.
	 * 
	 * @param J JugPuzzle, 
	 * 				the game currently being played
	 * 
	 * @param result JLabel, 
	 * 				text to be displayed after winning
	 * 
	 * @param rectPanel DrawPanel, 
	 * 				panel that draws the empty/filled rectangles
	 * 
	 * @param f JFrame,
	 * 				the current Frame the game is being played in
	 */
	JugPuzzleActionListener(JugPuzzle J, JLabel result, DrawPanel rectPanel,
			JFrame f){
		this.J = J;
		this.result = result;
		this.rectPanel = rectPanel;
		this.f = f;
		resetAmounts();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//if player wants to quit the game
		if (e.getActionCommand() == "X" ){ 
			System.exit(0);
		}
		
		//if player wants to restart
		if (e.getActionCommand() == "R"){
			this.f.dispose();
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					JugPuzzleGUIController g = new JugPuzzleGUIController();
					g.playJugPuzzleGUI();
				}
			});
		}
		
		//player is selecting the "from" jug
		else if (is_from_click == false){
			from_click = Integer.parseInt(e.getActionCommand());
			is_from_click = true;
			resetAmounts();	
		}
		
		//player has selected "from" and selects "to" jug
		//changing amounts occur
		else{
			if (!this.J.getIsPuzzleSolved()) {
				int from = from_click;
				int to = Integer.parseInt(e.getActionCommand());
				J.move(from, to);
				is_from_click = false;

				System.out.println(this.J);
				resetAmounts();
					
				if (this.J.getIsPuzzleSolved()) {
					rectPanel.water_blue = new Color(60, 179, 113);
					result.setText("Congrats! You solved it in " + J.getMoves() + " moves!!");	
				}	
			}
		}
	}
	
	/**
	 * Attains the changed amounts of the Jugs after a move
	 * and repaints the graphics to represent the differently
	 * filled rectangles.
	 * 
	 */
	public void resetAmounts(){
		rectPanel.amt0 = J.getJugs()[0].getAmount();
		rectPanel.amt1 = J.getJugs()[1].getAmount();
		rectPanel.amt2 = J.getJugs()[2].getAmount();
		this.rectPanel.repaint();
	}
	
	
}



