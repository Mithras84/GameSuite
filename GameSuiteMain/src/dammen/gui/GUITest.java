/**
 * 
 */
package dammen.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dammen.model.DamBord;
import dammen.model.Nodes;

/**
 * Class description
 * 
 * @version		1.00 15 jul. 2014
 * @author 		Pieter
 */
public class GUITest {
    JFrame frame;
    JPanel panel;
    JPanel bord;
    private Nodes[][] nodeBord;
    
    public GUITest () {	
	initFrame ();
	initPanels ();
	maakDambord();
    }
    

    
    private void initFrame () {
	frame = new JFrame ();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.setSize(ScreenSize.WIDTH, ScreenSize.HEIGHT);
	
	frame.setVisible(true);
    }
    
    private void initPanels () {
	panel = new JPanel ();
	panel.setBounds(0, 10, ScreenSize.WIDTH, ScreenSize.HEIGHT);
	panel.setLayout(null);
	
	bord = new JPanel ();
	bord.setBounds(0,0, 400,400);
	bord.setLayout(null);
	
	panel.add(bord);
	frame.add(panel);	
    }    
    
    private void maakDambord () {
	DamBord dambord = new DamBord (10,20);
	nodeBord = dambord.getSpeelbord();
	
	for (int i = 0; i < nodeBord.length; i++) {
	    for (int j = 0; j < nodeBord.length; j++) {
		bord.add(nodeBord[i][j]);
		nodeBord[i][j].setNodeSize();
	    }
	}
	
	bord.repaint();
    }

}
