package web;

public class Router {

	
	private static final String LOGIN = "/";
	private static final String HOME = "/listadoGuardarropas";
	private static final String ListadoPrendas = "/listadoPrendas";
	private static final String altaPrenda = "/altaPrenda";
//	Le puse home a esta porque es la primera que se muestra luego del login.
<<<<<<< HEAD
    private static final String LOGOUT = "/";
=======
    private static final String LOGOUT = "/logout";
>>>>>>> Entrega5
    private static final String SUGERENCIAS = "/sugerencias";
    private static final String ALTA_EVENTO = "/altaEvento";
    private static final String ACEPTAR_SUGERENCIA = "/aceptarSugerencia";
    private static final String MODIFICAR_PUNTAJES = "/modificarPuntajes";
<<<<<<< HEAD
=======
    private static final String SUGERENCIAS_ACEPTADAS = "/sugerenciasAceptadas";
    
>>>>>>> Entrega5
    
    private static final String ALTA_SUPERIOR = "/altaTipoSuperior";
	private static final String ALTA_INFERIOR = "/altaTipoInferior";
	private static final String ALTA_ACCESORIO = "/altaAccesorio";
	private static final String ALTA_ABRIGO = "/altaAbrigo";
	private static final String ALTA_CALZADO = "/altaCalzado";
<<<<<<< HEAD
=======
	private static final String ALTA_ACCESORIOABRIGO = "/altaAccesorioAbrigo";
>>>>>>> Entrega5
	private static final String CALENDARIO = "/calendario";
	
	
	private static final String HISTORIAL_CALIFICACIONES = "/listadoPrendasYCalificacion";
	
<<<<<<< HEAD
	public static String getHistorialCalificacionesPath() {
		return HISTORIAL_CALIFICACIONES;
	}
	
=======
	
	
	public static String getSugerenciasAceptadas() {
		return SUGERENCIAS_ACEPTADAS;
	}

	public static String getHistorialCalificacionesPath() {
		return HISTORIAL_CALIFICACIONES;
	}
		
	public static String getAltaAccesorioabrigo() {
		return ALTA_ACCESORIOABRIGO;
	}

>>>>>>> Entrega5
	public static String loginPath(){
        return LOGIN;
	}
	
    public static String getAceptarSugerencia() {
		return ACEPTAR_SUGERENCIA;
	}

	public static String getModificarPuntajes() {
		return MODIFICAR_PUNTAJES;
	}

	public static String getAltaEventoPath() {
		return ALTA_EVENTO;
	}


	public static String getSugerencias() {
		return SUGERENCIAS;
	}


	public static String homePath(){
        return HOME;
    }

    public static String logoutPath(){
        return LOGOUT;
    }

    public static String prendasPath(){
        return ListadoPrendas;
    }
    
    public static String altaPrendaPath() {
    	return altaPrenda;
    }

	public static String getAltaSuperior() {
		return ALTA_SUPERIOR;
	}

	public static String getAltaInferior() {
		return ALTA_INFERIOR;
	}

	public static String getAltaAccesorio() {
		return ALTA_ACCESORIO;
	}

	public static String getAltaAbrigo() {
		return ALTA_ABRIGO;
	}

	public static String getAltaCalzado() {
		return ALTA_CALZADO;
	}

	public static String getCalendarioPath() {
		return CALENDARIO;
	}
    
    

}
