/**
 * 
 */
package dammen.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dammen.model.DamBord;
import dammen.model.Nodes;

/**
 * Class description
 * 
 * @version 1.00 15 jul. 2014
 * @author Pieter
 */
public class DambordGUI implements MouseListener, MouseMotionListener, ComponentListener {

    JFrame frame;
    JPanel panel;
    BordPanel bord;
    JLabel label;

    private DamBord dambord;
    

    public DambordGUI(DamBord dambord) {
	this.dambord = dambord;

	initFrame();
	initPanels();
	maakDambord();
	updateBord();
    }

    private void initFrame() {
	frame = new JFrame( "Dammen" );
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setSize(ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 50);

	frame.setVisible(true);
	
	frame.setLocationRelativeTo(null);
    }

    private void initPanels() {
	
	panel = new JPanel();
	panel.setBounds(0, 0, ScreenSize.WIDTH + 25, ScreenSize.HEIGHT + 50);
	panel.setLayout(new BorderLayout());
	panel.addComponentListener(this);

	bord = new BordPanel();
	bord.setBounds(0 ,0 ,ScreenSize.WIDTH, ScreenSize.HEIGHT);
	bord.setOpaque(true);

	label = new JLabel();
	label.setText("Text");

	panel.add(label, BorderLayout.SOUTH);
	panel.add(bord, BorderLayout.CENTER);
	
	frame.add(panel);
    }

    public void maakDambord() {
	bord.addSpeelBord(dambord.getSpeelbord());
	frame.pack();
    }

    public void updateBord() {
	maakDambord();
	for (int i = 0; i < dambord.getKolommen(); i++) {
	    for (int j = 0; j < dambord.getRijen(); j++) {
		if ( 
			(dambord.getNodeAt(i, j).hasDamsteen() && dambord.getNodeAt(i, j).getDamsteen().hasMoves() ) 
			&&
			dambord.getNodeAt(i, j).getDamsteen().getKleur() == dambord.getSpeler().getKleur() 
		) {
		    bord.getNodeComponent(i, j).addMouseListener(this);
		    bord.getNodeComponent(i, j).addMouseMotionListener(this);
		} else if (dambord.getNodeAt(i, j).isHighLight()) {
		    bord.getNodeComponent(i, j).addMouseListener(this);
		    bord.getNodeComponent(i, j).addMouseMotionListener(this);
		}
	    }
	}
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	NodeComponent node = (NodeComponent)e.getComponent();
	label.setText( node.getCoord().toString() );
	node.getNode().setHighLight(true);
	Nodes[] tmp = node.getNode().getDamsteen().getMoveToArray();
	for (Nodes n : tmp) {
	    n.setHighLight(true);
	}
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
	
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	NodeComponent n = (NodeComponent) e.getComponent();
	n.setCursor(new Cursor(Cursor.HAND_CURSOR));
	label.setText(n.getCoord().toString());
    }

    /* (non-Javadoc)
     * @see java.awt.event.ComponentListener#componentResized(java.awt.event.ComponentEvent)
     */
    @Override
    public void componentResized(ComponentEvent e) {
	// TODO Auto-generated method stub
	ScreenSize.reSize (panel.getSize());
	System.out.println(ScreenSize.NODESIZE);
	updateBord();
    }

    /* (non-Javadoc)
     * @see java.awt.event.ComponentListener#componentMoved(java.awt.event.ComponentEvent)
     */
    @Override
    public void componentMoved(ComponentEvent e) {
	// TODO Auto-generated method stub
	
    }

    /* (non-Javadoc)
     * @see java.awt.event.ComponentListener#componentShown(java.awt.event.ComponentEvent)
     */
    @Override
    public void componentShown(ComponentEvent e) {
	// TODO Auto-generated method stub
	
    }

    /* (non-Javadoc)
     * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.ComponentEvent)
     */
    @Override
    public void componentHidden(ComponentEvent e) {
	// TODO Auto-generated method stub
	
    }

}
