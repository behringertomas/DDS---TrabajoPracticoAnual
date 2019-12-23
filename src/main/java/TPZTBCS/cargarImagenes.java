package TPZTBCS;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cargarImagenes {

	public void cargarImagenes(Prenda prenda) {
		
		String direccionImagen = prenda.getDireccionImagen();
		String descripcionImagen = prenda.getDescripcion();
		
		Imagen imagen = new Imagen(descripcionImagen, direccionImagen);
		
		imagen.mostrarImagen();

	}
}