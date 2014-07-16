/**
 * 
 */
package dammen.test;

import dammen.gui.DambordGUI;
import dammen.model.DamBord;

/**
 * Class description
 * 
 * @version		1.00 14 jul. 2014
 * @author 		Pieter
 */
public class TestSpeelbord {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	//DamBord bord = new DamBord(5,5);
	//bord.showBord();
	//bord.showLinks();
	DamBord dam = new DamBord (10,20);
	DambordGUI gui = new DambordGUI (dam);
	

    }

}
