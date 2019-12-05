	package TPZTBCS.dao;

import java.util.List;

import TPZTBCS.Usuario;
import TPZTBCS.Guardarropa;

public class UsuarioDao extends BaseDao {

    public UsuarioDao() {
    }

    public Usuario getUserByUsername(String username) {
        return getByPropertyValue(Usuario.class, "Username", username); //Si no lo encuentra, cambia a columnName
    }
    
    public Usuario getUserByEmail(String email) {
        return getByPropertyValue(Usuario.class, "Email", email); //Si no lo encuentra, cambia a columnName
    }
    
    public Usuario getUsuario(int id) {
        return getById(Usuario.class,id);
    }
   
    public List<Usuario> list() { 
    	return list(Usuario.class); 
    }

    public List<Guardarropa> listGuardarropas(int userId){
    	Usuario usuario = getById(Usuario.class,userId);
    	return (List<Guardarropa>) usuario.getListaGuardarropas();
    }
}
