/**
 * 
 */
package dammen.controller;

import dammen.gui.DambordGUI;
import dammen.model.DamBord;

/**
 * Class description
 * 
 * @version		1.00 14 jul. 2014
 * @author 		Pieter
 */
public class Dammen {
    private DamBord dambord;
    
    
    public Dammen () {
	nieuwSpel ();
    }
    
    public void nieuwSpel () {
	this.dambord = new DamBord (10,10);
	
	new DambordGUI ( this.dambord );
	//gui.maakDambord ();
	//gui.updateBord();
    }
    
    

}
