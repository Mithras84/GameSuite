package blackjackdomain;

import java.util.ArrayList;

public class BlackJackAI implements BlackJackSpeler{
  double credits = 0.0;     
  boolean status = false;
  ArrayList <KAART> hand = null;  
  String naam = null;
  double inzet = 0.0;
  int score = 0;
  
  public BlackJackAI (){       
    mijnInit();
    }
    
    public void mijnInit(){
      credits = 500.0;
      ArrayList <KAART> hand = new ArrayList <KAART> (); 
      this.hand=hand;
    }  
  
  public double getCredits() {    
    return credits;    
  }  
  
  public void setNaam(String naam){
    this.naam =  naam;
  }
  
  public String getNaam(){
    return naam;
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
  
  public void setCredits(double inzet) {    
    credits = credits - inzet;    
  }
  
  public void setInzet(double inzet){
  this.inzet = inzet;   
  this.setCredits(inzet);
  }
  
  public double getInzet (){
  return inzet;
  }
  
  public void setStatusTrue(){
    status = true;
  }  
    
  public boolean getStatus(){
    return status;
  }
  
  public void setScore(int punten){
    score = punten;
  }
  public int getScore(){
    return score;
  }
 
}