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
public class Nodes {
    private Coord coord;

    public Nodes (int x, int y) {
	coord = new Coord (x,y);
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
    
}
