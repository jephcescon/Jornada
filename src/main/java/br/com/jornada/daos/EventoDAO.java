package br.com.jornada.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jornada.models.Evento;

@Repository
@Transactional
public class EventoDAO {

	@PersistenceContext
    private EntityManager manager;
	
	public List<Evento> listar() {
		return manager.createQuery("select e from Evento e", Evento.class).getResultList();
	}

	public void gravar(Evento evento) {
		this.manager.persist(evento);
	}
}
