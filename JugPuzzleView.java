package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * This class observes JugPuzzle, and creates a View for JugPuzzle.
 * Every time a move is made in JugPuzzle, this class is notified.
 * After being notified, this class updates the number of moves
 * on a JLabel (which is displayed on GUI), and prints out
 * the amounts each Jug in the console. 
 * 
 * @author csc207 student
 *
 */
public class JugPuzzleView extends JLabel implements Observer{
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg == null){
			this.setText("Moves: 0");
		}
		else{
			this.setText((String) arg);
			System.out.println(o.toString());
			System.out.println(arg);
		}	
	}
}
