package web.models;

import java.util.List;
import java.util.ArrayList;

import TPZTBCS.Evento;

public class calendarioModel {

	private List<Evento> evento;
	
	public calendarioModel() {
		evento = new ArrayList<>();
	}

	public List<Evento> getLstEvento() {
		return evento;
	}

	public void setLstEvento(List<Evento> lstEvento) {
		this.evento = lstEvento;
	}
	
	public void limpiarEventos() {
		this.evento.clear();
	}
}
