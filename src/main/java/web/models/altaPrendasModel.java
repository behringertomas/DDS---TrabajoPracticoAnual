package web.models;

public class altaPrendasModel {

    private boolean showAlert;

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

    


}
