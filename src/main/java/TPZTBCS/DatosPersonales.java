package TPZTBCS;

public class DatosPersonales {

	String ID="";
	String email="";
	
	int FrioMaximo=15;//dejo 15 como default == si hace menos de 15 grados se abriga con algunas prendas
	int FrioMinimo=0; // si hace menos de 0 grados se abriga con todo lo que pueda
	int FrioManos=15; 
	int FrioCuello=15;
	int FrioCabeza=15;

	
	public void setID(String IDNueva) {
		this.ID=IDNueva;
	}
	public void setEmail(String EmailNueva) {
		this.email=EmailNueva;
	}
	public void setFrioMaximo(int FrioMaximoNuevo) {
		this.FrioMaximo=FrioMaximoNuevo;
	}
	public void setFrioMinimo(int FrioMinimoNueva) {
		this.FrioMinimo=FrioMinimoNueva;
	}
	public void setFrioManos(int FrioManosNuevo) {
		this.FrioManos=FrioManosNuevo;
	}
	public void setFrioCuello(int FrioCuelloNueva) {
		this.FrioCuello=FrioCuelloNueva;
	}
	public void setFrioCabeza(int FrioCabezaNueva) {
		this.FrioCabeza=FrioCabezaNueva;
	}

	public String getID() {
		return this.ID;
	}
	public String getEmail() {
		return this.email;
	}
	public int getFrioMaximo() {
		return this.FrioMaximo;
	}
	public int getFrioMinimo() {
		return this.FrioMinimo;
	}
	public int getFrioManos() {
		return this.FrioManos;
	}
	public int getFrioCuello() {
		return this.FrioCuello;
	}
	public int getFrioCabeza() {
		return this.FrioCabeza;
	}
	
}
