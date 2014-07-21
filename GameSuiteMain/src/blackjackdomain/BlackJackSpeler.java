package blackjackdomain;

// constructor
public interface BlackJackSpeler {    
  
// methoden  
  String getNaam();
  void setNaam(String naam);
	  
  double getCredits();
  void setCredits(double inzet);   
  
  double getInzet ();
  void setInzet(double inzet);   
  
  boolean getHeeftBlackJack();
  void setHeeftBlackJack();  
  
  void setScore(int punten);
  int getScore();
  
  void addKAART (KAART kaart); 
  KAART getKAART (int index);  
  void clearHand();  
  int handLengte();   
}