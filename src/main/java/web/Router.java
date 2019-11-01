package web;

public class Router {

	
	private static final String LOGIN = "/";
	private static final String HOME = "/listadoGuardarropas";
//	Le puse home a esta porque es la primera que se muestra luego del login.
    private static final String LOGOUT = "/";

	public static String loginPath(){
        return LOGIN;
	}
	 
    public static String homePath(){
        return HOME;
    }

    public static String logoutPath(){
        return LOGOUT;
    }
}
