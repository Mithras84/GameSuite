/**
 * 
 */
package dammen.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import dammen.model.Coord;
import dammen.model.Nodes;

/**
 * Class description
 * 
 * @version		1.00 17 jul. 2014
 * @author 		Pieter
 */
public class BordPanel extends JPanel {

    private NodeComponent[][] nodeList;
    private static final long serialVersionUID = 3268182264406801064L;
    private GridBagLayout layout;
    private GridBagConstraints c;
    
    
    {
	layout = new GridBagLayout();
	this.setLayout(layout);
	c = new GridBagConstraints ();	
    }
    /* (non-Javadoc)
     * @see java.awt.Container#add(java.awt.Component, java.lang.Object)
     */
    
    public void addSpeelBord (Nodes [][] speelbord) {
	nodeList = null;
	this.removeAll();
	nodeList = new NodeComponent [ScreenSize.KOLOMMEN][ScreenSize.RIJEN];
	
	c.weightx = 1;
	c.weighty = 1;	
	c.fill = GridBagConstraints.BOTH;

	for (int i = 0; i < ScreenSize.KOLOMMEN; i++) {
	    for (int j = 0; j < ScreenSize.RIJEN; j++) {
		c.gridx = i;
		c.gridy = j;		
		this.add(new NodeComponent(speelbord[i][ScreenSize.RIJEN -j - 1]), c);
	    }
	}	
	this.repaint();
    }
    
    @Override
    public void add(Component comp, Object constraints) {
	// TODO Auto-generated method stub
	super.add(comp, constraints);
	
	if (comp instanceof NodeComponent) {
	    NodeComponent ncomp = (NodeComponent) comp;
	    nodeList[ncomp.getCoord().getX()][ncomp.getCoord().getY()] = (NodeComponent) comp;
	}
    }
    
    public NodeComponent getNodeComponent (int x, int y) {
	return nodeList[x][y];
    }
    
    public NodeComponent getNodeComponent (Coord coord) {
	return nodeList[coord.getX()][coord.getY()];
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(ScreenSize.KOLOMMEN * ScreenSize.NODESIZE ,ScreenSize.RIJEN * ScreenSize.NODESIZE);
    }

}
