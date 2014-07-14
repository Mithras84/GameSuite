/**
 * 
 */
package dammen.model;

/**
 * Class description
 * 
 * @version		1.00 14 jul. 2014
 * @author 		Pieter
 */
public class Coord {
    private int x;
    private int y;
    
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
    
    public boolean equals (Coord coord2) {
	if ( (coord2.getX() == this.getX()) && (coord2.getY() == this.getY()) )
	    return true;
	else 
	    return false;
    }
    
    public String toString () {
	return this.x + " " + this.y;
    }
    

}
