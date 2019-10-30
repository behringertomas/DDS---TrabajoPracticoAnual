package web.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import web.models.AlertModel;
import web.Router;
import web.helper.SessionHelper;

import java.util.HashMap;
import java.util.Map;

import TPZTBCS.Usuario;
import TPZTBCS.dao.UsuarioDao;

import static web.helper.SessionHelper.setSession;

public class LoginController extends MainController{

    private static final String LOGIN = "/login.hbs";
    private static AlertModel alert = new AlertModel(false,"",false);

    public static void init() {
    	
//    	como funcionaria el GET y POST de aca?
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        Spark.get(Router.loginPath(),LoginController::showLogin,engine); //Carga la pagina, Engine son las config del spark
        Spark.post(Router.loginPath(),LoginController::checkLogin,engine); //ante una accion, submit formulario o ante un evento

    }
    
    
//    ¿¿¿ QUÉ SERIA UN MODEL AND VIEW  ?????
    public static ModelAndView checkLogin(Request request, Response response){

        String usuarioIngresado = request.queryParams("email");
        //request.queryParams("email");

        UsuarioDao dao = new UsuarioDao();
        
        if (usuarioIngresado.contains("@")) {
        	
        	Usuario u =  dao.getUserByEmail(usuarioIngresado);
        	
            if (u != null && u.getPassword().equals(request.queryParams("password"))){ //Si no funciona, cambia al ColumnName en vez del nombre de la variable.
                alert.setHideAlert();
                setSession(request,u);
                response.redirect(Router.homePath());
            }
        	
        	
        }
        else { 
        	Usuario u =  dao.getUserByUsername(usuarioIngresado);
        	  	
            if (u != null && u.getPassword().equals(request.queryParams("pass"))){ //Si no funciona, cambia al ColumnName en vez del nombre de la variable.
                alert.setHideAlert();
                setSession(request,u);
                response.redirect(Router.homePath());
            }
        }
        	
        alert.setShowAlertWithMessage("El usuario o password es incorrecto");
        return new ModelAndView(alert,LOGIN);
    }
    
    private static ModelAndView showLogin(Request request, Response response) {
        if (SessionHelper.existSession(request)){
            response.redirect(Router.homePath());
        }
        alert.setHideAlert();
        return new ModelAndView(alert, LOGIN);
    }
	
}
