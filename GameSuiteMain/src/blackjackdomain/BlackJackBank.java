package blackjackdomain;

import java.util.ArrayList;

public class BlackJackBank implements BlackJackSpeler {
  ArrayList <KAART> hand = null;
  double credits = 0.0;      
  boolean heeftBlackJack = false;    
  String naam = "Bank";  
  int score = 0;
  
  public BlackJackBank (){   
    mijnInit();
    }
    
    public void mijnInit(){
      credits = 500000.0;  
      ArrayList <KAART> hand = new ArrayList <KAART> (); 
      this.hand=hand;
    }  
  
  public String getNaam(){
    return naam;
  }
      
  public void setNaam(String naam){  
  }
  
  public double getCredits() {    
    return -1;
  } 
  
  public void setCredits(double inzet) {     
  }
  
  public double getInzet (){
    return -1;
  }
  
  public void setInzet(double inzet){
  }
  
  public boolean getHeeftBlackJack(){ 
    return heeftBlackJack;
  }
  
  public void setHeeftBlackJack(){    
  }  
  
  public int getScore(){
    return score;
  }

  public void setScore(int punten){
    score = punten;
  }
  
  public void addKAART (KAART kaart){
    hand.add(kaart);
  }
  
  public KAART getKAART (int index){ 
	KAART kaart = hand.get(index);  
    return kaart;
  }
  
  public void clearHand (){    
    hand.clear();
  }
  
  public int handLengte(){
    return hand.size();
  } 
}