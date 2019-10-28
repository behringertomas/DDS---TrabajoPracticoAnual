package TPZTBCS.dao;

import java.util.List;

import TPZTBCS.DatosPersonales;
import TPZTBCS.Usuario;

public class UsuarioDao extends BaseDao {

    public UsuarioDao() {
    }

    public Usuario getUserByUsername(String username) {
        return getByPropertyValue(Usuario.class, "Username", username); //Si no lo encuentra, cambia a columnName
    }
    
    public Usuario getUserByEmail(String email) {
        return getByPropertyValue(Usuario.class, "Email", email); //Si no lo encuentra, cambia a columnName
    }
    
   
    public List<Usuario> list() { return list(Usuario.class); }

}
