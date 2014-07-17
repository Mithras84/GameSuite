/**
 * 
 */
package dammen.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

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
        
    public NodeComponent (int x, int y) {
	this.coord = new Coord (x,y);
	nodeSize = ScreenSize.NODESIZE;
	setSize (nodeSize,nodeSize);
	
	if (x % 2 == 1 && y % 2 == 1)
	    this.color = Color.gray;
	else if (x % 2 == 0 && y % 2 == 0)
	    this.color = Color.gray;
	else
	    this.color = Color.white;
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
	Rectangle block = new Rectangle(0, 0, nodeSize, nodeSize);
	g2d.setColor(color);
	g2d.fill(block);
		
	if (highLight) {
	    drawHighlight(g2d);
	}
	
	if (damSteen) {
	    drawDamSteen (g2d);    
	}
	
	g2d.draw(block);
    }
    
    public void drawHighlight (Graphics2D g2d) {
	g2d.setStroke(new BasicStroke(6));
	g2d.setColor(Color.blue);
	highLight = false;
    }
    
    public void drawDamSteen (Graphics2D g2d) {
	int nodePos = nodeSize / 10;
	int nodeWH = nodeSize - (2*nodePos);		

	Ellipse2D circle = new Ellipse2D.Double(nodePos, nodePos, nodeWH, nodeWH);
	Color oldColor = g2d.getColor();
	g2d.setColor(this.damSteenKleur);
	g2d.fill(circle);
	damSteen = false;
	g2d.draw(circle);
	g2d.setColor(oldColor);
    }

}
