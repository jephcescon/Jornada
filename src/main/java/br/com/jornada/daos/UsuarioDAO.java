package br.com.jornada.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jornada.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> listar() {
		return manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}

	public void apagar(Integer id) {
		Usuario usuario = this.manager.find(Usuario.class, id);
		this.manager.remove(usuario);
	}

	public void alterar(Usuario usuario) {
		this.manager.merge(usuario);
	}

	public Usuario buscar(Integer id) {
		Usuario usuario = this.manager.find(Usuario.class, id);
		return usuario;
	}
}
