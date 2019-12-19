package TPZTBCS;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Calzado extends PrendaBuilder
{
	
    public Calzado(){prenda = new Prenda();}
    
    public void buildParte()   { prenda.setParte("Calzado"); }
    
    public void buildTipo(String tipo) throws Exception
    {
//    	if ((jsonReader.getTipoCalzado()).contains(tipo))
//    	{
    		prenda.setStrategy(new noAbriga());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
        	prenda.setTipo(tipo);
        	prenda.setAbrigoTemp(tempQueAbriga);
//    	}
//    	else
//    	{
//    		throw new Exception("ERROR TIPO"); 
//    	}  
    }
    
    public void buildMaterial(String material) throws Exception
    {
//    	if ((jsonReader.getMaterialCalzado()).contains(material))
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
}