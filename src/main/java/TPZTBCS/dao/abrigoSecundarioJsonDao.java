package TPZTBCS.dao;

import JsonPersistido.abrigoSecundarioJson;;

public class abrigoSecundarioJsonDao extends BaseDao {

	public abrigoSecundarioJsonDao() {
		
	}
	
    public abrigoSecundarioJson getByAbrigoSecundario(String abrigo_secundario) {
        return getByPropertyValue(abrigoSecundarioJson.class, "abrigo_secundario", abrigo_secundario);
    }
}
