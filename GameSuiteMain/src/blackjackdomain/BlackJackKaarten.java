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
   * @param het aantal AI spelers
   * creeert een tijdelijke lijst van van minimaal 3 en maximaal 6 kaartenspellen,
   * afhankelijk van het aantal gekozen AI-spelers.
   * maakt hiervan een Array KAART op Random volgorde en retourneert deze
   */
  
  public ArrayList<KAART> maakDeck (int aantalAI){
    ArrayList <KAART> kaartenLijst = new ArrayList <KAART>();
    for (int q=0; q<3+aantalAI; q++){
      for (KAART k: KAART.values()){
        kaartenLijst.add(k);         
      }
    }    
    ArrayList <KAART> deck = new ArrayList <KAART>();;
    int teller = kaartenLijst.size()-1;
    for (int k=kaartenLijst.size()-1; k>=0; k--){
      Random ran = new Random();
      int removal = ran.nextInt(teller+1);
      deck.add(kaartenLijst.get(removal));
      kaartenLijst.remove(removal);        
      teller --;
    }     
    return deck;
  }  
  
  }  
