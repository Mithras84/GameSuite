package vieropeenrij;

import java.awt.Color;

/**
 * Klasse waarin een vakje wordt gecreëerd van het vier op een rij veld. 
 * @author Peter
 *
 */
public class Vakje{
  
  private boolean gevuld = false;
  private Color schijfkleur = null;
  
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
   * Geeft het schijfje een bepaalde kleur.
   * @param kleur  de kleur
   */
  public void setKleur(Color kleur){
    schijfkleur = kleur;
  }
  
  /**
   * Vraagt de kleur van het schijfje op.
   * @return  de kleur
   */
  public Color getKleur(){
    return schijfkleur;
  }
}

