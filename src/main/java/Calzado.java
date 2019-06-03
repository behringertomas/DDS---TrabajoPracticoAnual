public class Calzado extends PrendaBuilder
{
    public Calzado(){prenda = new Prenda();}
    
    public void buildParte()   { prenda.setParte("Calzado"); }
    public void buildTipo(String tipo) throws Exception
    {
    	if ((jsonReader.getTipoCalzado()).contains(tipo))
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
    	if ((jsonReader.getMaterialCalzado()).contains(material))
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