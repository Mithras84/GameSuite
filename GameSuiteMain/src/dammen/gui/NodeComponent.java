/**
 * 
 */
package dammen.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import dammen.model.Coord;
import dammen.model.Nodes;

/**
 * Class description
 * 
 * @version		1.00 17 jul. 2014
 * @author 		Pieter
 */
public class NodeComponent extends JComponent {

    private static final long serialVersionUID = 5104899510098445836L;
    private Nodes node;


    private int nodeSize;
    private Color color;
    
    private BufferedImage image;
        
    public NodeComponent (Nodes node) {
	this.node = node;
	
	nodeSize = ScreenSize.NODESIZE;
	setSize (nodeSize,nodeSize);
	
	if (node.getKleur() == "zwart") {
	    this.image = ImageHelper.veldDonker;
	    this.color = Color.black;
	} else {
	    this.image = ImageHelper.veldLicht;
	    this.color = Color.white;
	}	
    }
        
    /**
     * @return the node
     */
    public Nodes getNode() {
        return node;
    }
    
    public Coord getCoord () {
	return this.node.getCoord();
    }   
    
    public Dimension getPreferredSize() {
	this.getSize(getSize());
        return new Dimension(nodeSize,nodeSize);
    }
    
    /**
     * Overridden functie. Paint deze node op het bord, maak gebruik van
     * dynamische NODESIZE in de klasse
     * 
     * @see ScreenSize. Bepaal de kleur van het vakje op basis van de kleur van
     *      deze node.
     */
    public void paintComponent(Graphics g) {
	super.paintComponent(g);	

	Graphics2D g2d = (Graphics2D) g;
	g2d.drawImage(this.image, 0, 0, nodeSize, nodeSize, null);
		
	if (node.hasDamsteen()) {
	    drawDamSteen (g2d);    
	}
	
	if (node.isHighLight()) {
	    drawHighlight(g2d);
	    node.setHighLight(false);
	}
	
    }
    
    public void drawHighlight (Graphics2D g2d) {
	g2d.setStroke(new BasicStroke(4));
	if (node.hasDamsteen())
	    g2d.setColor(Color.green);
	else 
	    g2d.setColor(Color.blue);
	g2d.drawRect(0,0, nodeSize, nodeSize);
	g2d.setColor(color);
    }
    
    public void drawDamSteen (Graphics2D g2d) {

	BufferedImage img = null;
	if (this.color == Color.black) {
	    if (this.node.getDamsteen().getKleur() == Color.black)
		img = ImageHelper.veldDonkerZwart;
	    else if (this.node.getDamsteen().getKleur() == Color.white)
		img = ImageHelper.veldDonkerWit;
	} else if (this.color == Color.white) {
	    if (this.node.getDamsteen().getKleur() == Color.black)
		img = ImageHelper.veldLichtZwart;
	    else if (this.node.getDamsteen().getKleur() == Color.white)
		img = ImageHelper.veldLichtWit;
	}
	
	//g2d.drawImage(img, 0,0,this);
	g2d.drawImage(img, 0, 0, nodeSize, nodeSize, null);
    }

}
