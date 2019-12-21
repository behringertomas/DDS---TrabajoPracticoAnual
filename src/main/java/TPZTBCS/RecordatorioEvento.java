package TPZTBCS;

import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.Transient;

import com.proveedores.openweather.OpenWeather;

public class RecordatorioEvento extends TimerTask {

	private Evento evento;
	
	Timer recordatorioEventoTimer;

	public RecordatorioEvento(Evento evento) {
		this.evento=evento;
		recordatorioEventoTimer = new Timer();
		recordatorioEventoTimer.schedule(this,86400000);
	}
	
	
	@Override
	public void run() {
		
		OpenWeather proveedor = new OpenWeather();
	
		int dias_restantes = proveedor.dias_restantes(evento.getFecha());
		
		if(dias_restantes <= 4) {
			NotificacionEmail sender = new NotificacionEmail();
	    	sender.enviarNotificacionRecordatorio(evento.getUsuario().getEmail());    	
	    	recordatorioEventoTimer.cancel();
	    	
		}		
	}
}