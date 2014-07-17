/**
 * 
 */
package dammen.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

import dammen.gui.ScreenSize;

/**
 * Class description
 * 
 * @version 1.00 14 jul. 2014
 * @author Pieter
 */
public class DamSteen {
    
    private Color kleur;
    private Coord coord;

    public static int COUNT;
    public int id;

    public DamSteen(String kleur) {
	if (kleur == "zwart")
	    this.kleur = Color.black;
	else
	    this.kleur = Color.white;
	
	DamSteen.COUNT++;
	id = DamSteen.COUNT;
    }

    public DamSteen(Color kleur) {
	this.kleur = kleur;
	
	DamSteen.COUNT++;
	id = DamSteen.COUNT;
    }

    public void setCoord(Coord coord) {
	this.coord = coord;
    }

    public Coord getCoord() {
	return this.coord;
    }

    public String getKleurToString() {
	String res;
	
	if (this.kleur == Color.black)
	    res = "zwart";
	else
	    res = "wit";
	return res;
    }

    public void setKleur(Color color) {
	this.kleur = color;
    }

    public Color getKleur() {
	return this.kleur;
    }

    public String toString() {
	return this.getKleurToString() + " ID=" + id + " " + coord.getX() + ":"
		+ coord.getY();
    }
}
