/**
 * 
 */
package dammen.model;

/**
 * Class description
 * 
 * @version		1.00 21 jul. 2014
 * @author 		Pieter
 */
public class Slaan extends Moves {
    
    private DamSteen steen;

    /**
     * @param current
     * @param target
     */
    public Slaan(Nodes current, Nodes target, DamSteen steen) {
	super(current, target);
	// TODO Auto-generated constructor stub
	this.steen = steen;
    }

    /**
     * @return the steen
     */
    public DamSteen getSteen() {
        return steen;
    }
    
    
    
    
    
    

}
