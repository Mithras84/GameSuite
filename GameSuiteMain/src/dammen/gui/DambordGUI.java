/**
 * 
 */
package dammen.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import dammen.model.DamBord;
import dammen.model.Nodes;

/**
 * Class description
 * 
 * @version		1.00 15 jul. 2014
 * @author 		Pieter
 */
public class DambordGUI implements MouseMotionListener {
    JFrame frame;
    JPanel panel;
    JPanel bord;
    JLabel label;
    private Nodes[][] nodeBord;
    private DamBord dambord;
    
    public DambordGUI (DamBord dambord) {
	this.dambord = dambord;
	nodeBord = dambord.getSpeelbord();
	initFrame ();
	initPanels ();
	maakDambord();
    }
    

    
    private void initFrame () {
	frame = new JFrame ();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.setSize(ScreenSize.WIDTH, ScreenSize.HEIGHT + 10);
	
	frame.setVisible(true);
    }
    
    private void initPanels () {
	panel = new JPanel ();
	panel.setBounds(0, 0, ScreenSize.WIDTH, ScreenSize.HEIGHT + 10);
	panel.setLayout(new BorderLayout());
	
	bord = new JPanel ();
	bord.setBounds(0,10, ScreenSize.HEIGHT, ScreenSize.HEIGHT );
	bord.setLayout(null);
		
	label = new JLabel ();
	label.setText("Text");
		
	panel.add(label, BorderLayout.SOUTH);
	
	panel.add(bord, BorderLayout.CENTER);
	frame.add(panel);
	
    }   
        
    private void maakDambord () {
	
	for (int i = 0; i < nodeBord.length; i++) {
	    for (int j = 0; j < nodeBord.length; j++) {
		bord.add(nodeBord[i][j]);
		nodeBord[i][j].setNodeSize();
		nodeBord[i][j].addMouseMotionListener(this);
		System.out.println(nodeBord[i][j].getSize());
	    }
	}
	
	bord.repaint();
    }
    


    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }



    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	label.setText(e.getComponent().toString() );
	
    }

}
