package TPZTBCS;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Imagen
{
 private JFrame ventana;
 private JPanel contenedor;
 private ImageIcon imagen;
 private JLabel etiqueta;
 
  public Imagen(String descripcion, String direccionImagen)
  {
   ventana = new JFrame(descripcion);
   contenedor = new JPanel();
   imagen = new ImageIcon(getClass().getResource(direccionImagen));
   etiqueta = new JLabel(imagen);
  }

  public void mostrarImagen()
  {
   contenedor.add(etiqueta); 
   ventana.getContentPane().add(contenedor);
   ventana.pack();
   ventana.setResizable(false);
   ventana.setVisible(true);
   ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}