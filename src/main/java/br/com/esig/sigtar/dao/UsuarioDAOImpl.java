package br.com.esig.sigtar.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.esig.sigtar.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;
	
	public UsuarioDAOImpl(EntityManager em) {
		this.manager = em;
	}
	
	@Override
	@Transactional
	public void adicionar(Usuario usuario) throws IllegalArgumentException {
		if (
				usuario.getNome() != null 
				&& !usuario.getNome().isBlank()
				&& usuario.getSenha() != null
				&& !usuario.getSenha().isBlank()
		) {
			try {
				manager.getTransaction().begin();
				manager.persist(usuario);
				manager.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Erro ao persistir usuário");
			}
		} else {
			throw new IllegalArgumentException(
					"Os campos senha e nome precisam ser preenchidos");
		}
	}

	@Override
	public List<Usuario> filtrar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getUsuario(Long id) {
		return manager.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> getUsuarios() {
		String query = "SELECT u FROM Usuario u";
		return manager.createQuery(query, Usuario.class).getResultList();
	}

}
