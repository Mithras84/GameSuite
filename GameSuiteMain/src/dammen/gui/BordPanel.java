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
 * Een customized JPanel.
 * Heeft een array met NodeComponents, die weer gekoppeld zijn aan Nodes.
 * Zorgt ervoor dat alle Nodes op de juiste plek komen te staan.
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
    
    /**
     * Krijgt het virtuele speelbord binnen, en koppelt de Nodes van het virtuele speelbord aan de 
     * Nodes (NodeComponents) van het visuele speelbord.
     * @param Nodes[][] speelbord
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
    
    /**
     * Overridden functie voor het toevoegen van NodeComponents aan de nodeList array.
     * Aangezien ik wil dat de locatie linksonder in beeld de 0,0 coordinaat bevat, moest ik
     * op deze manier nodes toevoegen aan het BordPanel.
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
    
    /**
     * Haal een nodeComponent uit de lijst op basis van x en y coordinaat.
     * Volgens mij kan deze wel weg.
     * @param x
     * @param y
     * @return
     */
    public NodeComponent getNodeComponent (int x, int y) {
	return nodeList[x][y];
    }
    
    /**
     * Haal een nodeComponent uit de lijst op basis van een Coord.
     * Volgens mij kan deze wel weg.
     * @param x
     * @param y
     * @return
     */
    public NodeComponent getNodeComponent (Coord coord) {
	return nodeList[coord.getX()][coord.getY()];
    }
    
    /**
     * Custom preferredSize (op basis van een NodeSize in de statische screensize klasse, 
     * en het aantal rijen/kolommen van het speelveld.
     */
    public Dimension getPreferredSize() {
        return new Dimension(ScreenSize.KOLOMMEN * ScreenSize.NODESIZE ,ScreenSize.RIJEN * ScreenSize.NODESIZE);
    }

}
