package TPZTBCS;

import TPZTBCS.dao.abrigoJsonDao;
import TPZTBCS.dao.abrigoSecundarioJsonDao;

public class ParteSuperior extends PrendaBuilder
{
	
    public ParteSuperior(){prenda = new Prenda();}
    
    public void buildParte(){prenda.setParte("Parte Superior");}
    
    public void buildTipo(String tipo) throws Exception
    {
    	abrigoJsonDao abrigoDao = new abrigoJsonDao();
    	abrigoSecundarioJsonDao abrigoSecundarioDao = new abrigoSecundarioJsonDao();
    	
    	if(abrigoDao.getByAbrigo(tipo) != null) {
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new abrigo());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
    	} else if (abrigoSecundarioDao.getByAbrigoSecundario(tipo) != null) {
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new abrigo());
    		String parteEspecifica=JsonReader.getParteEspecifica(tipo);
    		prenda.setParteEspecifica(parteEspecifica);
    		
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
    	} else {
    		
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new noAbriga());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
    		
    	}
    	


    	
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

	@Override
	public void buildUrl(String img_url) throws Exception {
		prenda.setDireccionImagen(img_url);
		
	}
}
