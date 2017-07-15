package br.com.jornada.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jornada.models.Palestra;

@Repository
@Transactional
public class PalestraDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Palestra> listar() {
		return manager.createQuery("select p from Palestra p", Palestra.class).getResultList();
	}

	public void gravar(Palestra palestra) {
		this.manager.persist(palestra);
	}

	public Palestra buscar(Integer id) {
		Palestra palestra = this.manager.find(Palestra.class, id);
		return palestra;
	}

	public void alterar(Palestra palestra) {
		this.manager.merge(palestra);
	}

	public void apagar(Integer id) {
		Palestra palestra = this.manager.find(Palestra.class, id);
		this.manager.remove(palestra);
	}
}
