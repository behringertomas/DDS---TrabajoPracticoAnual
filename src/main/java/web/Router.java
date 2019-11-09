package web;

public class Router {

	
	private static final String LOGIN = "/";
	private static final String HOME = "/listadoGuardarropas";
	private static final String ListadoPrendas = "/listadoPrendas";
	private static final String altaPrenda = "/altaPrenda";
//	Le puse home a esta porque es la primera que se muestra luego del login.
    private static final String LOGOUT = "/";
    private static final String SUGERENCIAS = "/sugerencias";
    private static final String ALTA_EVENTO = "/altaEvento";
    
    private static final String ALTA_SUPERIOR = "/altaTipoSuperior";
	private static final String ALTA_INFERIOR = "/altaTipoInferior";
	private static final String ALTA_ACCESORIO = "/altaAccesorio";
	private static final String ALTA_ABRIGO = "/altaAbrigo";
	private static final String ALTA_CALZADO = "/altaCalzado";

	public static String loginPath(){
        return LOGIN;
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
    
    

}
