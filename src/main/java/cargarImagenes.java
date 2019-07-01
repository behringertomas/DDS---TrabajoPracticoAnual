import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class cargarImagenes {
	BufferedImage img = null;
	
		public void cargarImagen(String nombre,int off) {
			JFrame w = new JFrame("Prenda");
			w.setLocation(0, 0);
			w.setSize(200, 200);
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			try {
			    img = ImageIO.read(new File(nombre+".jpg"));
			    JPanel p= new JPanel(){
			    	protected void paintcomponent(Graphics g) {
			    		g.drawImage(img, off, off, 200,200, null);
			    	}
			    }
			} catch (IOException e) {
			}
	}
	
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
    
}
