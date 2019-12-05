package TPZTBCS.dao;

import TPZTBCS.Atuendo;
import TPZTBCS.Usuario;

public class atuendoDao extends BaseDao{

	public atuendoDao() {
	}
	
    public Atuendo getAtuendo(int id) {
        return getById(Atuendo.class,id);
    }
}
