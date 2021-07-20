package br.com.esig.sigtar.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.sigtar.dao.TarefaDAO;
import br.com.esig.sigtar.dao.UsuarioDAO;
import br.com.esig.sigtar.model.Tarefa;

@Named("tarefaCtl")
@ApplicationScoped
public class TarefaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ID da Tarefa na tabela a ser excluída ou alterada
	private Long id;
	
	private Long responsavel_id;
	
	@Inject
	private Tarefa tarefa;
	
	@Inject
	private TarefaDAO tarefaDAO;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public String adicionarTarefa() {
		tarefa.setResponsavel(usuarioDAO.getUsuario(responsavel_id));
		tarefaDAO.adicionar(tarefa);
        return "Home.xhtml?faces-redirect=true";
	}

	public String goToEditar(Tarefa tarefa) {
		this.tarefa = tarefa;
		return "EditarTarefa.xhtml?faces-redirect=true";
	}
	
	public String atualizarTarefa() {
		tarefaDAO.atualizar(this.tarefa);
        return "Home.xhtml?faces-redirect=true";
	}

	
	public String excluirTarefa(long id) {
		tarefaDAO.remover(id);
		return "";
	}
	
	public String concluirTarefa(long id) {
		Tarefa tarefa = tarefaDAO.getTarefa(id);
		tarefa.setConcluida(true);
		tarefaDAO.atualizar(tarefa);
		return "";
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefas() {
		if (this.tarefa == null || this.tarefa.getTitulo() == null)
			return tarefaDAO.getTarefas();
		else
			return tarefaDAO.filtrar(tarefa);
	}
	
//	public String filtrarTarefas() {
//		// Esse método serve somente para recarregar a página que irá
//		// executar getTarefas com o objeto tarefa de filtro
//		return "";
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResponsavel_id() {
		return responsavel_id;
	}

	public void setResponsavel_id(Long responsavel_id) {
		this.responsavel_id = responsavel_id;
	}

}
