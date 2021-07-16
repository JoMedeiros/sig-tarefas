package br.com.esig.sigtar.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.esig.sigtar.dao.TarefaDAO;
import br.com.esig.sigtar.model.Tarefa;

@Named("tarefaBean")
@ApplicationScoped
public class TarefaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ID da Tarefa na tabela a ser excluída ou alterada
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Inject
	private Tarefa tarefa;
	
	@Inject
	private TarefaDAO tarefaDAO;
	
	public String adicionarTarefa() {
		tarefaDAO.adicionar(tarefa);
		return "";
	}
	
	public String excluirTarefa() {
		tarefaDAO.remover(this.id);
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
	
	public String filtrarTarefas() {
		// Esse método serve somente para recarregar a página que irá
		// executar getTarefas com o objeto tarefa de filtro
		return "";
	}

}
