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
 * @todo 		Refactor, controle code herschrijven/weghalen. 
 * @version		1.00 14 jul. 2014
 * @author 		Pieter
 */
public class Coord {
    private int x; // Kolom
    private int y; // Rij
    
    static int kolommen;
    static int rijen;
    
    /**
     * Creeer een nieuwe coordinaat.
     * @param x kolom
     * @param y rij
     * @throws Exception 
     */
    public Coord (int x, int y) throws Exception {
	if (x >= 0 && x <= kolommen)
	    this.x = x;
	else 
	    throw new Exception ("Kolommen out of range!");
	
	if (y >= 0 && y <= rijen)
	    this.y = y;
	else 
	    throw new Exception ("Rijen out of range!");
    }
    
    public static void setLimits (int kolommen, int rijen) {
	Coord.kolommen = kolommen - 1;
	Coord.rijen = rijen - 1;
    }
    
    /**
     * @return the kolommen
     */
    public static int getKolommen() {
        return kolommen;
    }

    /**
     * @return the rijen
     */
    public static int getRijen() {
        return rijen;
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
