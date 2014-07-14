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
public class DamBord {
    private int rijen;
    private int kolommen;
    private Nodes[][] speelbord;
    
    /**
     * Constructor
     * Creeer een virtueel dambord op basis van de opgegeven specificaties 
     * @param rij
     * @param kolom
     */
    public DamBord(int rij, int kolom) {
	rijen = rij;
	kolommen = kolom;
	speelbord = new Nodes[rij][kolom];
	vulBord();
    }
    
    /**
     * Beschermde methode om het bord te vullen met 'Nodes':
     * Lege vlakken op het speelbord, die een damsteen kunnen bevatten.
     * @see dammen.model.Nodes
     */
    private void vulBord () {
	for (int i = 0; i < rijen ; i++ ) {
	    for (int j = 0; j < kolommen ; j++ ) {
		this.speelbord[i][j] = new Nodes (i,j);
	    }	    
	}
    }
    
    /**
     * Test functie. Laat alle Nodes op het bord zien.
     */
    public void showBord () {
	for (int i = 0; i < rijen ; i++ ) {
	    for (int j = 0; j < kolommen ; j++ ) {
		System.out.println("X coordinaat: " + this.speelbord[i][j].getX() + " en Y coordinaat: " +
			this.speelbord[i][j].getY());
	    }	    
	}
    }
    
    /**
     * Test functie. Achterhaal alle mogelijke 'links' tussen de nodes op het bord.
     */
    public void showLinks () {
	System.out.println("Neighbour left of coord 1 : 1 = " 
		+ speelbord[1][1].getCoordLeft(1, 1).toString() ) ;
	System.out.println("Neighbour right of coord 1 : 1 = " 
		+ speelbord[1][1].getCoordRight(1, 1).toString() ) ;
    }
    
    

}
