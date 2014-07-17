/**
 * 
 */
package dammen.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import dammen.gui.ScreenSize;

/**
 * Class description
 * 
 * @version		1.00 14 jul. 2014
 * @author 		Pieter
 */
public class DamSteen extends JComponent {
    
    private static final long serialVersionUID = 6701312830890255850L;
    private Color kleur;
    private Coord coord;
    
    Dimension steenSize;
    
    public static int COUNT;
    public int id;
        
    public DamSteen (String kleur) {
	if (kleur == "zwart")
	    this.kleur = Color.black;
	else 
	    this.kleur = Color.white;
	DamSteen.COUNT++;
	id = DamSteen.COUNT;
	setSize (ScreenSize.NODESIZE , ScreenSize.NODESIZE );
    }
    
    public DamSteen (Color kleur) {
	this.kleur = kleur;
	DamSteen.COUNT++;
	id = DamSteen.COUNT;
	setSize (ScreenSize.NODESIZE , ScreenSize.NODESIZE );
    }
    
    public void setCoord (Coord coord) {
	this.coord = coord;
    }
    
    public Coord getCoord () {
	return this.coord;
    }
    
    public String getKleurToString () {
	String res;
	if (this.kleur == Color.black) 
	    res = "zwart";
	else 
	    res = "wit";
	return res;
    }
    
    public void setKleur (Color color) {
	this.kleur = color;
    }
    
    public Color getKleur () {
	return this.kleur;
    }
    
    public String toString () {
	return this.getKleurToString() + " ID=" + id + " " + coord.getX() + ":" + coord.getY();
    }
    
    public String getSteenSize () {
	return "" + this.steenSize.getSize();
    }
    
   public void paintComponent (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	Ellipse2D circle = new Ellipse2D.Double(5,5,ScreenSize.NODESIZE-10,ScreenSize.NODESIZE-10);
	g2d.setColor(this.kleur);
	
	g2d.fill(circle);
	g2d.draw(circle);	
	
    }

}
