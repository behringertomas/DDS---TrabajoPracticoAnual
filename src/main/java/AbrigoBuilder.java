public class AbrigoBuilder extends PrendaBuilder
{
	
    public  AbrigoBuilder(){prenda = new Prenda();}
    
    public void buildParte(){prenda.setParte("Parte Superior");}
    
    public void buildTipo(String tipo) throws Exception
    {
    	if ((jsonReader.getTipoAbrigos()).contains(tipo))
    	{
        	prenda.setTipo(tipo);
    	}

    	else
    	{
    		throw new Exception("ERROR TIPO"); 
    	}  
    }
    
    public void buildMaterial(String material) throws Exception
    {
    	if ((jsonReader.getMaterialParteSuperior()).contains(material))
    	{
        	prenda.setMaterial(material);
    	}
    	else
    	{
    		throw new Exception("ERROR MATERIAL"); 
    	} 
    }
}