package blackjack.domain;

public enum KAART {   
  HTWO (2),
  HTHREE (3),
  HFOUR  (4),
  HFIVE (5),
  HSIX (6),
  HSEVEN (7),
  HEIGHT (8),
  HNINE (9),
  HTEN (10),
  HACE (11),
  HKING (10),
  HQUEEN (10),
  HJACK (10), 
  DTWO (2),
  DTHREE (3),
  DFOUR (4),
  DFIVE (5),
  DSIX (6),
  DSEVEN (7),
  DEIGHT (8),
  DNINE (9),
  DTEN (10),
  DACE (11),
  DKING (10),
  DQUEEN (10),
  DJACK (10), 
  CTWO (2),
  CTHREE (3),
  CFOUR (4),
  CFIVE (5),
  CSIX (6),
  CSEVEN (7),
  CEIGHT (8),
  CNINE (9),
  CTEN (10),
  CACE (11),
  CKING (10),
  CQUEEN (10),
  CJACK (10), 
  STWO (2),
  STHREE (3),
  SFOUR (4),
  SFIVE (5),
  SSIX (6),
  SSEVEN (7),
  SEIGHT (8),
  SNINE (9),
  STEN (10),
  SACE (11),
  SKING (10),
  SQUEEN (10),
  SJACK (10);
  
  private int waarde = 0;
  
  private KAART (int waarde){
    this.waarde = waarde;
  }
  public int getWaarde(){
    return waarde;
  }
  
}