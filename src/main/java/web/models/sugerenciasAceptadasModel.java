package web.models;

import java.util.ArrayList;
import java.util.List;

import web.models.views.listadoGuardarropaTable;
import web.models.views.sugerenciasAceptadasTable;


public class sugerenciasAceptadasModel {

	private List<sugerenciasAceptadasTable> table;
	
	public sugerenciasAceptadasModel() {
        table = new ArrayList<>();
    }
    
    public sugerenciasAceptadasModel(List<sugerenciasAceptadasTable> tableN) {
        this.table = tableN;
    }
    
    public void setSugerenciasAceptadasTable(List<sugerenciasAceptadasTable> tableListadoGuardarropas) {
        this.table = tableListadoGuardarropas;
    }
    
    public List<sugerenciasAceptadasTable> getTable() {
        return table;
    }
	
}
