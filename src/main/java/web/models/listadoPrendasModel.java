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
	
	public listadoPrendasModel() {
		table = new ArrayList<>();
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
