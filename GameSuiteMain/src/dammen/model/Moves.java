/**
 * 
 */
package dammen.model;

/**
 * Class description
 * 
 * @version		1.00 20 jul. 2014
 * @author 		Pieter
 */
public class Moves {
    
    private Coord targetCoord;
    private Coord currentCoord;
    
    /**
     * Constructor
     * 
     * @param current coordinate
     * @param target coordinate (coord of free Node)
     */
    public Moves (Coord current, Coord target) {
	targetCoord = target;
	currentCoord = current;
    }

    /**
     * @return the targetCoord
     */
    public Coord getTargetCoord() {
        return targetCoord;
    }
    
    /**
     * @return the targetCoord
     */
    public Coord getCurrentCoord() {
        return currentCoord;
    }
    
    

}
