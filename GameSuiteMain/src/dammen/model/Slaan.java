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
    
    private DamSteen currentSteen;
    private Nodes targetNodeSteen;

    /**
     * @param current
     * @param target
     */
    public Slaan(Nodes currentNode, Nodes targetNode, Nodes targetNodeSteen) {
	super(currentNode, targetNode);
	// TODO Auto-generated constructor stub
	this.targetNodeSteen = targetNodeSteen;
    }
    
    public void makeMove () {
	super.makeMove();
	this.targetNodeSteen.removeDamSteen();
	
    }

    /**
     * @return the targetSteen
     */
    public Nodes getTargetNodeSteen() {
        return targetNodeSteen;
    }

    /**
     * @return the steen
     */
    public DamSteen getCurrentSteen() {
        return currentSteen;
    }
    
    
    
    
    
    

}
