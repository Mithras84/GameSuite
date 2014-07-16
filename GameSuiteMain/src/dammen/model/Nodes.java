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
 * Deze klasse representeerd een veld op het dambord.
 * Het veld kan wit of zwart zijn (wit wordt niet gebruikt).
 * Bevat de grootte (voor de GUI) als Dimension.
 * Extends JComponent (voor de GUI). 
 * Bevat een funtie om de coordinaten van de aangrenzende zwarte vakjes te geven.
 * Heeft een paintComponent functie (voor de GUI)
 * Aparte setSize functie (voor de GUI)
 * 
 * @todo 		Refactor, DamSteen toevoegen, functie voor aangrenzende vakje aanpassen (kan nu alleen voorruit).
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
    private DamSteen damsteen;
    
    Dimension nodeSize;

    public Nodes (int x, int y) {
	nodeSize = new Dimension (ScreenSize.NODESIZE, ScreenSize.NODESIZE);
	coord = new Coord (x,y);
	if (x%2 == 1 && y%2 == 1) 
	    this.kleur = "wit";
	else if (x%2 == 0 && y%2 == 0)
	    this.kleur = "wit";
	else 
	    this.kleur = "zwart";
    }
    
    public boolean hasDamsteen () {
	if (this.damsteen != null) 
	    return true;
	else return false;
    }
    
    public void setDamSteen (DamSteen steen) {
	this.damsteen = steen;
	this.damsteen.setCoord(this.coord);
    }
    
    public DamSteen getDamsteen () {
	return this.damsteen;
    }
    
    public String getKleur () {
	return this.kleur;
    }
    
    public String toString () {
	String res;
	if (this.damsteen != null) {
	    res = this.coord.getX() + " " + this.coord.getY() + " " + this.damsteen.toString();
	} else {
	    res = this.coord.getX() + " " + this.coord.getY() + " Geen Damsteen";
	}
	return res;
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
	return new Coord ( x + 1, y + 1 );
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
	    g2d.setColor(Color.darkGray);
	}else{ 
	    g2d.setColor(Color.white);
	}
	
	g2d.fill(block);
	g2d.draw(block);	
	
    }
    
}
