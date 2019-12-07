package web.models.views;

public class sugerenciasAceptadasTable {

	private int index;
	private int puntaje;
	
    public sugerenciasAceptadasTable(int index, int puntaje) {
        this.index = index;
        this.puntaje = puntaje;
    }
    
    public sugerenciasAceptadasTable() {
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
    
    
}
