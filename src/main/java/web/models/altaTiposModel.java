package web.models;

import java.util.ArrayList;
import java.util.List;

import TPZTBCS.Guardarropa;
import web.models.views.altaPrendaTable;
import web.models.views.listadoPrendasTable;

//Este es el model de Tipo Superior, Inferior, Calzado, Accesorio y Abrigo
//Como son todos lo mismo...

public class altaTiposModel {
	 
	 private boolean showAlert;
	 private List<Guardarropa> guardarropa;

	 public altaTiposModel() {
		 guardarropa = new ArrayList<>();
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


    public void setHideAlert(){
        setShowAlert(false);
     }
}
