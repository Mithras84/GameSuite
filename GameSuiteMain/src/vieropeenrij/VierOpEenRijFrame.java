package vieropeenrij;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Klasse voor het tonen van een vier-op-een-rij spel
 * @author Peter
 *
 */
public class VierOpEenRijFrame extends JFrame{
  
  private static final int RIJEN = 6;
  private static final int KOLOMMEN = 7;
  private static final int RANDLENGTE = 50;
  private static final int FRAME_BREEDTE = KOLOMMEN * RANDLENGTE;
  private static final int FRAME_HOOGTE = RIJEN * RANDLENGTE;
  private JPanel knoppenveld = null;
  private JButton knop = null;
  private Veld veld = new Veld();
  private Vakje vakje = null;
  
  public VierOpEenRijFrame(){
  super();
  initialize();
  }
  
  /**
   * Verzorgt de layout van het venster.
   * Venster bestaat uit 2 gedeelten: het knoppengedeelte en het veldgedeelte
   */
  public void initialize(){
    //settings voor venster
    setTitle("Speel vier op een rij!");
    setSize(FRAME_BREEDTE, FRAME_HOOGTE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation((dim.width - FRAME_BREEDTE) / 2,(dim.height - FRAME_HOOGTE) / 2);
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
   
    //maakt rij met knoppen
    knoppenveld = new JPanel();
    knoppenveld.setLayout(new GridLayout(0, KOLOMMEN));
    pane.add(knoppenveld, BorderLayout.NORTH);
    for(int i = 0; i < KOLOMMEN; i++){
      knop = new JButton("" + (i+1));
      knop.setPreferredSize(new Dimension (RANDLENGTE, RANDLENGTE));
      knop.addActionListener(new KnopLuisteraar()); 
      knoppenveld.add(knop);
    }  
    //maakt speelveld
    pane.add(veld, BorderLayout.CENTER);
    pack();
  }
  
  public static void main(String[] args) {
    VierOpEenRijFrame frame = new VierOpEenRijFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  public class KnopLuisteraar implements ActionListener{
    public void actionPerformed(ActionEvent e){
    int knopnummer = Integer.parseInt(knop.getText());
    vakje = veld.getVakje(knopnummer - 1, 0);
    vakje.setGevuld(true);
    veld.repaint();
    vakje.setSpeler(true);
    System.out.println(knop.getText());
    }
  }
}
  
