package br.com.esig.sigtar.dao;

import java.util.List;

import br.com.esig.sigtar.model.Usuario;

public interface UsuarioDAO {

	public void adicionar(Usuario usuario);
		
	public List<Usuario> filtrar(Usuario usuario);
	
	public void remover(Long id);
	
	public void atualizar(Usuario usuario);
	
	public Usuario getUsuario(Long id);
	
	public List<Usuario> getUsuarios();
}
