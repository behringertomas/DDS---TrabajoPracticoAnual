package TPZTBCS;
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
}