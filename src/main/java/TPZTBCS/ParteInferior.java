package TPZTBCS;
<<<<<<< HEAD
=======

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

>>>>>>> Entrega5
public class ParteInferior extends PrendaBuilder
{    
    public ParteInferior(){prenda = new Prenda();}
    
    public void buildParte()   { prenda.setParte("Parte Inferior"); }
    
    public void buildTipo(String tipo) throws Exception
    {
<<<<<<< HEAD
    	if ((jsonReader.getTipoParteInferior()).contains(tipo))
    	{
=======
//    	if ((jsonReader.getTipoParteInferior()).contains(tipo))
//    	{
>>>>>>> Entrega5
    		prenda.setStrategy(new noAbriga());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
        	prenda.setTipo(tipo);
        	prenda.setAbrigoTemp(tempQueAbriga);
<<<<<<< HEAD
        	
    	}
    	else
    	{
    		throw new Exception("ERROR TIPO"); 
    	}  
=======
//        	
//    	}
//    	else
//    	{
//    		throw new Exception("ERROR TIPO"); 
//    	}  
>>>>>>> Entrega5
    }
    
    public void buildMaterial(String material) throws Exception
    {
<<<<<<< HEAD
    	if ((jsonReader.getMaterialParteInferior()).contains(material))
    	{
        	prenda.setMaterial(material);
    	}
    	else
    	{
    		throw new Exception("ERROR MATERIAL"); 
    	} 
    }
=======
//    	if ((jsonReader.getMaterialParteInferior()).contains(material))
//    	{
        	prenda.setMaterial(material);
//    	}
//    	else
//    	{
//    		throw new Exception("ERROR MATERIAL"); 
//    	} 
    }

	@Override
	public void buildUrl(String img_url) throws Exception {
		prenda.setDireccionImagen(img_url);
		
	}

	@Override
	public void buildImagen() throws Exception {

		if(prenda.getDireccionImagen() != "") {
			
			  File file = new File(prenda.getDireccionImagen());
		      BufferedImage bImage = ImageIO.read(file);
		      ByteArrayOutputStream bos = new ByteArrayOutputStream();
		      ImageIO.write(bImage, "png", bos );
		      byte[] data = bos.toByteArray();
		      prenda.instanciar_array_bytes(file);
		      prenda.setImagen(data);
		}
		
	}
>>>>>>> Entrega5
}
