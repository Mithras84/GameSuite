package blackjackdomain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

/**
 * BlackJack
 * @author JJV
 *
 */

public class BlackJackMain extends JFrame{
  private static final long serialVersionUID = 1L;
  ArrayList <KAART> deck = null;  
  ArrayList <BlackJackSpeler> spelersLijst = null;
  ArrayList <String> namenLijst = new ArrayList<String>(
	Arrays.asList("Jan", "Piet", "Klaas", "Mo", "Bert", "Hans", "Karel", "Remi",
	"Pieter", "Peter", "Koen", "Patricia", "Johanna", "Anna", "Kofi", "Silvio"));
  String naam = null;  
  int aantalAI = 0;
  int aantalSpelers = 0;      
  
 /*
  * @param naam; naam van de speler, aantalAI; aantal computertegenstanders
  * Constructor
  */
  
  public BlackJackMain (String naam, int aantalAI){
    this.aantalAI = aantalAI;  
    this.naam = naam;    
    mijnInit();
    }  
  
  /*
   * mijnInit; aanmaken deck kaarten op basis van aantal AI tegenstanders.
   * Vullen van de spelersLijst met op [0] de bank en op [1] de speler, de overige plaatsen worden gevuld met AI-spelers
   */
  
  public void mijnInit(){  	    
    ArrayList <BlackJackSpeler> spelersLijst = new ArrayList <BlackJackSpeler>();      
    this.spelersLijst = spelersLijst;
    spelersLijst.add(new BlackJackBank());
    spelersLijst.add(new BlackJackGebruiker());
    spelersLijst.get(1).setNaam(naam);       
    int teller = namenLijst.size();
    for (int i=0; i<aantalAI; i++){    
      Random ran = new Random();
      int keuze = ran.nextInt(teller);
      String keuzeNaam = namenLijst.get(keuze);
      namenLijst.remove(keuze);
      spelersLijst.add(new BlackJackAI());  
      spelersLijst.get(i+2).setNaam(keuzeNaam);      
      teller --;
    }   
    aantalSpelers = spelersLijst.size();       
  }
  
  /*
   * @param de inzet van de speler voor het begin van het spel, zoals gevraagd in de gui
   * na het controleren van de inzet begint de eersteRonde. Hierna worden de kaarten ook gemaakt.
   */  
  public boolean inZetten(double inzet){ 
	clearHand();
	BlackJackKaarten blackJackKaarten = new BlackJackKaarten();
    deck = blackJackKaarten.maakDeck(aantalSpelers);
    if (inzet <= spelersLijst.get(1).getCredits()){
      this.spelersLijst.get(1).setInzet(inzet);      
      for (int a=2; a<aantalSpelers; a++){
        spelersLijst.get(a).setInzet(20.0);     
      }          
      eersteRonde(); 
      return true;             
    }
    else {    	
    	return false;
    	}
  }   
  
  /*
   * In de eersteRonde wordt aan de Bank 1 kaart uitgedeeld en aan de rest
   * van de spelers 2 kaarten. Hierbij wordt gekeken of de speler een BlackJack heeft
   * Na dit begin van het spel volgt de Ronde voor de AI
   */
  
  public void eersteRonde(){
	for (BlackJackSpeler a:spelersLijst){ 
      if (a instanceof BlackJackBank){
        a.addKAART(deck.get(0));        
        deck.remove(0);
      }
      else {a.addKAART(deck.get(0));        
      	deck.remove(0);  
        a.addKAART(deck.get(0));     
        deck.remove(0); 
        if (a.getKAART(0).getWaarde()+ a.getKAART(1).getWaarde()==21 && spelersLijst.get(0).getKAART(0).getWaarde()<10){
            a.setCredits(-2*a.getInzet());            
            a.setHeeftBlackJack();             
        }
      }
	}   	
    ronde();
  }  
  
  /*
   *  In deze ronde berekent Main voor elke AI hoeveel kaarten deze afneemt
   *  de totale score van de kaarten wordt berekend en opgeslagen in de instantie van de Speler
   */
  
  public void ronde(){   // true als mijnInit mag starten  
    for (int i=2; i<aantalSpelers; i++){
      if (spelersLijst.get(i).getHeeftBlackJack()!= true){
        int score = 0;
        int aantalAzen = 0;
        for (int b=0; b<spelersLijst.get(i).handLengte(); b++){
        	score = score + spelersLijst.get(i).getKAART(b).getWaarde();
          if (spelersLijst.get(i).getKAART(b).getWaarde()==11){
        	  aantalAzen ++;
          }
        }
        while (score-(aantalAzen*10)<17){
          spelersLijst.get(i).addKAART(deck.get(0));
          if (deck.get(0).getWaarde()==11){
        	  aantalAzen ++;
          }
          score = score + deck.get(0).getWaarde();
          deck.remove(0);
        }        
      } 
      else {};
    }   
   if (spelersLijst.get(1).getHeeftBlackJack()== true){
	     einde ();	     	     
   }
   else  {} // moet hierna naar focus invoer speler    
  }          
  
  public void hit(){  // false is af. true is door
    spelersLijst.get(1).addKAART(deck.get(0));    
    deck.remove(0);    
    int score = 0;
    int aantalAzen = 0;    
    for (int i=0; i<spelersLijst.get(1).handLengte(); i++){
    	score = score + spelersLijst.get(1).getKAART(i).getWaarde();
      if (spelersLijst.get(1).getKAART(i).getWaarde()==11){
    	  aantalAzen ++;    	  
      }      
    }       
    if (score -(aantalAzen*10)>21){        
                
    }       
    else{}
  }    
  
  public void einde(){	  
    int bankScore = spelersLijst.get(0).getKAART(0).getWaarde();
    while (bankScore<17){
      spelersLijst.get(0).addKAART(deck.get(0)); 
      bankScore = bankScore + deck.get(0).getWaarde();
      deck.remove(0);
    }    
    berekenScore();
    for (BlackJackSpeler g:spelersLijst){
      if (g instanceof BlackJackAI || g instanceof BlackJackGebruiker){
      int eindScore = g.getScore();
      if ((eindScore>bankScore && eindScore <22)||(bankScore>21 && eindScore<22)){
    	  g.setCredits(-2*g.getInzet());        
      }
      else if (eindScore==bankScore && eindScore <22){
    	  g.setCredits(-1*g.getInzet());        
      }
      else {}
      }
    }    
  }  
  
  public void berekenScore(){	  
	  for (BlackJackSpeler b:spelersLijst){	
		  int score = 0;
		  if (b instanceof BlackJackBank){			  		  
			  for (int d=0; d<b.handLengte(); d++){
				  score = score + b.getKAART(d).getWaarde(); 
		  }}
		  else{	
	      int aantalAAS = 0;
		  for (int d=0; d<b.handLengte(); d++){
			  score = score + b.getKAART(d).getWaarde();			  
			  if (b.getKAART(d).getWaarde()==11 && b.getHeeftBlackJack()!=true){
				  aantalAAS ++;
			  }
			  if (score>21 && aantalAAS!=0){
				  score = score -10;
			  }
	  }   }
	  b.setScore(score);
	  }
  }   
  
  // HULPMETHODEN INTERN EN VOOR FRAME  
  public void setSpelerCredits (int nummer, double credits){
	  spelersLijst.get(nummer).setCredits(credits);
  }
  
  public String getSpelerCredits(int nummer){
	  if (spelersLijst.get(nummer) instanceof BlackJackBank){
		  return "";
	  }
	  else {
	  return "" + spelersLijst.get(nummer).getCredits();
	  }
  }
  
  public String getSpelerInzet (int nummer){
	  if (spelersLijst.get(nummer) instanceof BlackJackBank){
		  return "";
	  }
	  else {
	  return "" + spelersLijst.get(nummer).getInzet();
	  }
  }
  
  public int getAantalSpelers(){
	  return aantalSpelers;
  }
  
  public String getSpelerNaam(int nummer){
	  String Speler = spelersLijst.get(nummer).getNaam();
	  return Speler;	  
  }  
  
  public int vraagHandLengte (int spelernummer){
	  return spelersLijst.get(spelernummer).handLengte();
  }
  
  public KAART vraagKAART(int spelernummer, int kaartnummer){
	  return spelersLijst.get(spelernummer).getKAART(kaartnummer);
  }
  
  public void clearHand(){
	  for (BlackJackSpeler p:spelersLijst){
		  p.clearHand();
	  }
  }
  
  public int vraagScore (int spelernummer){
	  berekenScore();
	  if (spelersLijst.get(spelernummer).getHeeftBlackJack()){
		  return 21;
	  }
	  else {
		  return spelersLijst.get(spelernummer).getScore();
	  }		  
  }
  
  public boolean getHeeftBlackJack(int spelernummer){
	  return spelersLijst.get(spelernummer).getHeeftBlackJack();
  } 
 
  public static void main(String[] args) {   	  
  }

}