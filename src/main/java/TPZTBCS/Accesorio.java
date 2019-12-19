package TPZTBCS;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

import TPZTBCS.dao.abrigoJsonDao;
import TPZTBCS.dao.abrigoSecundarioJsonDao;

public class Accesorio extends PrendaBuilder
{
	

	
    public Accesorio(){prenda = new Prenda();}
    
    public void buildParte()   { prenda.setParte("Accesorio"); }
    
    public void buildTipo(String tipo) throws Exception
    {
    	abrigoSecundarioJsonDao dao = new abrigoSecundarioJsonDao();
    	
    	if (dao.getByAbrigoSecundario(tipo) != null) {
    		prenda.setStrategy(new abrigo());
    		prenda.setTipo(tipo);
    		String parteEspecifica=JsonReader.getParteEspecifica(tipo);
    		prenda.setParteEspecifica(parteEspecifica);
    	}
    	else
    	{
    		prenda.setStrategy(new noAbriga());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
        	prenda.setTipo(tipo);
        	prenda.setAbrigoTemp(tempQueAbriga);
    	}


     
    }
    
    @SuppressWarnings("static-access")
	public void buildMaterial(String material) throws Exception
    {
//    	if ((jsonReader.getMaterialAccesorio()).contains(material))
//    	{
        	prenda.setMaterial(material);
//    	}
    	
//    	else if ((jsonReader.getTipoAbrigoSecundarioMaterial()).contains(material)){
//    		prenda.setMaterial(material);
//    	}
    	
//    	else throw new Exception("ERROR MATERIAL"); 
    	 
    }
    
    public void buildUrl(String url_img) 
    {
    	prenda.setDireccionImagen(url_img);
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
//		      String s = Base64.getEncoder().encodeToString(data);
//		      prenda.setImagen(s);
		}
		
		
	}
}