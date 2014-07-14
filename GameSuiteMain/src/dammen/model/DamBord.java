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
    
    public DamBord(int rij, int kolom) {
	rijen = rij;
	kolommen = kolom;
	speelbord = new Nodes[rij][kolom];
	vulBord();
    }
    
    private void vulBord () {
	for (int i = 0; i < rijen ; i++ ) {
	    for (int j = 0; j < kolommen ; j++ ) {
		this.speelbord[i][j] = new Nodes (i,j);
	    }	    
	}
    }
    
    public void showBord () {
	for (int i = 0; i < rijen ; i++ ) {
	    for (int j = 0; j < kolommen ; j++ ) {
		System.out.println("X coordinaat: " + this.speelbord[i][j].getX() + " en Y coordinaat: " +
			this.speelbord[i][j].getY());
	    }	    
	}
    }

}
