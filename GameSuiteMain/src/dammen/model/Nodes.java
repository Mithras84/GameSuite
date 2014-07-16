/**
 * 
 */
package dammen.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

import dammen.gui.ScreenSize;

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
    
    Dimension nodeSize;

    public Nodes (int x, int y) {
	nodeSize = new Dimension (ScreenSize.HEIGHT / 11, ScreenSize.HEIGHT / 11);
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
	this.setSize(nodeSize.width + (coord.getX() * nodeSize.width),
		nodeSize.height + (coord.getY() * nodeSize.height)); 
    }
    
    public void paintComponent (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	Rectangle block = new Rectangle (coord.getX() * nodeSize.width, coord.getY() * nodeSize.height,
		nodeSize.width , nodeSize.height);
	
	if (kleur == "zwart") {
	    g2d.setColor(Color.black);
	}else{ 
	    g2d.setColor(Color.white);
	}
	
	g2d.fill(block);
	g2d.draw(block);	
	
    }
    
}
