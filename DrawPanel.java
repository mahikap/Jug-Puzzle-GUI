package ca.utoronto.utm.jugpuzzle;
import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * DrawPanel visually constructs 3 Jugs, represented by 
 * 8, 5, and 3 rectangles respectively. It consists of a
 * method that creates graphics for a Jug, and this method is
 * used thrice to create 3 different Jugs at different positions.
 * DrawPanel contains 3 attributes, representing 3 integers
 * for the amount filled in each Jug. Create a new color
 * to portray the color of water. The methods in DrawPanel
 * will draw these jugs as filled/empty according to the
 * respective amounts
 * 
 * @author csc207 student
 *
 */
class DrawPanel extends JPanel {
	
	public int amt0;
	public int amt1;
	public int amt2;
	public Color water_blue = new Color(64, 164, 223);
    
	
	/**
	 * Draw n number of rectangles in a column, with the bottom
	 * amt of rectangles filled. Color these rectangles with
	 * water blue. Position this rectangle so it draws starting 
	 * at a given x_pos.
	 * 
	 * @param g Graphics component
	 * @param n integer, capacity of Jug
	 * @param amt integer, amount of Jug filled
	 * @param x_pos integer, x position to draw at 
	 */
	public void doDrawing(Graphics g, int n, int amt, int x_pos) { 
        
        Graphics2D gd = (Graphics2D) g;
       
        for (int i=0, x=x_pos, y=180, f=0; i< n; i++, y=y-20, f++){
        	gd.setColor(water_blue);
        	gd.drawRect(x,y, 40, 16);
        	if (f<amt){
        		gd.fillRect(x, y, 40, 16);
        	}}}
    
    /* 
     * Draw 3 different Jugs, with different capacities, amounts,
     * at different x positions, using Java Graphics' built-in
     * paintComponent.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g, 8, amt0, 110);
        doDrawing(g, 5, amt1, 185);
        doDrawing(g, 3, amt2, 255);
    }
}