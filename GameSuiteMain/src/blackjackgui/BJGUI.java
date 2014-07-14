/**
 * Deze gui leent van de volgende packages:
 */
package blackjackgui;
/**
 * Deze gui import de volgende files:
 */
import blackjackdomain.BlackJackEngine;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 * Deze gui heeft de volgende attributen:
 */
public class BJGUI extends JFrame {
  private static final long serialVersionUID = 1L;      
  public static int schermX = 0;
  public static int schermY = 0;
  public static float refactorwaardeX = 1.0F;  // MOET VANUIT SPEL DOORGEGEVEN WORDEN = schermX/1024
  public static float refactorwaardeY = 1.0F;  // MOET VANUIT SPEL DOORGEGEVEN WORDEN = schermY /768
  public static int KAARTSIZEX = (int)(100*refactorwaardeX);
  public static int KAARTSIZEY = (int)(190*refactorwaardeY);
  public static int MUCKRUIMTE = (int)(25*refactorwaardeX);
  public static int FOLDRUIMTE = 8*MUCKRUIMTE; 
  public static int TUSSENRUIMTEX = (int)(5*refactorwaardeX);
  public static int TUSSENRUIMTEY = (int)(5*refactorwaardeY);
  public static int TEKSTVAKBREEDTE = (int)(80*refactorwaardeX);
  public static int TEKSTVAKHOOGTE = (int)(25*refactorwaardeY);  
  public int aantalAI = 0;
  /**
   * This is the default constructor
   */
  public BJGUI() {
    super();
    initialize();
  }
  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {    
    // Schaling scherm EDIT: bij starten GameSuite al vaststellen
    Dimension dimensie = Toolkit.getDefaultToolkit().getScreenSize();
    schermX = dimensie.width;
    schermY = dimensie.height;    
    this.setSize(schermX, schermY);    
    // Initialisatie ContentPane
    Container pane = getContentPane();
    pane.setLayout(null);
    //pane.setBackground(Color.GREEN);
    this.setTitle("BlackJack!");      
      // pak naam uit namenlijst en voeg deze aan label toe. maak voor elke speler een plaats op aiPane
    
    
    // voeg nog connectie namen uit lijst aan Label toe
    
 // Initialisatie aiPane om instanties van jAIPane in te bewaren
    Container aiPane = new Container();
    aiPane.setBounds(TUSSENRUIMTEX, (3*TUSSENRUIMTEY)+ TEKSTVAKHOOGTE + KAARTSIZEY , (3*FOLDRUIMTE)+(2*TUSSENRUIMTEX),(4*TUSSENRUIMTEY)+(3*TEKSTVAKHOOGTE)+2*KAARTSIZEY);        
    pane.add(aiPane); 
    
    // Inititalisatie delersDeck van de Bank
    ImageIcon deckKaart = new ImageIcon ("blackjackdata/Achter.png"); 
    JLabel jDeck = new JLabel();    
    jDeck.setSize(new Dimension (KAARTSIZEX, KAARTSIZEY));
    jDeck.setLocation(TUSSENRUIMTEX, (2*TUSSENRUIMTEY)+TEKSTVAKHOOGTE);  
    jDeck.setIcon(deckKaart);
    pane.add(jDeck);       
    
    // Initialisatie Bank, met jBank voor Labelnaam, jBankPanel voor panel
    // en jBankStatus voor weergave "Pass";
    //jBank
    JLabel jBank = new JLabel("Bank");       
    jBank.setBounds((2*TUSSENRUIMTEX)+ KAARTSIZEX,TUSSENRUIMTEY, TEKSTVAKBREEDTE, TEKSTVAKHOOGTE);
    jBank.setBackground(Color.BLACK);       
    jBank.setOpaque(true);
    pane.add(jBank); 
    //jBankStatus
    JLabel jBankStatus = new JLabel ("Status");
    jBankStatus.setBounds((3*TUSSENRUIMTEX)+2*KAARTSIZEX, TUSSENRUIMTEY, TEKSTVAKBREEDTE, TEKSTVAKHOOGTE);
    jBankStatus.setBackground(Color.BLUE);       
    jBankStatus.setOpaque(true);
    pane.add(jBankStatus); 
    // Initialisatie jBankKaartenPanel
    Container jBankPane = new Container();
    jBankPane.setBounds((2*TUSSENRUIMTEX)+KAARTSIZEX, (2*TUSSENRUIMTEY)+TEKSTVAKHOOGTE, KAARTSIZEX+FOLDRUIMTE, KAARTSIZEY);
    jBankPane.setBackground(Color.BLUE);     
    pane.add(jBankPane);     
    // TESTWAARDEN VOOR TESTEN KAARTVOLGORDE OP SCHERM
    /*JLabel TEST1 = new JLabel("TEST1");       
    TEST1.setSize(KAARTSIZEX, KAARTSIZEY);
    TEST1.setLocation(0+0, 0+0);
    TEST1.setBackground(Color.YELLOW);  
    TEST1.setOpaque(true);    
    jBankPane.add(TEST1);      
    JLabel TEST2 = new JLabel("TEST2");       
    TEST2.setSize(KAARTSIZEX, KAARTSIZEY);
    TEST2.setLocation(0+MUCKRUIMTE, 0+0);
    TEST2.setBackground(Color.BLUE);  
    TEST2.setOpaque(true);    
    jBankPane.add(TEST2);      
    JLabel TEST3 = new JLabel("TEST3");       
    TEST3.setSize(KAARTSIZEX, KAARTSIZEY);
    TEST3.setLocation(0+2*MUCKRUIMTE, 0+0);
    TEST3.setBackground(Color.GREEN);  
    TEST3.setOpaque(true);    
    jBankPane.add(TEST3);      
    JLabel TEST4 = new JLabel("TEST4");       
    TEST4.setSize(KAARTSIZEX, KAARTSIZEY);
    TEST4.setLocation(0+3*MUCKRUIMTE, 0+0);
    TEST4.setBackground(Color.BLACK);  
    TEST4.setOpaque(true);    
    jBankPane.add(TEST4);*/        
    // jBankPanel
    JPanel jBankPanel = new JPanel();
    jBankPanel.setBounds((2*TUSSENRUIMTEX)+KAARTSIZEX, TUSSENRUIMTEY, 3*KAARTSIZEX, TUSSENRUIMTEY+TEKSTVAKHOOGTE+KAARTSIZEY);
    // tempEdit: jBankPanel.setBackground(Color.BLACK);     
    jBankPanel.setToolTipText("Bank / Casino");
    // tempEdit: jBankPanel.setOpaque(true);
    pane.add(jBankPanel); 
    
    // Initialisatie mededelingenTextArea
    JTextArea mededelingenTextArea = new JTextArea("Mededelingengebied");
    mededelingenTextArea.setBounds((3*TUSSENRUIMTEX)+4*KAARTSIZEX, TUSSENRUIMTEY, KAARTSIZEX+7*TUSSENRUIMTEX, TUSSENRUIMTEY+TEKSTVAKHOOGTE+KAARTSIZEY);
    mededelingenTextArea.setToolTipText("Mededelingen");
    pane.add(mededelingenTextArea);         
    
    // Initialisatie van jgebruikerContainer
    Container jgebruikerPane = new Container();
    jgebruikerPane.setBounds((3*FOLDRUIMTE)+(6*TUSSENRUIMTEX),TUSSENRUIMTEY,2*KAARTSIZEX+2*TEKSTVAKBREEDTE ,(9*TEKSTVAKHOOGTE)+(9*TUSSENRUIMTEY)+3*KAARTSIZEY);        
    pane.add(jgebruikerPane); 
    jgebruikerPane.setBackground(Color.CYAN);    
    
    // Initialisatie diverse knoppen gebruikersoverview + plaatsing verborgen container splitsing
    // Initialisatie van jgebruikerNaam
    JLabel jgebruikerNaam = new JLabel();
    jgebruikerNaam.setBounds(TUSSENRUIMTEX,TUSSENRUIMTEY+TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikerNaam); 
    jgebruikerNaam.setBackground(Color.RED);
    jgebruikerNaam.setOpaque(true);
    // Initialisatie van jgebruikerStatus
    JLabel jgebruikerStatus = new JLabel();
    jgebruikerStatus.setBounds(TUSSENRUIMTEX,2*TUSSENRUIMTEY+2*TEKSTVAKHOOGTE ,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikerStatus); 
    jgebruikerStatus.setBackground(Color.RED);
    jgebruikerStatus.setOpaque(true);
    // Initialisatie van jgebruikerCreditStatus
    JLabel jgebruikerCreditStatus = new JLabel();
    jgebruikerCreditStatus.setBounds(TUSSENRUIMTEX,3*TUSSENRUIMTEY+3*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikerCreditStatus); 
    jgebruikerCreditStatus.setBackground(Color.RED);
    jgebruikerCreditStatus.setOpaque(true);
    // Initialisatie van jgebruikersInzet
    JLabel jgebruikersInzet = new JLabel();
    jgebruikersInzet.setBounds(TUSSENRUIMTEX,4*TUSSENRUIMTEY+4*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikersInzet); 
    jgebruikersInzet.setBackground(Color.RED);
    jgebruikersInzet.setOpaque(true);
    // Initialisatie van jgebruikerHit1
    JButton jgebruikerHit1 = new JButton("Hit");
    jgebruikerHit1.setBounds(TUSSENRUIMTEX,5*TUSSENRUIMTEY+5*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikerHit1);     
    // Initialisatie van jgebruikerPass1
    JButton jgebruikerPass1 = new JButton("Pass");
    jgebruikerPass1.setBounds(TUSSENRUIMTEX,6*TUSSENRUIMTEY+6*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikerPass1); 
    // Initialisatie van jgebruikerVerdubbelen1
    JButton jgebruikerVerdubbelen1 = new JButton("Dubbel");
    jgebruikerVerdubbelen1.setBounds(TUSSENRUIMTEX,7*TUSSENRUIMTEY+7*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikerVerdubbelen1);
    // Initialisatie van jgebruikerSplits
    JButton jgebruikerSplits = new JButton("Splits");
    jgebruikerSplits.setBounds(TUSSENRUIMTEX,8*TUSSENRUIMTEY+8*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane.add(jgebruikerSplits);
    jgebruikerSplits.setVisible(false);
    // Initialisatie van jgebruikerSet1
    JLabel jgebruikerSet1 = new JLabel();
    jgebruikerSet1.setBounds(2*TUSSENRUIMTEX+TEKSTVAKBREEDTE,3*TUSSENRUIMTEY+TEKSTVAKHOOGTE,FOLDRUIMTE ,KAARTSIZEY);        
    jgebruikerPane.add(jgebruikerSet1);
    jgebruikerSet1.setBackground(Color.MAGENTA);
    jgebruikerSet1.setOpaque(true);    
    
 // Initialisatie van jgebruikerContainer2 voor de gesplitste toevoeging
    Container jgebruikerPane2 = new Container();
    jgebruikerPane2.setBounds(TUSSENRUIMTEX,9*TUSSENRUIMTEY+9*TEKSTVAKHOOGTE + TEKSTVAKBREEDTE,2*KAARTSIZEX+2*TEKSTVAKBREEDTE ,KAARTSIZEY);        
    jgebruikerPane.add(jgebruikerPane2); 
    jgebruikerPane2.setBackground(Color.CYAN); 
    jgebruikerPane2.setVisible(false);
   
    // Initialisatie van jgebruikerStatus2
    JLabel jgebruikerStatus2 = new JLabel();
    jgebruikerStatus2.setBounds(TUSSENRUIMTEX,TUSSENRUIMTEY,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane2.add(jgebruikerStatus2); 
    jgebruikerStatus2.setBackground(Color.RED);
    jgebruikerStatus2.setOpaque(true);  
    jgebruikerStatus2.setVisible(false);
    // Initialisatie van jgebruikersInzet2
    JLabel jgebruikersInzet2 = new JLabel();
    jgebruikersInzet2.setBounds(TUSSENRUIMTEX,2*TUSSENRUIMTEY+TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane2.add(jgebruikersInzet2); 
    jgebruikersInzet2.setBackground(Color.RED);
    jgebruikersInzet2.setOpaque(true);
    jgebruikersInzet2.setVisible(false);
    // Initialisatie van jgebruikerHit2
    JButton jgebruikerHit2 = new JButton("Hit");
    jgebruikerHit2.setBounds(TUSSENRUIMTEX,3*TUSSENRUIMTEY+2*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane2.add(jgebruikerHit2);     
    jgebruikerHit2.setVisible(false);
    // Initialisatie van jgebruikerPass2
    JButton jgebruikerPass2 = new JButton("Pass");
    jgebruikerPass2.setBounds(TUSSENRUIMTEX,4*TUSSENRUIMTEY+3*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane2.add(jgebruikerPass2); 
    jgebruikerPass2.setVisible(false);
    // Initialisatie van jgebruikerVerdubbelen2
    JButton jgebruikerVerdubbelen2 = new JButton("Dubbel");
    jgebruikerVerdubbelen2.setBounds(TUSSENRUIMTEX,5*TUSSENRUIMTEY+4*TEKSTVAKHOOGTE,TEKSTVAKBREEDTE ,TEKSTVAKHOOGTE);        
    jgebruikerPane2.add(jgebruikerVerdubbelen2);   
    jgebruikerVerdubbelen2.setVisible(false);
    // Initialisatie van jgebruikerSet2
    JLabel jgebruikerSet2 = new JLabel();
    jgebruikerSet2.setBounds(2*TUSSENRUIMTEX+TEKSTVAKBREEDTE,TUSSENRUIMTEY,FOLDRUIMTE ,KAARTSIZEY);        
    jgebruikerPane2.add(jgebruikerSet2);
    jgebruikerSet2.setBackground(Color.MAGENTA);
    jgebruikerSet2.setOpaque(true);
    jgebruikerSet2.setVisible(false);
    
    pane.validate();
    
  } 
  
  public static void main(String[] args) {    
    BJGUI bjGUI = new BJGUI();
    bjGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
    bjGUI.setVisible(true);    
  }
}