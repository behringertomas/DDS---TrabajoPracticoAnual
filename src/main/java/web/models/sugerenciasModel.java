package web.models;

import java.util.ArrayList;
import java.util.List;

import TPZTBCS.Evento;
import web.models.views.sugerenciaTable;

public class sugerenciasModel {
		
		private List<sugerenciaTable> table;
		private List<Evento> evento;
		private boolean showAlert;
		
		public sugerenciasModel() {
			table = new ArrayList<>();
			evento = new ArrayList<>();
		}
		
		public List<Evento> getEvento() {
			return evento;
		}
		
		public void limpiarEventos() {
			evento.clear();
		}
		
		public void setEvento(List<Evento> evento) {
			this.evento = evento;
		}
		
		public boolean isShowAlert() {
			return showAlert;
		}
		
		public void setShowAlert(boolean showAlert) {
			this.showAlert = showAlert;
		}

		public void setTable(List<sugerenciaTable> table) {
			this.table = table;
		}

	    public sugerenciasModel(List<sugerenciaTable> tableN) {
	        this.table = tableN;
	    }
	    
	    public void setsugerenciaTable(List<sugerenciaTable> tableListadoPrendas) {
	        this.table = tableListadoPrendas;
	    }

	    public List<sugerenciaTable> getTable() {
	        return table;
	    }
		
}
