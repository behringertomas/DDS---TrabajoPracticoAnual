package web.models;

import java.util.ArrayList;
import java.util.List;

import web.models.views.listadoPrendasTable;
import web.models.views.sugerenciaTable;

public class sugerenciasModel {
		
		private List<sugerenciaTable> table;
		private boolean showAlert;
		
		public sugerenciasModel() {
			table = new ArrayList<>();
		}

		public List<sugerenciaTable> getTable() {
			return table;
		}

		public void setTable(List<sugerenciaTable> table) {
			this.table = table;
		}

		public boolean isShowAlert() {
			return showAlert;
		}

		public void setShowAlert(boolean showAlert) {
			this.showAlert = showAlert;
		}
		
}
