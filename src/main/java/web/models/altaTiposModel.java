package web.models;

//Este es el model de Tipo Superior, Inferior, Calzado, Accesorio y Abrigo
//Como son todos lo mismo...
public class altaTiposModel {
	 private boolean showAlert;

	 public altaTiposModel() {
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
