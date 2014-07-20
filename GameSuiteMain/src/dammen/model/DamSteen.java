/**
 * 
 */
package dammen.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Class description
 * 
 * @version 1.00 14 jul. 2014
 * @author Pieter
 */
public class DamSteen {
    
    private Color kleur;
    private Coord coord; //Deze is eigenlijk niet nodig.. Staat ook in Node..

    private static int COUNT; //Zodat alle damstenen een Unique ID hebben.
    private int id;
    
    private ArrayList<Moves> moveList;
    
    private boolean ownedByPlayer;

    /**
     * @return the ownedByPlayer
     */
    public boolean isOwnedByPlayer() {
        return ownedByPlayer;
    }

    public DamSteen(String kleur, Player player) {
	if (kleur == "zwart")
	    this.kleur = Color.black;
	else
	    this.kleur = Color.white;
	
	if (this.kleur == player.getKleur())
	    ownedByPlayer = true;
	else 
	    ownedByPlayer = false;
	
	DamSteen.COUNT++;
	id = DamSteen.COUNT;
	
	moveList = new ArrayList<> ();
    }
    
    public void addMove (Nodes currentNode, Nodes targetNode) {
	moveList.add(new Moves (currentNode, targetNode));	
    }
    
    public void setMovesToNull () {
	moveList.clear();
    }
    
    public boolean hasMoves () {
	return !moveList.isEmpty();
    }
    
    public ArrayList<Moves> getMoveList () {
	return moveList;
    }
    
    public Moves[] getMoveToArray () {
	
	System.out.println(moveList.size());
	Moves[] tmp = (Moves[]) moveList.toArray(new Moves[moveList.size()]);
	return tmp;
    }

    public DamSteen(Color kleur) {
	this.kleur = kleur;
	
	DamSteen.COUNT++;
	id = DamSteen.COUNT;
    }

    public void setCoord(Coord coord) {
	this.coord = coord;
    }

    public Coord getCoord() {
	return this.coord;
    }

    public String getKleurToString() {
	String res;
	
	if (this.kleur == Color.black)
	    res = "zwart";
	else
	    res = "wit";
	return res;
    }

    public void setKleur(Color color) {
	this.kleur = color;
    }

    public Color getKleur() {
	return this.kleur;
    }

    public String toString() {
	return this.getKleurToString() + " ID=" + id + " " + coord.getX() + ":"
		+ coord.getY();
    }
}
