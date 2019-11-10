package web.models;

import java.util.ArrayList;
import java.util.List;

import TPZTBCS.Guardarropa;
import javafx.scene.control.ComboBox;
import web.models.views.listadoGuardarropaTable;
import web.models.views.listadoPrendasTable;

public class listadoPrendasModel {

	private List<listadoPrendasTable> table;
	private boolean showAlert;
	private List<Guardarropa> guardarropa;
	
	public listadoPrendasModel() {
		table = new ArrayList<>();
		guardarropa = new ArrayList<>();
	}
	
	public void limpiarGuardarropas() {
		this.guardarropa.clear();
	}
	
	
	public List<Guardarropa> getGuardarropa() {
		return guardarropa;
	}

	public void setGuardarropa(List<Guardarropa> guardarropa) {
		this.guardarropa = guardarropa;
	}

	public boolean isShowAlert() {
		return showAlert;
	}

	public void setShowAlert(boolean showAlert) {
		this.showAlert = showAlert;
	}

	
    public listadoPrendasModel(List<listadoPrendasTable> tableN) {
        this.table = tableN;
    }
	
    public void setListadoPrendasTable(List<listadoPrendasTable> tableListadoPrendas) {
        this.table = tableListadoPrendas;
    }

    public List<listadoPrendasTable> getTable() {
        return table;
    }
    

    
    
    
    
    
}
