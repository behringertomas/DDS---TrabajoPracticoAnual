package TPZTBCS.dao;

import JsonPersistido.abrigoJson;

public class abrigoJsonDao extends BaseDao {

	public abrigoJsonDao() {
		
	}
	
    public abrigoJson getByAbrigo(String abrigo) {
        return getByPropertyValue(abrigoJson.class, "abrigo", abrigo);
    }
}
