package blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BlackJackEngine {
  String naam = null;  
  int aantalAI = 0;
  ArrayList <KAART> deckLijst = null;  
  ArrayList <BlackJackSpeler> spelersLijst = null; 
  double inzet = 0;  
  ArrayList<String> namenLijst = new ArrayList<String>(
      Arrays.asList("Jan", "Piet", "Klaas", "Mo", "Bert", "Hans", "Karel", "Remi",
          "Pieter", "Peter", "Koen", "Patricia", "Johanna", "Anna", "Kofi", "Silvio"));   
  
  public BlackJackEngine (String naam, int aantalAI){
    this.aantalAI = aantalAI;  
    this.naam = naam;    
    mijnInit();
    }
  
  public void mijnInit(){      
    BlackJackKaarten blackJackKaarten = new BlackJackKaarten();
    deckLijst = blackJackKaarten.maakDeck(aantalAI);   
    ArrayList <BlackJackSpeler> spelersLijst = new ArrayList <BlackJackSpeler>(); 
    this.spelersLijst = spelersLijst;
    spelersLijst.add(new BlackJackBank());
    spelersLijst.add(new BlackJackGebruiker());
    spelersLijst.get(1).setNaam(naam);       
    int teller = 16;
    for (int i=0; i<aantalAI; i++){    
      Random ran = new Random();
      int keuze = ran.nextInt(teller);
      String keuzeNaam = namenLijst.get(keuze);
      namenLijst.remove(keuze);
      spelersLijst.add(new BlackJackAI());  
      spelersLijst.get(i+2).setNaam(keuzeNaam);      
      teller --;
    }       
  }
  
  public void inZetten(double inzet){    
    if (inzet <= this.spelersLijst.get(1).getCredits()){
      this.spelersLijst.get(1).setInzet(inzet);
      for (int a=2; a<2+aantalAI; a++){
        spelersLijst.get(a).setInzet(600.0);        
      }
      eersteRonde();
    }
    else { System.out.println("niet genoeg credits");}
  }   
  
  public void eersteRonde(){
    for (int a=0; a<2+aantalAI; a++){
      if (spelersLijst.get(a)instanceof BlackJackBank){
        spelersLijst.get(a).addKAART(deckLijst.get(0));
        deckLijst.remove(0);
      }
      else { spelersLijst.get(a).addKAART(deckLijst.get(0));        
        deckLijst.remove(0);  
        spelersLijst.get(a).addKAART(deckLijst.get(0));     
        deckLijst.remove(0); 
      }
    }
    for (BlackJackSpeler a:spelersLijst){ // Controle op BlackJack
      if (a instanceof BlackJackAI || a instanceof BlackJackGebruiker){              
        if (a.getKAART(0).getWaarde()+ a.getKAART(1).getWaarde()==21 && spelersLijst.get(0).getKAART(0).getWaarde()<10){
          a.setCredits(-2*a.getInzet());            
          a.setStatusTrue();            
          System.out.println("BlackJack voor speler: " + a.getNaam());
        }
      }
      else{}
    }    
    ronde();
  }  
  
  
  public void ronde(){     
    for (int i=2; i<2+aantalAI; i++){
      if (spelersLijst.get(i).getStatus()!= true){
        int total =0;
        int instanceAce = 0;
        for (int b=0; b<spelersLijst.get(i).handLengte(); b++){
          total = total + spelersLijst.get(i).getKAART(b).getWaarde();
          if (spelersLijst.get(i).getKAART(b).getWaarde()==11){
            instanceAce ++;
          }
        }
        while (total<17 || total-(instanceAce*10)<17){
          spelersLijst.get(i).addKAART(deckLijst.get(0));
          if (deckLijst.get(0).getWaarde()==11){
            instanceAce ++;
          }
          total = total + deckLijst.get(0).getWaarde();
          deckLijst.remove(0);
        }        
        total = total - (instanceAce*10);
        spelersLijst.get(i).setScore(total);
      } 
      if (spelersLijst.get(i).getStatus()== true){
        spelersLijst.get(i).setScore(21);
      }
    }
   if (spelersLijst.get(1).getStatus()== true){
     einde();
   }
     hit(); // moet hierna naar focus invoer speler , hit() moet dan verwijderd worden     
  }  

  public void pass(){       
      einde();
    }      

  public void hit(){  
    spelersLijst.get(1).addKAART(deckLijst.get(0));    
    deckLijst.remove(0);    
    int total = 0;
    int instanceAce = 0;
    for (int i=0; i<spelersLijst.get(1).handLengte(); i++){
      total = total + spelersLijst.get(1).getKAART(i).getWaarde();
      if (spelersLijst.get(1).getKAART(i).getWaarde()==11){
        instanceAce ++;
      }      
    }    
    if (total -(instanceAce*10)>21){       
      einde();
    }       
    else{ // maak optie knoppen weer beschikbaar
    }
  }  
  
  public void einde(){
    int total = spelersLijst.get(0).getKAART(0).getWaarde();
    while (total<17){
      spelersLijst.get(0).addKAART(deckLijst.get(0)); 
      total = total + deckLijst.get(0).getWaarde();
      deckLijst.remove(0);
    }
    for (BlackJackSpeler p:spelersLijst){
      String kaarten = "";
      for (int k=0; k<p.handLengte(); k++){
        kaarten = kaarten+ p.getKAART(k) + " / ";
      }
      System.out.println(p.getNaam() + " met kaarten: " + kaarten);
    }
    int punten =0;
    for (int d=0; d<spelersLijst.get(1).handLengte(); d++){
      punten = punten + spelersLijst.get(1).getKAART(d).getWaarde();
    }
    spelersLijst.get(1).setScore(punten);
    for (int l=1; l<2+aantalAI; l++){
      int eindScore = spelersLijst.get(l).getScore();
      if ((eindScore>total && eindScore <22)||(total>21 && eindScore<22)){
        System.out.println(eindScore + " Gefeliciteerd "+ spelersLijst.get(l).getNaam()+(" ,je hebt je inzet van: "+ spelersLijst.get(l).getInzet()+ " verdubbeld!."));
      }
      else if (eindScore==total && eindScore <22){
        System.out.println(eindScore + " Gelukkig "+ spelersLijst.get(l).getNaam()+(" ,je hebt je inzet van: "+ spelersLijst.get(l).getInzet()+ " teruggekregen."));
      }
      else {
        System.out.println(eindScore + " Helaas "+ spelersLijst.get(l).getNaam()+(" ,je hebt je inzet van: "+ spelersLijst.get(l).getInzet()+ " verloren."));        		
      }
    }
    System.out.println("endround");
  }
       
  public String getNaam(){
    return naam;
  }
  
  public int getAantalAI(){
    return aantalAI;
  }  
 
  public static void main(String[] args) {     
  }

}