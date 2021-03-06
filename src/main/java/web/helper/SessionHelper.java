package web.helper;


import TPZTBCS.Usuario;
import spark.Request;

public class SessionHelper {

    private static final String SESSION = "user";

    private static SessionHelper ourInstance = new SessionHelper();

    public static SessionHelper getInstance() {
        return ourInstance;
    }

    private SessionHelper() {
    }

    public static String getUserSession(Request request){
        return request.session().attribute(SESSION);
    }

    public static void setSession(Request request, Usuario user){
        request.session().attribute(SESSION,user.userSession());

    }


    public static Boolean existSession(Request request){
        return request.session().attribute(SESSION) != null;
    }

    public static void deleteSession(Request request){
        request.session().removeAttribute(SESSION);
    }

}