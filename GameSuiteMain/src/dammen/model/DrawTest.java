/**
 * 
 */
package dammen.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * Class description
 * 
 * @version		1.00 16 jul. 2014
 * @author 		Pieter
 */
public class DrawTest extends JComponent {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int sizeX;
    int sizeY;
    int posX;
    int posY;
    
    public DrawTest (int x, int y) {
	sizeX = 50;
	sizeY = 50;
	posX =  0;
	posY =  0;
	setSize(sizeX, sizeY);	
    }
    
    public void paintComponent(Graphics g) {
	
	super.paintComponent(g);
	
	Graphics2D g2d = (Graphics2D) g;
	
	Rectangle block = new Rectangle (posX, posY, 50, 50);
	
	g2d.setColor(Color.black);
	
	g2d.fill(block);
	g2d.draw(block);
    }

}
