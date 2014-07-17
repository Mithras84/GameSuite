/**
 * 
 */
package dammen.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    private Coord selectedNodeCoord;
    private GridBagConstraints c;
    
    public DambordGUI (DamBord dambord) {
	this.dambord = dambord;
	
	initFrame ();
	initPanels ();
	maakDambord();
	updateBord();
    }
    
    private void initFrame () {
	frame = new JFrame ();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.setSize(ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 70);
	
	frame.setVisible(true);
    }
    
    private void initPanels () {
	panel = new JPanel ();
	panel.setBounds(0, 0, ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 75);
	panel.setLayout(new BorderLayout());
	
	bord = new JPanel ();
	bord.setBounds(0,0, ScreenSize.WIDTH, ScreenSize.HEIGHT );
	bord.setLayout(new GridBagLayout());
	c = new GridBagConstraints ();
		
	label = new JLabel ();
	label.setText("Text");
		
	panel.add(label, BorderLayout.SOUTH);
	
	panel.add(bord, BorderLayout.CENTER);
	frame.add(panel);
	
    }   
        
    public void maakDambord () {
	c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        
	for (int i = 0; i < dambord.getKolommen(); i++) {	    
	    for (int j = 0; j < dambord.getRijen(); j++) {
		c.gridx = i;
		c.gridy = j;
		bord.add(dambord.getSpeelbord()[i][j], c);
		dambord.getSpeelbord()[i][j].addMouseListener(this);
	    }
	}	
	bord.repaint();
    }
    
    public void updateBord () {
	for (int i = 0; i < dambord.getKolommen(); i++) {	    
	    for (int j = 0; j < dambord.getRijen(); j++) {		
		if (dambord.getSpeelbord()[i][j].hasDamsteen() ) {
		    dambord.getSpeelbord()[i][j].add(dambord.getSpeelbord()[i][j].getDamsteen());    
		}
	    }
	}	
	bord.repaint();
    }
    
    public void highlightNode (Coord[] coord) {	
	if (coord[0] != null) {
	    dambord.getSpeelbord()[coord[0].getX()][coord[0].getY()].setKleur("highlight");
	    //bord.repaint();
	    //dambord.getSpeelbord()[coord[0].getX()][coord[0].getY()].setKleur("zwart");
	}	
	if (coord[1] != null) {
	    dambord.getSpeelbord()[coord[1].getX()][coord[1].getY()].setKleur("highlight");
	    //bord.repaint();
	    //dambord.getSpeelbord()[coord[1].getX()][coord[1].getY()].setKleur("zwart");
	}
	updateBord ();
    }
    
    public void unHighlightNode (Coord[] coord) {
	if (coord[0] != null) {
	    dambord.getSpeelbord()[coord[0].getX()][coord[0].getY()].setKleur("zwart");
	}	
	if (coord[1] != null) {
	    dambord.getSpeelbord()[coord[1].getX()][coord[1].getY()].setKleur("zwart");
	}
	updateBord ();
    }
    

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if (e.getButton() == 1) {
	    if (selectedNodeCoord != null) {
		unHighlightNode(dambord.showFreeNodes(selectedNodeCoord));
	    }
	    Nodes node = (Nodes)e.getComponent();
	    selectedNodeCoord = node.getCoord();
	    highlightNode(dambord.showFreeNodes(selectedNodeCoord));
	} else if (e.getButton() == 2 ) {
	    if (selectedNodeCoord != null) {
		unHighlightNode(dambord.showFreeNodes(selectedNodeCoord));
	    }
	} else if (e.getButton() == 3) {
	    System.out.println(e.getComponent().toString());
	}
	
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
