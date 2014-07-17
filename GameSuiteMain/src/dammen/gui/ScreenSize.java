/**
 * 
 */
package dammen.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Class description
 * 
 * @version		1.00 15 jul. 2014
 * @author 		Pieter
 */
public class ScreenSize {
    static Dimension prefSize;
    static Dimension maxSize;
    
    public static int HEIGHT;
    public static int WIDTH;
    
    public static int NODESIZE;
    
    public static int KOLOMMEN;
    public static int RIJEN;
    
    static {
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	maxSize = toolkit.getScreenSize();
	prefSize = new Dimension();
	prefSize.setSize(maxSize.getWidth() * 0.5, maxSize.getHeight() * 0.5);
	HEIGHT = (int)prefSize.getHeight(); 
	WIDTH = (int)prefSize.getWidth();
    }
    
    public static void setDammenSize (int kolommen, int rijen) {
	KOLOMMEN = kolommen;
	RIJEN = rijen;
	
	int tmpH = Math.min ( rijen * 50 , (int) maxSize.getHeight() );
	int tmpW = Math.min (kolommen * 50, (int) maxSize.getWidth() );
	
	NODESIZE = Math.min(tmpH / rijen , tmpW / kolommen);
	
	WIDTH = kolommen * NODESIZE;
	HEIGHT = rijen * NODESIZE;
    }

}
