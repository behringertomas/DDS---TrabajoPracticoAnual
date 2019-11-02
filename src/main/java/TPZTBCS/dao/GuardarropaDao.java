package TPZTBCS.dao;

import java.util.ArrayList;
import java.util.List;

import TPZTBCS.Guardarropa;
import TPZTBCS.Usuario;

public class GuardarropaDao extends BaseDao {
	

	public List<Guardarropa> getAllGuardarropas(Usuario user){
		 return getListByPropertyValue(Guardarropa.class, "ID_GUARDARROPA", user);
	}
	
	public List<Guardarropa> list() {return list(Guardarropa.class);}
	
	public Guardarropa getGuardarropa(int id) {
	     return getById(Guardarropa.class,id);
	}

}
