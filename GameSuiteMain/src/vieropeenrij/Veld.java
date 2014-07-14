package vieropeenrij;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/**
 * Grafische weergave van het speelveld.
 * @author Peter
 *
 */
public class Veld extends JPanel{
  
  private static final int RIJEN = 6;
  private static final int KOLOMMEN = 7;
  private static final int RANDLENGTE = 50;
  private Rectangle2D rand = null;
  private Ellipse2D cirkel = null;
  Vakje vakje = null;
  Vakje[][] raster = new Vakje[KOLOMMEN][RIJEN];
  
  /**
   * Constructor: maakt een nieuw speelveld aan
   */
  public Veld(){
    super();
    setPreferredSize(new Dimension(RANDLENGTE * KOLOMMEN, RANDLENGTE * RIJEN));
    for(int col = 0; col < KOLOMMEN; col++){
      for(int rij = 0; rij < RIJEN; rij++){
        raster[col][rij] = new Vakje (col, rij);
      }
    }
    }
  
  /**
   * Tekent een vier-op-een-rij veld.
   * @param g2d grafische context
   */
  protected void paintComponent(Graphics g){
    super.paintComponents(g);
    Graphics2D g2d = (Graphics2D)g;
    for(int i = 0; i < KOLOMMEN; i++){
      for(int j = 0; j < RIJEN; j++){
        rand = new Rectangle2D.Double(i*RANDLENGTE, j*RANDLENGTE, RANDLENGTE, RANDLENGTE); 
        g2d.setColor(Color.BLUE);
        g2d.fill(rand);
        cirkel = new Ellipse2D.Double(i*RANDLENGTE, j*RANDLENGTE, RANDLENGTE * 0.9, RANDLENGTE * 0.9);
        if(raster[i][j].getGevuld() && raster[i][j].getSpeler()){
          g2d.setColor(Color.RED);
        }
        else if(raster[i][j].getGevuld() && raster[i][j].getSpeler() == false){
          g2d.setColor(Color.YELLOW);
        }
        else{
          g2d.setColor(Color.WHITE);
        }
        g2d.fill(cirkel);
      }
    }
  }
  
  public Vakje getVakje(int kolom, int rij){
    vakje = raster[kolom][rij];
    return vakje;
  }
}
