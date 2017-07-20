package br.com.jornada.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.jornada.models.Usuario;

@Repository
public class UsuarioSecurityDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	public UserDetails loadUserByUsername(String email) {
		System.out.println("->>" + email);
		List<Usuario> usuarios = this.manager
		.createQuery("select u from Usuario u where u .email = :email", Usuario.class)
		.setParameter("email", email).getResultList();
		for (Usuario usuario : usuarios) {
			System.out.println("..." + usuario);
		}
		if (usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuário " + email + " não foi encontrado!");
		}

		return usuarios.get(0);
	}
}
