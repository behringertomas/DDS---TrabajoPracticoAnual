package TPZTBCS.dao;

import TPZTBCS.Evento;

public class EventoDao  extends BaseDao{

	public EventoDao() {
	}
	
    public Evento getEvento(int id) {
        return getById(Evento.class,id);
    }
}
