/**
 * 
 */
package dammen.model;

/**
 * Class description
 * Een klasse die per damsteen de mogelijke zetten opslaat, en -indien
 * gewenst- ervoor zorgt dat de zet gemaakt wordt.
 * 
 * @todo Nog veel toe te voegen. De AI moet ook gebruik kunnen maken van deze klasse.
 * 
 * @version		1.00 20 jul. 2014
 * @author 		Pieter
 */
public class Moves {
    
    private Nodes currentNode;
    private Nodes targetNode;
    
    /**
     * Constructor
     * 
     * @param current node
     * @param target node 
     */
    public Moves (Nodes current, Nodes target) {
	targetNode = target;
	currentNode = current;
    }
    
    public void makeMove () {
	DamSteen steen = currentNode.moveDamsteen();
	targetNode.setDamSteen(steen);
    }

    /**
     * @return the targetCoord
     */
    public Nodes getTargetNode() {
        return targetNode;
    }
    
    /**
     * @return the targetCoord
     */
    public Nodes getCurrentNode() {
        return currentNode;
    }
}
