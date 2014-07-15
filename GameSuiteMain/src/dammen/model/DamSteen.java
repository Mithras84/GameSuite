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
public class DamSteen {
    private String kleur;
    private static int id = 0;
    
    public DamSteen (String kleur) {
	this.kleur = kleur;
	id++;
    }
    
    public String getKleur () {
	return this.kleur;
    }

}
