package br.com.esig.sigtar.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.sigtar.dao.UsuarioDAO;
import br.com.esig.sigtar.model.Usuario;

@Named("usuarioCtl")
@ApplicationScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuario usuarioForm;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	private Usuario usuarioAutenticado = null;
	
	public String cadastrarUsuario() {
		try {
			this.usuarioDAO.adicionar(usuarioForm);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//this.usuarioForm.setNome(null);
		//this.usuarioForm.setSenha(null);
        return "Home.xhtml?faces-redirect=true";
	}
	
	public String login() {
		// Somente se o usuário existir e a senha for 
		// a mesma do banco (cm BCrypt)
		this.usuarioAutenticado = usuarioForm;
		return "TODO: Comparar usuarioForm com usuarioAutenticado";
	}

	public Usuario getUsuarioForm() {
		return usuarioForm;
	}

	public void setUsuarioForm(Usuario usuarioForm) {
		this.usuarioForm = usuarioForm;
	}
	
	public Usuario getUsuarioAutenticado() {
		return this.usuarioAutenticado;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioDAO.getUsuarios();
	}

}
