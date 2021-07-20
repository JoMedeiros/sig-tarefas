package br.com.esig.sigtar.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.esig.sigtar.model.Tarefa;

public class TarefaDAOImpl implements TarefaDAO, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public TarefaDAOImpl(EntityManager em) {
		this.manager = em;
	}

	@Override
	public void adicionar(Tarefa tarefa) {
		//Valores padrão
		tarefa.setConcluida(false);
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
	}

	@Override
	public List<Tarefa> filtrar(Tarefa tarefa) {
		if (tarefa.getTitulo() == null)
			tarefa.setTitulo("");
		String query = "SELECT t FROM Tarefa t " +
				"WHERE t.titulo LIKE '%" + tarefa.getTitulo() + "%'";
		
		return manager.createQuery(query, Tarefa.class).getResultList();
	}

	@Override
	public void remover(Long id) {
		manager.getTransaction().begin();
		Tarefa tarefa = manager.find(Tarefa.class, id);
		manager.remove(tarefa);
		manager.getTransaction().commit();
	}

	@Override
	public void atualizar(Tarefa tarefa) {
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
	}

	@Override
	public List<Tarefa> getTarefas() {
		String query = "SELECT t FROM Tarefa t";
		
		return manager.createQuery(query, Tarefa.class).getResultList();
	}

	@Override
	public Tarefa getTarefa(Long id) {
		return manager.find(Tarefa.class, id);
	}

}
