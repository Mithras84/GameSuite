/**
 * 
 */
package dammen.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dammen.model.Coord;
import dammen.model.DamBord;
import dammen.model.Nodes;

/**
 * Class description
 * 
 * @version		1.00 15 jul. 2014
 * @author 		Pieter
 */
public class DambordGUI implements MouseListener {
    JFrame frame;
    JPanel panel;
    JPanel bord;
    JLabel label;
    private DamBord dambord;
    
    public DambordGUI (DamBord dambord) {
	this.dambord = dambord;
	
	initFrame ();
	initPanels ();
	//maakDambord();
    }
    

    
    private void initFrame () {
	frame = new JFrame ();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.setSize(ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 70);
	
	frame.setVisible(true);
    }
    
    private void initPanels () {
	panel = new JPanel ();
	//panel.setBounds(0, 0, ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 75);
	panel.setLayout(new BorderLayout());
	
	bord = new JPanel ();
	bord.setBounds(0,0, ScreenSize.WIDTH, ScreenSize.HEIGHT );
	bord.setLayout(null);
		
	label = new JLabel ();
	label.setText("Text");
		
	panel.add(label, BorderLayout.SOUTH);
	
	panel.add(bord, BorderLayout.CENTER);
	frame.add(panel);
	
    }   
        
    public void maakDambord () {
	
	for (int i = 0; i < dambord.getKolommen(); i++) {
	    for (int j = 0; j < dambord.getRijen(); j++) {
		bord.add(dambord.getSpeelbord()[i][j]);
		dambord.getSpeelbord()[i][j].setNodeSize();
		dambord.getSpeelbord()[i][j].addMouseListener(this);
		System.out.println(dambord.getSpeelbord()[i][j].getSize());
	    }
	}	
	bord.repaint();
    }
    
    public void updateBord () {
	for (int i = 0; i < dambord.getKolommen(); i++) {
	    for (int j = 0; j < dambord.getRijen(); j++) {
		if (dambord.getSpeelbord()[i][j].hasDamsteen() ) {
		    dambord.getSpeelbord()[i][j].add(dambord.getSpeelbord()[i][j].getDamsteen());
		    dambord.getSpeelbord()[i][j].getDamsteen().setSteenSize();
		    System.out.println (dambord.getSpeelbord()[i][j].getDamsteen().getSize() );		    
		}
	    }
	}	
	bord.repaint();
    }
    
    public void highlightNode (Coord coord) {
	if (coord != null) {
	    if (dambord.getSpeelbord()[coord.getX()][coord.getY()].hasDamsteen()) {
		dambord.getSpeelbord()[coord.getX()][coord.getY()].getDamsteen().setKleur(Color.blue);
		bord.repaint();
	    }
	} 
    }
    

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	Nodes node = (Nodes)e.getComponent();
	highlightNode(new Coord(node.getX(), node.getY() ));
	
    }



    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }



    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }



    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }



    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

}
