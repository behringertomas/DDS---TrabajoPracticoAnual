public abstract class PrendaBuilder
{
    protected Prenda prenda;
    protected JsonReader jsonReader;
    
    public abstract void buildParte();
    public abstract void buildTipo(String tipo) throws Exception;
    public abstract void buildMaterial(String material) throws Exception;
//    public abstract void buildColorPrimario(String colorPrimario);
//    public abstract void buildColorSecundario(String colorSecundario);

//    public void buildTipo(String tipo){prenda.setTipo(tipo);}
//    public void buildMaterial(String material) { prenda.setMaterial(material); }
    
    public void buildColorPrimario(String colorPrimario) throws Exception
    {
    	if ((jsonReader.getColores()).contains(colorPrimario))
    	{
    		prenda.setColorPrimario(colorPrimario);
    	}
    	else
    	{
    		throw new IllegalArgumentException("ERROR COLOR PRIMARIO"); 
    	}    
    }
    
    public void buildColorSecundario(String colorSecundario) throws Exception
    {
    	if ((jsonReader.getColores()).contains(colorSecundario))
    	{
    		prenda.setColorPrimario(colorSecundario);
    	}
    	else
    	{
    		throw new IllegalArgumentException("ERROR COLOR SECUNDARIO"); 
    	}     	
    }
    
    public void crearPrenda()
    {
    	prenda = new Prenda();
    }
    
    public Prenda getPrenda()
    {
    	//prenda.mostrarPrenda();
    	return prenda;
    }
}