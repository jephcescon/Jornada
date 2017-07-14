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
}
