package web.models;
import java.util.ArrayList;
import java.util.List;

import TPZTBCS.Prenda;
import web.models.views.listadoPrendasTable;
import web.models.views.modificacionPuntajes;

public class puntajePrendasModel {

	private List<modificacionPuntajes> table;
    private List<Prenda> ListaPrendas;
    private Boolean isSuccess;
    private String message;
    private boolean showAlert;

    
    public void limpiar_prendas() {
    	this.ListaPrendas.clear();
    }
    
    public puntajePrendasModel() {
		table = new ArrayList<>();
    	ListaPrendas = new ArrayList<>();
    }

    public boolean isShowAlert() {
        return showAlert;
    }

    public void setShowAlert(boolean showAlert) {
        this.showAlert = showAlert;
    }

    public List<Prenda> getPrendas() {
        return ListaPrendas;
    }

    public void setDispositivos(List<Prenda> Lista) {
        this.ListaPrendas = Lista;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }
    

    public List<modificacionPuntajes> getTable() {
		return table;
	}

	public void setTable(List<modificacionPuntajes> table) {
		this.table = table;
	}

	public List<Prenda> getListaPrendas() {
		return ListaPrendas;
	}

	public void setListaPrendas(List<Prenda> listaPrendas) {
		ListaPrendas = listaPrendas;
	}

	public void setIsSuccess(Boolean type) {
        this.isSuccess = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHideAlert(){
        setShowAlert(false);
    }


    public void success(String message) {
        this.setShowAlert(true);
        this.setIsSuccess(true);
        this.setMessage(message);
    }

    public void failed(String message){
        this.setIsSuccess(false);
        this.setMessage(message);
    }

}
