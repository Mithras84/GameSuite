/**
 * 
 */
package dammen.model;

import java.awt.Color;

/**
 * Class description
 * 
 * @version		1.00 18 jul. 2014
 * @author 		Pieter
 */
public class Player {
    private Color kleur;
    
    public Player (String kleur) {
	if (kleur == "wit") {
	    this.kleur = Color.white;
	} else {
	    this.kleur = Color.black;
	}
    }
    
    public Player (Color color) {
	this.kleur = color;
    }
    
    public Color getKleur () {
	return this.kleur;
    }
    
    public String getKleurToString () {
	if (kleur == Color.white)
	    return "wit";
	else 
	    return "zwart";
    }

}
