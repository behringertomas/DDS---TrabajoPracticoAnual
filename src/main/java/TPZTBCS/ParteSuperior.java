package TPZTBCS;
<<<<<<< HEAD
=======

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

import TPZTBCS.dao.abrigoJsonDao;
import TPZTBCS.dao.abrigoSecundarioJsonDao;

>>>>>>> Entrega5
public class ParteSuperior extends PrendaBuilder
{
	
    public ParteSuperior(){prenda = new Prenda();}
    
    public void buildParte(){prenda.setParte("Parte Superior");}
    
    public void buildTipo(String tipo) throws Exception
    {
<<<<<<< HEAD
    	if (JsonReader.getTipoParteSuperior().contains(tipo))
    	{
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new noAbriga());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
        	prenda.setAbrigoTemp(tempQueAbriga);
    	}
    	else if (JsonReader.getTipoAbrigos().contains(tipo)) 
    	{
=======
    	abrigoJsonDao abrigoDao = new abrigoJsonDao();
    	abrigoSecundarioJsonDao abrigoSecundarioDao = new abrigoSecundarioJsonDao();
    	
    	if(abrigoDao.getByAbrigo(tipo) != null) {
>>>>>>> Entrega5
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new abrigo());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
<<<<<<< HEAD
    		 
    	}else if (jsonReader.getTipoAbrigoSecundario().contains(tipo)) 
    	{
=======
    	} else if (abrigoSecundarioDao.getByAbrigoSecundario(tipo) != null) {
>>>>>>> Entrega5
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new abrigo());
    		String parteEspecifica=JsonReader.getParteEspecifica(tipo);
    		prenda.setParteEspecifica(parteEspecifica);
    		
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
<<<<<<< HEAD
    	}
    	
    	else throw new Exception("ERROR TIPO");  
=======
    	} else {
    		
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new noAbriga());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
    		
    	}
    	


>>>>>>> Entrega5
    	
    }
    
    public void buildMaterial(String material) throws Exception
    {
//    	if (JsonReader.getMaterialParteSuperior().contains(material))
//    	{
        	prenda.setMaterial(material);
//    	}
//    	else
//    	{
//    		throw new Exception("ERROR MATERIAL"); 
//    	} 
    }
<<<<<<< HEAD
=======

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
