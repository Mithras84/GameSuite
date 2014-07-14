package blackjackdomain;

import blackjackdomain.KAART;
import java.util.ArrayList;

// constructor
public interface BlackJackSpeler {  
  double credits = 0.0;     
  boolean status = false;
  ArrayList <KAART> hand = null;
  double inzet = 0.0;
  
// methoden  
  double getCredits();
  void setCredits(double inzet); 
  String getNaam();
  void setNaam(String naam);
   
  void setInzet(double inzet);
  double getInzet (); 
  
  boolean getStatus();
  void setStatusTrue();  
  
  void addKAART (KAART kaart); 
  KAART getKAART (int index);  
  void clearHand();  
  int handLengte();  
  
  void setScore(int punten);
  int getScore();
}
