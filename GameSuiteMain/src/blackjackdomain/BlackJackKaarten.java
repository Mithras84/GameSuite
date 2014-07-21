package blackjackdomain;

import java.util.ArrayList;
import java.util.Random;
import blackjackdomain.KAART;

public class BlackJackKaarten {
  KAART [] kaartenLijst = null;   

  /**   
   * Constructors BlackJackKaarten. Lege constructor
   */
  public BlackJackKaarten(){     
  }  
  
  /**
   * 
   * @param het aantal spelers uit de spelersLijst
   * creeert een tijdelijke lijst van van minimaal 3 en maximaal x kaartenspellen,
   * afhankelijk van het aantal spelers.
   * maakt hiervan een Array KAART op Random volgorde en retourneert deze
   */
  
  public ArrayList<KAART> maakDeck (int aantalSpelers){
    ArrayList <KAART> kaartenLijst = new ArrayList <KAART>();
    for (int q=0; q<1+aantalSpelers; q++){
      for (KAART k: KAART.values()){
        kaartenLijst.add(k);         
      }
    }    
    ArrayList <KAART> deck = new ArrayList <KAART>();;    
    for (int k=kaartenLijst.size()-1; k>=0; k--){
      Random ran = new Random();
      int gekozenKaart = ran.nextInt(kaartenLijst.size());
      deck.add(kaartenLijst.get(gekozenKaart));
      kaartenLijst.remove(gekozenKaart);      
    }     
    return deck;
  }    
  }  