/**
 * 
 */
package dammen.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

/**
 * Class description
 * 
 * @version		1.00 17 jul. 2014
 * @author 		Pieter
 */
public class ImageHelper {
    
    static public BufferedImage getImageFromFile (String imageName ) {
	BufferedImage img = null;
	try {
	    Path path = FileSystems.getDefault().getPath("img", imageName+".jpg");
	    System.out.println(path);
	    img = ImageIO.read(new File ("E:\\Java\\Workspace\\GameSuite\\GameSuiteMain\\src\\dammen\\gui\\img\\" + imageName+".jpg"));	    
	} catch (IOException e) {
	    System.out.println(e.toString());
	    System.out.println("File not found :(");
	    return null;
	}
	return img;
    }
    
    

}
