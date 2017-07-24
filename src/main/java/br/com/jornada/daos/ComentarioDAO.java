package br.com.jornada.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jornada.models.Comentario;

@Repository
@Transactional
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Comentario comentario) {
		this.manager.persist(comentario);
	}
}
