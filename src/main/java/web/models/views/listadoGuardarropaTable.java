package web.models.views;

public class listadoGuardarropaTable {

	private String guardarropa;
	private int index;
	
    public listadoGuardarropaTable(String guardarropa, int index) {
        this.guardarropa = guardarropa;
        this.index = index;
    }
    
    public listadoGuardarropaTable() {
    }
    
    public String gerGuardarropa() {
        return guardarropa;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setGuardarropa(String guardarropa) {
        this.guardarropa = guardarropa;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
