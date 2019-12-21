package TPZTBCS;

import java.util.TimerTask;

import com.krds.accuweatherapi.exceptions.ApiException;
import com.krds.accuweatherapi.exceptions.UnauthorizedException;
import com.proveedores.openweather.OpenWeather;

public class CambioBruscoClimatico extends TimerTask{

    Evento evento;
    public int parametroCambioBrusco = 10;
    
    public CambioBruscoClimatico(Evento evento) {
        this.evento = evento;
    }

    @Override
    public void run() {

    	OpenWeather apiOpenW = new OpenWeather();
    	
        try {

<<<<<<< HEAD
        	double temp = apiOpenW.obtenerTemperaturATalDia(this.evento.convertToLocalDateViaInstant(this.evento.getFechaDelEvento()), this.evento.getCiudad());
=======
        	double temp = apiOpenW.obtenerTemperaturATalDia(this.evento.convertToLocalDateViaInstant(this.evento.getFecha()), this.evento.getCiudad());
>>>>>>> Entrega5
        	String descripcion = evento.requestDescripcionClima();
            if(  Math.abs(this.evento.getTemp() - temp) > parametroCambioBrusco) {
            	NotificacionEmail sender =new NotificacionEmail();
            	sender.enviarNotificacionCambioBrusco(this.evento.usuario.getEmail());
                evento.run();
            }
        } catch (UnauthorizedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
