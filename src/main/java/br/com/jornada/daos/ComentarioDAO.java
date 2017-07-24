package br.com.jornada.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jornada.models.Comentario;
import br.com.jornada.models.Palestra;

@Repository
@Transactional
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Comentario comentario) {
		this.manager.persist(comentario);
	}

	public List<Comentario> buscar(Palestra palestra) {
		return manager.createQuery("select c from Comentario c where palestra = :palestra", Comentario.class)
				.setParameter("palestra", palestra).getResultList();
	}
}
