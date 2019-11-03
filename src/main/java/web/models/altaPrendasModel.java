package web.models;

public class altaPrendasModel {

    private boolean showAlert;
    private String pathTipoPrenda;

    public altaPrendasModel() {
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

	public String getPathTipoPrenda() {
		return pathTipoPrenda;
	}

	public void setPathTipoPrenda(String pathTipoPrenda) {
		this.pathTipoPrenda = pathTipoPrenda;
	}
    


}
