package TPZTBCS.dao;

import JsonPersistido.factoresClimaticosJson;;

public class factoresClimaticosJsonDao extends BaseDao {

	public factoresClimaticosJsonDao(){
		
	}
	
    public factoresClimaticosJson getByAccesorio(String prenda_factor_climatico) {
        return getByPropertyValue(factoresClimaticosJson.class, "prenda_factor_climatico", prenda_factor_climatico);
    }
}
