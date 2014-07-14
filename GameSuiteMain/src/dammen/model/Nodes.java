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
    private int xCor;
    private int yCor;

    public Nodes (int x, int y) {
	xCor = x;
	yCor = y;
    }
    
    public Nodes getNode (int x, int y) {
	if (x == xCor && y == yCor) 
	    return this;
	else 
	    return null;
    }
    
    public int getX(){
	return xCor;
    }
    
    public int getY(){
	return yCor;
    }
    
    public int getLinks () {
	if (xCor - 1 != 0) 
	    return 0;
	else 
	    return xCor - 1;
    }
}
