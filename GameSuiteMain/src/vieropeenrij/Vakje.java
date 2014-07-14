package vieropeenrij;

/**
 * Klasse waarin een vakje wordt gecreëerd van het vier op een rij veld. 
 * @author Peter
 *
 */
public class Vakje{
  
  private boolean gevuld = false;
  private boolean speler = false;
  private int rij = 0;
  private int kolom = 0;
  
  /**
   * Constructor: maakt een nieuw vakje aan.
   */
  public Vakje(int rij, int kolom){
    }
  
  /**
   * Verandert of het vakje wel of niet is gevuld.
   * @param status  wel of niet gevuld
   */
  public void setGevuld(boolean status){
    gevuld = status;
  }
  
  /**
   * Vraagt op of het vakje wel of niet is gevuld.
   * @return  true wanneer wel gevuld, false wanneer niet gevuld
   */
  public boolean getGevuld(){
    return gevuld;
  }
  
  /**
   * Vraagt op of de speler aan de beurt is
   * @return  true wanneer speler, false wanneer AI.  
   */
  public boolean getSpeler(){
    return speler;
  }
  
  public void setSpeler(boolean wissel){
    speler = wissel;
  }
  
  public int getRij(){
    return rij;
  }
  public void setRij(int i){
    rij = i;
  }
  
  public int getKolom(){
    return kolom;
  }
  public void setKolom(int i){
    kolom = i;
  }
}

