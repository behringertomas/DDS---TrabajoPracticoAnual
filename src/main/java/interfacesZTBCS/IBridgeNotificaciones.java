package interfacesZTBCS;

import TPZTBCS.DatosPersonales;
import TPZTBCS.Usuario;

public interface IBridgeNotificaciones {
	
	public void enviarNotificacion(Usuario usuario);
	public void enviarNotificacion(String email);
	public void enviarNotificacionCambioBrusco(Usuario usuario);
	public void enviarNotificacionCambioBrusco(String email);

	void enviarNotificacionRecordatorio(String email);


}
