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

/**
 * Class description
 * 
 * @version		1.00 17 jul. 2014
 * @author 		Pieter
 */
public class NodeComponent extends JComponent {

    private static final long serialVersionUID = 5104899510098445836L;
    private Coord coord;
    private int nodeSize;
    private Color color;
    private boolean highLight;
    private boolean damSteen;
    private Color damSteenKleur;
    
    private BufferedImage image;
        
    public NodeComponent (int x, int y) {
	this.coord = new Coord (x,y);
	nodeSize = ScreenSize.NODESIZE;
	setSize (nodeSize,nodeSize);
	
	if (x % 2 == 1 && y % 2 == 1) {
	    this.image = ImageHelper.getImageFromFile("VeldDonker");
	    this.color = Color.black;
	} else if (x % 2 == 0 && y % 2 == 0) {
	    this.image = ImageHelper.getImageFromFile("VeldDonker");
	    this.color = Color.black;
	} else {
	    this.image = ImageHelper.getImageFromFile("VeldLicht"); 
	    this.color = Color.white;
	}
	
    }
    
    public void setDamsteen (Color kleur) {
	this.damSteen = true;
	this.damSteenKleur = kleur;
    }
        
    public Coord getCoord () {
	return this.coord;
    }
    
    public void setHighlight (boolean highLight) {
	this.highLight = highLight;
    }
    
    public Dimension getPreferredSize() {
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
	g2d.drawImage(this.image, 0,0,this);
	//g2d.setColor(color);
	//Rectangle rec = new Rectangle (0,0,nodeSize,nodeSize);
	//g2d.fill(rec);
	//g2d.draw(rec);
		
	if (damSteen) {
	    drawDamSteen (g2d);    
	}
	
	if (highLight) {
	    drawHighlight(g2d);
	}
	
    }
    
    public void drawHighlight (Graphics2D g2d) {
	g2d.setStroke(new BasicStroke(5));
	g2d.setColor(Color.blue);
	g2d.drawRect(0,0, nodeSize, nodeSize);
	highLight = false;
	g2d.setColor(color);
    }
    
    public void drawDamSteen (Graphics2D g2d) {
	/*
	int nodePos = nodeSize / 10;
	int nodeWH = nodeSize - (2*nodePos);		

	Color oldColor = g2d.getColor();
	
	g2d.setColor(this.damSteenKleur);
	g2d.fillOval(nodePos, nodePos, nodeWH, nodeWH);
	
	damSteen = false;
	g2d.setColor(oldColor);
	*/
	BufferedImage img = null;
	if (this.color == Color.black) {
	    if (this.damSteenKleur == Color.black)
		img = ImageHelper.getImageFromFile("VeldDonkerMetSteenZwart");
	    else if (this.damSteenKleur == Color.white)
		img = ImageHelper.getImageFromFile("VeldDonkerMetSteenWit");
	} else if (this.color == Color.white) {
	    if (this.damSteenKleur == Color.black)
		img = ImageHelper.getImageFromFile("VeldLichtMetSteenZwart");
	    else if (this.damSteenKleur == Color.white)
		img = ImageHelper.getImageFromFile("VeldLichtMetSteenWit");
	}
	
	g2d.drawImage(img, 0,0,this);
    }

}
