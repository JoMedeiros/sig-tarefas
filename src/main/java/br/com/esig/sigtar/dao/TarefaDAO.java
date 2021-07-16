package br.com.esig.sigtar.dao;

import java.util.List;

import br.com.esig.sigtar.model.Tarefa;

public interface TarefaDAO {
	
	public void adicionar(Tarefa tarefa);
	
	public List<Tarefa> filtrar(Tarefa tarefa);
	
	public void remover(Long id);
	
	public void atualizar(Tarefa tarefa);
	
	public Tarefa getTarefa(Long id);
	
	public List<Tarefa> getTarefas();
}
