package TPZTBCS;
public class ParteSuperior extends PrendaBuilder
{
	
    public ParteSuperior(){prenda = new Prenda();}
    
    public void buildParte(){prenda.setParte("Parte Superior");}
    
    public void buildTipo(String tipo) throws Exception
    {
    	if (JsonReader.getTipoParteSuperior().contains(tipo))
    	{
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new noAbriga());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
        	prenda.setAbrigoTemp(tempQueAbriga);
    	}
    	else if (JsonReader.getTipoAbrigos().contains(tipo)) 
    	{
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new abrigo());
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
    		 
    	}else if (JsonReader.getTipoAbrigoSecundario().contains(tipo)) 
    	{
    		prenda.setTipo(tipo);
    		prenda.setStrategy(new abrigo());
    		String parteEspecifica=JsonReader.getParteEspecifica(tipo);
    		prenda.setParteEspecifica(parteEspecifica);
    		
    		int tempQueAbriga = prenda.getStrategy().getTemperatura(prenda);
    		prenda.setAbrigoTemp(tempQueAbriga);
    	}
    	
    	else throw new Exception("ERROR TIPO");  
    	
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
}
