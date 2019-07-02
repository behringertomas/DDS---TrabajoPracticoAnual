package TPZTBCS;
public class ParteInferior extends PrendaBuilder
{    
    public ParteInferior(){prenda = new Prenda();}
    
    public void buildParte()   { prenda.setParte("Parte Inferior"); }
    
    public void buildTipo(String tipo) throws Exception
    {
    	if ((jsonReader.getTipoParteInferior()).contains(tipo))
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
    	if ((jsonReader.getMaterialParteInferior()).contains(material))
    	{
        	prenda.setMaterial(material);
    	}
    	else
    	{
    		throw new Exception("ERROR MATERIAL"); 
    	} 
    }
}
