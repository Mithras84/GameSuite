/**
 * 
 */
package dammen.model;

/**
 * Class description
 * Klasse die de coordinaten van een node (veld op dambord) bevat.
 * Bevat op dit moment alleen getters en setters. Deze controleren of de
 * coordinaten wel juist zijn (alleen >= 0 op dit moment)
 * 
 * @todo 		Refactor, controle code herschrijven.
 * @version		1.00 14 jul. 2014
 * @author 		Pieter
 */
public class Coord {
    private int x; // Kolom
    private int y; // Rij
    
    /**
     * Creeer een nieuwe coordinaat.
     * @param x kolom
     * @param y rij
     */
    public Coord (int x, int y) {
	if (x >= 0)
	    this.x = x;
	else 
	    this.x = 0;
	
	if (y >= 0)
	    this.y = y;
	else 
	    this.y = 0;
    }
    
    public int getX () {
	return this.x;
    }
    
    public int getY () {
	return this.y;
    }
    
    public void setX (int x) {
	if (x >= 0)
	    this.x = x;
	else 
	    this.x = 0;
    }
    
    public void setY (int y) {
	if (y >= 0)
	    this.y = y;
	else 
	    this.y = 0;
    }
    
    public boolean equalsCoor (Coord coord) {
	if (coord.getX() == this.getX()
			&& coord.getY() == this.getY() )
	    return true;
	else
	    return false;	
    }
        
    public String toString () {
	return this.x + " " + this.y;
    }
    
}
