package blackjackdomain;

import java.util.ArrayList;

public class BlackJackGebruiker implements BlackJackSpeler{  
  double credits = 0.0;     
  boolean heeftBlackJack = false;
  ArrayList <KAART> hand = null;  
  String naam = null;
  double inzet = 0.0;
  int score = 0;
  
  public BlackJackGebruiker (){    
  mijnInit();
  }
  
  public void mijnInit(){
    credits = 500.0;    
    ArrayList <KAART> hand = new ArrayList <KAART> (); 
    this.hand=hand;
  }  
  
  public String getNaam(){
    return naam;
  }
  
  public void setNaam(String naam){
	this.naam = naam;
  }
      
  public double getCredits() {    
    return credits;
  }
  
  public void setCredits(double inzet) {   
	credits = credits - inzet;    
  }
  
  public double getInzet (){
    return inzet;
  }
	  
  public void setInzet(double inzet){    
    this.inzet = inzet;   
    this.setCredits(inzet);    
  }
  
  public boolean getHeeftBlackJack(){
    return heeftBlackJack;
  }
  
  public void setHeeftBlackJack(){
    heeftBlackJack = true;
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
    hand.get(index);
    return (hand.get(index));
  }
  
  public void clearHand (){    
    hand.clear();
  }
  
  public int handLengte(){
    return hand.size(); 
  }  
}