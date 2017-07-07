package br.com.jornada.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jornada.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
    private EntityManager manager;

    public void gravar(Usuario usuario){
        manager.persist(usuario);
    }

	public List<Usuario> listar() {
		return manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}
}
