package br.com.jornada.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jornada.models.Palestra;
import br.com.jornada.models.Usuario;
import br.com.jornada.models.Voto;

@Repository
@Transactional
public class VotoDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Voto> listar() {
		return this.manager.createQuery("select v from Voto v", Voto.class).getResultList();
	}

	public void gravar(Voto voto) {
		this.manager.persist(voto);
	}

	public void alterar(Voto voto){
		this.manager.merge(voto);
	}
	public List<Voto> buscarVoto(Integer idPalestra, Integer idUsuario) {
		Palestra palestra = new Palestra();
		palestra.setId(idPalestra);

		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		
		return manager.createQuery("select v from Voto v where palestra = :palestra and usuario = :usuario", Voto.class)
				.setParameter("palestra", palestra).setParameter("usuario", usuario).getResultList();
	}

	public List<Voto> contarVotos(Palestra palestra) {
		return manager.createQuery("select v from Voto v where palestra = :palestra", Voto.class)
				.setParameter("palestra", palestra).getResultList();
		
	}
}
