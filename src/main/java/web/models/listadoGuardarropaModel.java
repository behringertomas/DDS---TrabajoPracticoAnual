package web.models;

import java.util.ArrayList;
import java.util.List;

import web.models.views.listadoGuardarropaTable;

public class listadoGuardarropaModel {
	
	 private List<listadoGuardarropaTable> table;
	 private String identificador;
	 private int limitePrendas;
	
	public listadoGuardarropaModel() {
        table = new ArrayList<>();
    }
    
    public listadoGuardarropaModel(List<listadoGuardarropaTable> tableN) {
        this.table = tableN;
    }
    
    public void setlistadoGuardarropaTable(List<listadoGuardarropaTable> tableSimplex) {
        this.table = tableSimplex;
    }
    
    public List<listadoGuardarropaTable> getTable() {
        return table;
    }
    
    
//  ****** GETTERS AND SETTERS NUESTROS ******
    
    public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getLimitePrendas() {
		return limitePrendas;
	}

	public void setLimitePrendas(int limitePrendas) {
		this.limitePrendas = limitePrendas;
	}
    

}
