package web.models;

public class altaTipoSuperiorModel {
	 private boolean showAlert;
	 
	 
	 public altaTipoSuperiorModel() {
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
