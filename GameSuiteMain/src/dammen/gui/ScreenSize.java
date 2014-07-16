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
    
    static {
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	maxSize = toolkit.getScreenSize();
	prefSize = new Dimension();
	prefSize.setSize(maxSize.getWidth() * 0.5, maxSize.getHeight() * 0.5);
	HEIGHT = (int)prefSize.getHeight(); //Voor de menubalk
	WIDTH = (int)prefSize.getWidth();
    }

}
