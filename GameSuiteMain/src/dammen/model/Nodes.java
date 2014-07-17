/**
 * 
 */
package dammen.model;

import java.awt.Color;
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

    public Nodes (int x, int y) {
	coord = new Coord (x,y);
	
	if (x%2 == 1 && y%2 == 1) 
	    this.kleur = "zwart";
	else if (x%2 == 0 && y%2 == 0)
	    this.kleur = "zwart";
	else 
	    this.kleur = "wit";
	setSize(ScreenSize.NODESIZE , ScreenSize.NODESIZE);
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
    
    public void setKleur (String kleur) {
	if (kleur == "zwart") 
	    this.kleur = "zwart";
	else if (kleur == "highlight") 
	    this.kleur = "highlight";
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
        
    public Coord getCoordLeft (int x, int y) {
	return new Coord ( x - 1, y + 1 );
    }
    
    public Coord getCoordRight (int x, int y) {
	return new Coord ( x + 1, y + 1 );
    }
    
    public Coord getCoord () {
	return coord;
    }
        
    public int getXCoord(){
	return coord.getX();
    }
    
    public int getYCoord(){
	return coord.getY();
    }
        
    public void paintComponent (Graphics g) {
	super.paintComponent(g);
	
	Graphics2D g2d = (Graphics2D) g;
	Rectangle block = new Rectangle (0, 0, ScreenSize.NODESIZE, ScreenSize.NODESIZE);
	if (kleur == "zwart") {
	    g2d.setColor(Color.darkGray);
	}else if (kleur == "wit"){ 
	    g2d.setColor(Color.white);
	} else if ( kleur == "highlight" ) {
	    g2d.setColor(Color.blue);
	}
	
	g2d.fill(block);
	g2d.draw(block);	
	
    }
    
}
