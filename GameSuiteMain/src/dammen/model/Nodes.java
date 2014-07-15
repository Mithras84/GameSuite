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
 * @version		1.00 14 jul. 2014
 * @author 		Pieter
 */
public class Nodes extends JComponent {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String kleur;
    private Coord coord;

    public Nodes (int x, int y) {
	coord = new Coord (x,y);
	if (x%2 == 1 && y%2 == 1) 
	    this.kleur = "zwart";
	else if (x%2 == 0 && y%2 == 0)
	    this.kleur = "zwart";
	else 
	    this.kleur = "wit";
    }
    
    public String getKleur () {
	return this.kleur;
    }
    
    public String toString () {
	return this.coord.getX() + " " + this.coord.getY() + " " + this.kleur;
    }
    
    public Nodes getNode (int x, int y) {
	if (x == coord.getX() && y == coord.getY() ) 
	    return this;
	else 
	    return null;
    }
    
    public Nodes getNode (Coord coord) {
	if (this.coord.equals(coord)) 
	    return this;
	else 
	    return null;
    }
    
    public Coord getCoordLeft (int x, int y) {
	if (x >= 1 )
	    return new Coord ( x - 1, y + 1 );
	else
	    return null;
    }
    
    public Coord getCoordRight (int x, int y) {
	return new Coord ( x, y + 1 );
    }
    
    public Coord getCoord () {
	return coord;
    }
        
    public int getX(){
	return coord.getX();
    }
    
    public int getY(){
	return coord.getY();
    }
    
    public void setNodeSize () {
	this.setSize(30 + (coord.getX() * 30), 30 + (coord.getY() * 30)); 
    }
    
    public void paintComponent (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	Rectangle block = new Rectangle (coord.getX() * 30, coord.getY() * 30, 30 , 30);
	
	if (kleur == "zwart") {
	    g2d.setColor(Color.black);
	}else{ 
	    g2d.setColor(Color.white);
	}
	
	g2d.fill(block);
	g2d.draw(block);	
	
    }
    
}
