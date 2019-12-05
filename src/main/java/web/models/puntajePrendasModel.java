package web.models;
import java.util.ArrayList;
import java.util.List;

import TPZTBCS.Atuendo;
import TPZTBCS.Prenda;
import web.models.views.listadoPrendasTable;
import web.models.views.modificacionPuntajes;
import web.models.views.sugerenciaTable;

public class puntajePrendasModel {

	private List<modificacionPuntajes> table;
    private List<Atuendo> atuendo;
    private boolean showAlert;

    public puntajePrendasModel() {
    	table = new ArrayList<>();
    	atuendo = new ArrayList<>();
    }
    
    public List<Atuendo> getListaAtuendos() {
    	return atuendo;
    }
    
    public List<Atuendo> getAtuendo() {
		return atuendo;
	}

	public void setAtuendo(List<Atuendo> atuendo) {
		this.atuendo = atuendo;
	}

	public void limpiar_atuendos() {
    	atuendo.clear();
    }
    
	public void setListaAtuendos(List<Atuendo> listaAtuendos) {
		atuendo = listaAtuendos;
	}

	public List<modificacionPuntajes> getTable() {
		return table;
	}

	public void setTable(List<modificacionPuntajes> table) {
		this.table = table;
	}
	
    public puntajePrendasModel(List<modificacionPuntajes> tableN) {
        this.table = tableN;
    }

    public void setHideAlert(){
        setShowAlert(false);
    }

    public boolean isShowAlert() {
        return showAlert;
    }

    public void setShowAlert(boolean showAlert) {
        this.showAlert = showAlert;
    }



}
