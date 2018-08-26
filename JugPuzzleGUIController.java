package ca.utoronto.utm.jugpuzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * This class allows a console user to play an instance of JugPuzzle, using GUI.
 * It repeatedly gets user to click a "from" Jug and a "to" Jug, and
 * displays amount in each Jug, until the user solves JugPuzzle.
 * @author csc207 student
 *
 */
public class JugPuzzleGUIController {
	
	private JugPuzzle J; // The puzzle the console user will be playing
	private JugPuzzleView view = new JugPuzzleView(); //view for Observer and Observable
	
	/**
	 * Constructs a new JugPuzzleGUI controller with JugPuzzle, ready to
	 * to play with user through GUI.
	 */
	public JugPuzzleGUIController(){
		
		J = new JugPuzzle();
	}
		
	/**
	 * Constructs JButtons, JLabels, and inserts them into JPanels
	 * using BorderLayout for GUI. Connects buttons and other elements 
	 * of JugPuzzle to JugPuzzleActionListener. 
	 * 
	 */
	public void playJugPuzzleGUI(){	
		
		//adding Observer to observable JugPuzzle
		//did not create another Observer for Jugs, since
		//Jugs are represented by Graphics, and not through JLabels
		
		J.addObserver(view);
		
		JFrame f = new JFrame("Jug Puzzle");
		f.setSize(410, 350);
		Container c = f.getContentPane();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jugNumPanel = new JPanel();
		JPanel progressPanel = new JPanel();
		progressPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//buttons to display capacity of each jug
		JButton b0, b1, b2;
		
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		
		jugNumPanel.add(b0);
		jugNumPanel.add(b1);
		jugNumPanel.add(b2);
		
		//buttons to reset and quit
		JButton bQuit, bReset;
		
		bQuit = new JButton("X");
		bReset = new JButton("R");
		Dimension d = new Dimension(16,20);
		bQuit.setPreferredSize(d);
		bQuit.setForeground(Color.red);	
		bReset.setPreferredSize(d);
		bReset.setForeground(Color.BLUE);

		//label number of moves
		JLabel numMoves = view;
		JLabel result = new JLabel("");
		progressPanel.add(numMoves);
		progressPanel.add(result);
		
		//add Reset and Quit buttons next to moves
		progressPanel.add(bReset);
		progressPanel.add(bQuit);
		
		//drawing panel for rectangles
		DrawPanel rectPanel = new DrawPanel();
		
		//create Button press event handlers
		JugPuzzleActionListener action_b = new JugPuzzleActionListener(J, result, rectPanel, f);
		
		// Tell the buttons who they should call when they are pressed
		b0.addActionListener(action_b);
		b1.addActionListener(action_b);
		b2.addActionListener(action_b);
		bQuit.addActionListener(action_b);
		bReset.addActionListener(action_b);
	
		//add panels to container
		c.add(jugNumPanel, BorderLayout.NORTH);
		c.add(rectPanel, BorderLayout.CENTER);
		c.add(progressPanel, BorderLayout.SOUTH);
		f.setVisible(true);
}

	/**
	 * Create a single instance of the JugPuzzle, and run
	 * to play JugPuzzleGUI with user.
	 * @param args are not used	
	 */
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JugPuzzleGUIController g = new JugPuzzleGUIController();
				g.playJugPuzzleGUI();
			}
		});
	}
}
