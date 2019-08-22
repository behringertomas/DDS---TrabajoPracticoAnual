package TPZTBCS;
public class Accesorio extends PrendaBuilder
{
	

	
    public Accesorio(){prenda = new Prenda();}
    
    public void buildParte()   { prenda.setParte("Accesorio"); }
    
    public void buildTipo(String tipo) throws Exception
    {
    	if ((jsonReader.getTipoAccesorio()).contains(tipo))
    	{
    		prenda.setStrategy(new noAbriga());
        	prenda.setTipo(tipo);
    	}
    	else if (jsonReader.getTipoAbrigoSecundario().contains(tipo)) 
    	{
    		prenda.setStrategy(new abrigo());
    		prenda.setTipo(tipo);
    		String parteEspecifica=JsonReader.getParteEspecifica(tipo);
    		prenda.setParteEspecifica(parteEspecifica);
    	}
    	else throw new Exception("ERROR TIPO"); 
     
    }
    
    public void buildMaterial(String material) throws Exception
    {
    	if ((jsonReader.getMaterialAccesorio()).contains(material))
    	{
        	prenda.setMaterial(material);
    	}
    	
    	else if ((jsonReader.getTipoAbrigoSecundarioMaterial()).contains(material)){
    		prenda.setMaterial(material);
    	}
    	
    	else throw new Exception("ERROR MATERIAL"); 
    	 
    }
}