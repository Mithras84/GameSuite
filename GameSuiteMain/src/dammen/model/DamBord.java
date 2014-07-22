/**
 * 
 */
package dammen.model;

import java.awt.Color;

import dammen.gui.ScreenSize;

/**
 * Class description Klasse die een virtueel dambord moet voorstellen (bestaande
 * uit Nodes). Deze klasse is in principe de Controller, en staat tussen de GUI,
 * AI en Dammen class in.
 * 
 * @todo Refactor, functies die stenen kunnen verplaatsen, informatie ophalen,
 *       etc.
 * @version 1.00 14 jul. 2014
 * @author Pieter
 */
public class DamBord {

    private int kolommen;
    private int rijen;
    private Nodes[][] speelbord;
       
    
    private Player speler;
    private AI ai;

    /**
     * Constructor. Creeer een virtueel dambord op basis van de opgegeven
     * specificaties. Voorwaarden: Aantal rijen en kolommen zijn altijd even, en
     * altijd groter dan 4.
     * 
     * @param aantal
     *            kolommen (X coordinaat)
     * @param aantal
     *            rijen (Y coordinaat)
     */
    public DamBord(int aantalKolommen, int aantalRijen) {
	
	if (aantalKolommen % 2 == 0 && aantalKolommen >= 4)
	    kolommen = aantalKolommen;
	else
	    kolommen = 10;

	if (aantalRijen % 2 == 0 && aantalRijen >= 4)
	    rijen = aantalRijen;
	else
	    rijen = 10;

	speelbord = new Nodes[kolommen][rijen];
	
	setKleur();
	maakBord();
	vulBord();
	setMoves();
	//showMoves();
    }
    
    public void setMoves () {
	for (int i = 0; i < kolommen; i++) {
	    for (int j = 0; j < rijen; j++) {
		if (speelbord[i][j].hasDamsteen()) {
		    speelbord[i][j].getDamsteen().setMovesToNull();
		    setPossibleMoves(speelbord[i][j]);
		    setPossibleSlagen(speelbord[i][j], speelbord[i][j].getDamsteen());
		}
	    }
	}
    }
    
    private void setKleur () {
	speler = new Player ("wit");
	if (speler.getKleurToString() == "wit") 
	    ai = new AI(Color.black);
	else 
	    ai = new AI(Color.white);
    }

    /**
     * Beschermde methode om het bord te vullen met 'Nodes': Dit zijn de velden
     * op het bord.
     * 
     * @see dammen.model.Nodes
     */
    private void maakBord() {
	
	ScreenSize.setDammenSize(kolommen, rijen);
	Coord.setLimits(kolommen, rijen);
	
	for (int i = 0; i < kolommen; i++) {
	    for (int j = 0; j < rijen; j++) {
		try {
		    this.speelbord[i][j] = new Nodes(i, j);
		} catch (Exception e) {
		    System.out.println("This error will never occur :)");
		}
	    }
	}
	
    }

    /**
     * Functie om het bord met damstenen te vullen. Alleen aanroepen tijdens het
     * initialiseren van een nieuw spel.
     */
    private void vulBord() {
	String kleur = null;
	
	for (int i = 0; i < rijen; i++) {
	    
	    // De kant van de Speler 
	    if (i < (rijen / 2) - 1)
		kleur = speler.getKleurToString();
	    // De kant van de AI.
	    else if (i >= (rijen / 2) + 1)
		kleur = ai.getKleurToString();
	    // De twee rijen in het midden van het bord mogen geen damstenen
	    // bevatten.
	    else
		continue;

	    // Als Node zwart is, voeg een damsteen toe:
	    for (int j = 0; j < kolommen; j++) {
		if (this.speelbord[j][i].getKleur() == "zwart")
		    this.speelbord[j][i].setDamSteen(new DamSteen(kleur, speler));
		
	    }
	}
    }
    
    public void makeMove (Moves move) {
	//Move van de speler.
	move.makeMove();
	setMoves();
	
	// Nu mag de AI.
	Moves aiMove = ai.makeMove(speelbord);
	aiMove.makeMove();
	
	//Highlight de move van de AI
	aiMove.getCurrentNode().setAIHighlight(true);
	aiMove.getTargetNode().setAIHighlight(true);
	
	//Moves opnieuw bepalen
	setMoves();
    }
    
    public Nodes getNodeAt (Coord coord) {
	if (coord != null)
	    return speelbord[coord.getX()][coord.getY()];
	else 
	    return null;
    }
    
    public Nodes getNodeAt (int x, int y) {
	if ((x >= 0 && x < kolommen) && (y >= 0 && y < rijen) )
	    return speelbord[x][y];
	else 
	    return null;
    }

    /**
     * @return the speler
     */
    public Player getSpeler() {
        return speler;
    }

    /**
     * @return the ai
     */
    public AI getAi() {
        return ai;
    }

    /**
     * Haal virtueel speelbord op.
     * 
     * @return Het virtuele speelbord, een array met alle Nodes (vakken) van het
     *         dambord.
     */
    public Nodes[][] getSpeelbord() {
	return this.speelbord;
    }

    /**
     * 
     * @return int met het aantal rijen van het speelbord.
     */
    public int getRijen() {
	return this.rijen;
    }

    /**
     * 
     * @return int met het aantal kolommen van het speelbord.
     */
    public int getKolommen() {
	return this.kolommen;
    }

    /**
     * Deze functie kijkt, op basis van de input node,
     * welke vakjes er vrij zijn voor een eventuele zet.
     * 
     * Deze mogelijke zet wordt opgeslagen in het damsteen object in de node.
     * Afhankelijk van de eigenaar van de damsteen: Ga vooruit of achteruit.
     * 
     * @todo Moet netter en dynamischer. AI moet ook gebruik kunnen maken van
     *       deze functie! Update.. Is in ieder geval netter, en maakt gebruik van
     *       Nodes om beperkingen te kunnen bepalen. Volgende obstakel is het slaan van
     *       damstenen.
     * @param Nodes node
     */
    public void setPossibleMoves (Nodes node) {
	//Voor player moves: alleen nodes met een damsteen van de speler selecteren.
	if (node.getDamsteen().isOwnedByPlayer()) {
	    //Eerst kijken of de node een aangrenzende linkerrechter node heeft die leeg is:
	    if ( getNodeNE(node) != null && !getNodeNE(node).hasDamsteen() ) {
		node.getDamsteen().addMove( new Moves(node, getNodeNE(node)) );
	    } 
	    //Dan kijken of de node een aangrenzende rechternode heeft die leeg is:
	    if (getNodeNW(node) != null && !getNodeNW(node).hasDamsteen() ) {
		node.getDamsteen().addMove(new Moves (node, getNodeNW(node)));
	    }
	} else {
	    if ( getNodeSE(node) != null && !getNodeSE(node).hasDamsteen() ) {
		node.getDamsteen().addMove( new Moves(node, getNodeSE(node)) );
	    } 
	    if (getNodeSW(node) != null && !getNodeSW(node).hasDamsteen() ) {
		node.getDamsteen().addMove(new Moves (node, getNodeSW(node)));
	    }
	}
    }  
    
    public void setPossibleSlagen(Nodes node, DamSteen steen) {	
	kanSlaanNE(node, steen);
	kanSlaanNW(node, steen);
	kanSlaanSE(node, steen);
	kanSlaanSW(node, steen);	
    }
    
    private boolean checkDubbeleDamsteen (DamSteen steen, Nodes nodeToCompare) {
	DamSteen compareSteen = nodeToCompare.getDamsteen();
	Moves[] moveList = steen.getMoveToArray();
	for (Moves move: moveList) {
	    if (move instanceof Slaan) {
		Slaan slaan = (Slaan) move;
		DamSteen prevSteen = slaan.getTargetNodeSteen().getDamsteen();
		if (prevSteen.getCoord().equalsCoor(compareSteen.getCoord()))
		    return true;
	    }
		
	}
	
	return false;
	
    }

    /**
     * @param node
     * @param steen
     */
    private void kanSlaanNE(Nodes node, DamSteen steen) {
	if ( getNodeNE(node) != null && getNodeNE(node).hasDamsteen() ) {
	    if (steen.getKleur() != getNodeNE(node).getDamsteen().getKleur()  && !checkDubbeleDamsteen(steen, getNodeNE(node) ) ) {
		if ( getNodeNE(getNodeNE(node)) != null && !getNodeNE(getNodeNE(node)).hasDamsteen() ) {
		    steen.addMove(new Slaan(node,getNodeNE(getNodeNE(node)),getNodeNE(node)));
		    System.out.println ( "Steen kan slaan!" );
		    setPossibleSlagen(getNodeNE(getNodeNE(node)), steen);
		}
	    }
	}
    }
    
    /**
     * @param node
     * @param steen
     */
    private void kanSlaanNW(Nodes node, DamSteen steen) {
	if ( getNodeNW(node) != null && getNodeNW(node).hasDamsteen() ) {
	    if (steen.getKleur() != getNodeNW(node).getDamsteen().getKleur() && !checkDubbeleDamsteen(steen, getNodeNW(node) ) ) {
		if ( getNodeNW(getNodeNW(node)) != null && !getNodeNW(getNodeNW(node)).hasDamsteen() ) {
		    steen.addMove(new Slaan(node,getNodeNW(getNodeNW(node)),getNodeNW(node)));
		    System.out.println ( "Steen kan slaan!" );
		    //setPossibleSlagen(getNodeNW(getNodeNW(node)), steen);
		}
	    }
	}
    }
    
    /**
     * @param node
     * @param steen
     */
    private void kanSlaanSE(Nodes node, DamSteen steen) {
	if ( getNodeSE(node) != null && getNodeSE(node).hasDamsteen() ) {
	    if (steen.getKleur() != getNodeSE(node).getDamsteen().getKleur() && !checkDubbeleDamsteen(steen, getNodeSE(node)) ) {
		if ( getNodeSE(getNodeSE(node)) != null && !getNodeSE(getNodeSE(node)).hasDamsteen() ) {
		    steen.addMove(new Slaan(node,getNodeSE(getNodeSE(node)),getNodeSE(node)));
		    System.out.println ( "Steen kan slaan!" );
		    //setPossibleSlagen(getNodeSE(getNodeSE(node)), steen);
		}
	    }
	}
    }
    
    /**
     * @param node
     * @param steen
     */
    private void kanSlaanSW(Nodes node, DamSteen steen) {
	if ( getNodeSW(node) != null && getNodeSW(node).hasDamsteen() ) {
	    if (steen.getKleur() != getNodeSW(node).getDamsteen().getKleur() && !checkDubbeleDamsteen(steen, getNodeSW(node)) ) {
		if ( getNodeSW(getNodeSW(node)) != null && !getNodeSW(getNodeNW(node)).hasDamsteen() ) {
		    steen.addMove(new Slaan(node,getNodeSW(getNodeSW(node)),getNodeSW(node)));
		    System.out.println ( "Steen kan slaan!" );
		    //setPossibleSlagen(getNodeSW(getNodeSW(node)), steen);
		}
	    }
	}
    }
    
    
    private Nodes getNodeNE (Nodes node) {
	if (node.getCoordNE() != null ) 
	    return getNodeAt(node.getCoordNE());
	else
	    return null;
    }
    
    private Nodes getNodeNW (Nodes node) {
	if (node.getCoordNW() != null )
	    return getNodeAt(node.getCoordNW());
	else
	    return null;
    }
    
    private Nodes getNodeSE (Nodes node) {
	if (node.getCoordSE() != null )
	    return getNodeAt(node.getCoordSE());
	else
	    return null;
    }
    
    private Nodes getNodeSW (Nodes node) {
	if (node.getCoordSW() != null )
	    return getNodeAt(node.getCoordSW());
	else
	    return null;
    }

    /**
     * Test functie. Laat alle Nodes op het bord zien.
     */
    public void showBord() {
	for (int i = 0; i < kolommen; i++) {
	    for (int j = 0; j < rijen; j++) {
		System.out.println(speelbord[i][j].toString());
	    }
	}
    }

    /**
     * Test functie. Achterhaal 'links' tussen de nodes op het bord.
     */
    public void showLinks() {
	System.out.println("Neighbour left of coord 1 : 1 = "
		+ speelbord[1][1].toString());
	System.out.println("Neighbour right of coord 1 : 1 = "
		+ speelbord[1][1].toString());
    }
    
    /**
     * Test functie. Laat alle moves zien in de console.
     */
    public void showMoves () {
	for (int i = 0; i < kolommen; i++) {
	    for (int j = 0; j < rijen; j++) {
		if (speelbord[i][j].hasDamsteen() &&  speelbord[i][j].getDamsteen().hasMoves() ) {
		    System.out.println("Steen op node " + speelbord[i][j].toString() + " has moves");
		}
	    }
	}
    }
    
    /*
    private void checkForMoveL(Nodes nodeC, Nodes nodeL) {
	if (nodeL != null) {
	    if (!nodeL.hasDamsteen() ) {
		//Vrij vakje gevonden. Toevoegen als mogelijke 'move'.
		nodeC.getDamsteen().addMove( new Moves(nodeC, nodeL) );
		if (nodeC.getDamsteen().isDam()) {
		    checkForMoveL( nodeC,  getNodeAt(nodeL.getXCoord() -1, nodeL.getYCoord() +1) );
		    //Argh!! Ik wil niet het hele bord selecteren.. 
		    //this.checkForMoveL( nodeC,  getNodeAt(nodeL.getXCoord() -1, nodeL.getYCoord() -1) );
		}
	    } else if (nodeL.getDamsteen().isOwnedByPlayer() != nodeC.getDamsteen().isOwnedByPlayer()) {
		if ( getNodeAt(nodeL.getXCoord() -1, nodeL.getYCoord() +1) != null && !getNodeAt(nodeL.getXCoord() -1, nodeL.getYCoord() +1).hasDamsteen() )
		    System.out.println ("Iemand kan slaan!");
	    }
	}
    } 
    
    
    private void checkForMoveR(Nodes nodeC, Nodes nodeR) {
	if (nodeR != null) {
	    if (!nodeR.hasDamsteen() ) {
		//Vrij vakje gevonden. Toevoegen als mogelijke 'move'.
		nodeC.getDamsteen().addMove( new Moves(nodeC, nodeR) );
		if (nodeC.getDamsteen().isDam()) {
		    checkForMoveR(nodeC, getNodeAt(nodeR.getXCoord() +1, nodeR.getYCoord() +1) );
		    //Argh!! Zelfde probleem.. Misschien niet recursive aanpakken?
		}
	    } else if (nodeR.getDamsteen().isOwnedByPlayer() != nodeC.getDamsteen().isOwnedByPlayer()) {
		if ( getNodeAt(nodeR.getXCoord() +1, nodeR.getYCoord() +1) != null && !getNodeAt(nodeR.getXCoord() +1, nodeR.getYCoord() +1).hasDamsteen() )
		    System.out.println ("Iemand kan slaan!");
	    }
	}
    }
    */   
    /*
    public void setPossibleMoves (Nodes node) {
	Coord coord = node.getCoord();
	
	if (node.getCoordLeft() != null ) {
	    if (getNodeAt( node.getCoordLeft() ).hasDamsteen() ) {
		if (getNodeAt( node.getCoordLeft() ).getDamsteen().isOwnedByPlayer()) {
		    DamSteen steen = getNodeAt( node.getCoordLeft() ).getDamsteen();
		}
	    } else 
		node.getDamsteen().addMove(node, getNodeAt(getNodeAt(coord).getCoordLeft()) );
	} 
	
	if (node.getCoordRight() != null && !getNodeAt( node.getCoordRight() ).hasDamsteen() ) {
	    node.getDamsteen().addMove(node, getNodeAt(getNodeAt(coord).getCoordRight()) );
	}
    }
    */
}
