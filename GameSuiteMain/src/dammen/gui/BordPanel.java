/**
 * 
 */
package dammen.gui;

import java.awt.Component;

import javax.swing.JPanel;

import dammen.model.Coord;

/**
 * Class description
 * 
 * @version		1.00 17 jul. 2014
 * @author 		Pieter
 */
public class BordPanel extends JPanel {

    private NodeComponent[][] nodeList;
    private static final long serialVersionUID = 3268182264406801064L;
    
    {
	nodeList = new NodeComponent [ScreenSize.KOLOMMEN][ScreenSize.RIJEN];
    }
    /* (non-Javadoc)
     * @see java.awt.Container#add(java.awt.Component, java.lang.Object)
     */
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
    
    

}
