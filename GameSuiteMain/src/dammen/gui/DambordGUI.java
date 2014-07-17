/**
 * 
 */
package dammen.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dammen.model.Coord;
import dammen.model.DamBord;
import dammen.model.DamSteen;
import dammen.model.Nodes;

/**
 * Class description
 * 
 * @version 1.00 15 jul. 2014
 * @author Pieter
 */
public class DambordGUI implements MouseListener, MouseMotionListener {

    JFrame frame;
    JPanel panel;
    BordPanel bord;
    JLabel label;

    private DamBord dambord;
    private Nodes[][] speelbord;
    private Coord selectedNodeCoord;
    private GridBagConstraints c;
    
    private boolean mouseDrag;

    public DambordGUI(DamBord dambord) {
	this.dambord = dambord;
	this.speelbord = dambord.getSpeelbord();

	initFrame();
	initPanels();
	maakDambord();
	updateBord();
    }

    private void initFrame() {
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setSize(ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 70);

	frame.setVisible(true);
	frame.setResizable(false);
    }

    private void initPanels() {
	panel = new JPanel();
	panel.setBounds(0, 0, ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 75);
	panel.setLayout(new BorderLayout());
	panel.setOpaque(true);

	bord = new BordPanel();
	bord.setBounds(0, 0, ScreenSize.WIDTH, ScreenSize.HEIGHT);
	bord.setLayout(new GridBagLayout());
	
	c = new GridBagConstraints();

	label = new JLabel();
	label.setText("Text");

	panel.add(label, BorderLayout.SOUTH);
	panel.add(bord, BorderLayout.CENTER);
	
	frame.add(panel);
    }

    public void maakDambord() {
	c.weightx = 1;
	c.weighty = 1;	
	c.fill = GridBagConstraints.BOTH;

	for (int i = 0; i < dambord.getKolommen(); i++) {
	    for (int j = 0; j < dambord.getRijen(); j++) {
		c.gridx = i;
		c.gridy = j;		
		bord.add(new NodeComponent(i,dambord.getKolommen() -1 -j), c);
		bord.getNodeComponent(i, dambord.getKolommen() -1 -j).addMouseListener(this);		
	    }
	}	
	bord.repaint();
    }

    public void updateBord() {
	for (int i = 0; i < dambord.getKolommen(); i++) {
	    for (int j = 0; j < dambord.getRijen(); j++) {
		if (speelbord[i][j].hasDamsteen()) {
		    //bord.getNodeComponent(i,j).add( new DamSteenComponent( speelbord[i][j].getDamsteen().getKleur() ) );
		    bord.getNodeComponent(i, j).setDamsteen(speelbord[i][j].getDamsteen().getKleur());
		    bord.getNodeComponent(i, j).repaint();
		} 
	    }
	}	
	bord.repaint();
    }
    

    public void highlightNode(Coord[] coord) {
	if ( coord[0] != null && 
		!dambord.getSpeelbord()[coord[0].getX()][coord[0].getY()].hasDamsteen() ) {
	    
	    dambord.getSpeelbord()[coord[0].getX()][coord[0].getY()].setKleur("highlight");	    
	}
	
	if ( coord[1] != null && 
		!dambord.getSpeelbord()[coord[1].getX()][coord[1].getY()].hasDamsteen() ) {
	    
	    dambord.getSpeelbord()[coord[1].getX()][coord[1].getY()].setKleur("highlight");	    
	}	
	//updateBord();
    }

    public void unHighlightNode(Coord[] coord) {
	if (coord[0] != null) {
	    dambord.getSpeelbord()[coord[0].getX()][coord[0].getY()]
		    .setKleur("zwart");
	}
	if (coord[1] != null) {
	    dambord.getSpeelbord()[coord[1].getX()][coord[1].getY()]
		    .setKleur("zwart");
	}	
	//updateBord();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	NodeComponent nodec = (NodeComponent) e.getComponent();
	bord.getNodeComponent(nodec.getCoord()).setHighlight(true);
	
	DamSteen steen = speelbord[0][0].moveDamsteen();
	speelbord[0][4].setDamSteen(steen);
	updateBord();
	

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	if (selectedNodeCoord!=null && mouseDrag == true) {
	    mouseDrag = false;
	    Coord[] selectedNode = dambord.showFreeNodes(selectedNodeCoord);
	    Object ob = bord.findComponentAt(e.getLocationOnScreen());
	    System.out.println(ob);
	    if (ob instanceof Nodes) {
		System.out.println("Node found!");
		Nodes node = (Nodes) ob;
		for (int i = 0; i < selectedNode.length; i++) {
		    if (selectedNode[i].equalsCoor(node.getCoord() )) {			
			System.out.println("Target found!");
			DamSteen steen =  dambord.getSpeelbord()[selectedNodeCoord.getX()][selectedNodeCoord.getY()].moveDamsteen();
			dambord.getSpeelbord()[node.getXCoord()][node.getYCoord()].setDamSteen( steen );
			selectedNodeCoord = null;
			//updateBord();
		    }
		}
	    }	    
	}
	selectedNodeCoord = null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	/*
	Nodes node = (Nodes) e.getComponent();
	    if (node.getKleur() == "zwart" && node.hasDamsteen()) {
		selectedNodeCoord = node.getCoord();
		label.setText(node.toString());
		mouseDrag = true;
	    }
	    */
	
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

}
