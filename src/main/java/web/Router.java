package web;

public class Router {

	
	private static final String LOGIN = "/";
	private static final String HOME = "/Menu.hbs";
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
