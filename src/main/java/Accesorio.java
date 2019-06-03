public class Accesorio extends PrendaBuilder
{
    public Accesorio(){prenda = new Prenda();}
    
    public void buildParte()   { prenda.setParte("Accesorio"); }
    public void buildTipo(String tipo) throws Exception
    {
    	if ((jsonReader.getTipoAccesorio()).contains(tipo))
    	{
        	prenda.setTipo(tipo);
    	}
    	else
    	{
    		throw new IllegalArgumentException("ERROR TIPO"); 
    	}  
    }
    public void buildMaterial(String material) throws Exception
    {
    	if ((jsonReader.getMaterialAccesorio()).contains(material))
    	{
        	prenda.setMaterial(material);
    	}
    	else
    	{
    		throw new IllegalArgumentException("ERROR MATERIAL"); 
    	} 
    }
//    public void buildColorPrimario(String colorPrimario) { prenda.setColorPrimario(colorPrimario); }
//    public void buildColorSecundario(String colorSecundario) { prenda.setColorSecundario(colorSecundario); }
}