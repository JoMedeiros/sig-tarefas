package br.com.esig.sigtar.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class DAOFactory {
	
	private final EntityManagerFactory managerFactory = 
		Persistence.createEntityManagerFactory("dev_sigtar");
	
	@Produces
	public TarefaDAO buildTarefaDAO() {
		EntityManager em = managerFactory.createEntityManager();
		return new TarefaDAOImpl(em);
	}
	
	@Produces
	public UsuarioDAO buildUsuarioDAO() {
		EntityManager em = managerFactory.createEntityManager();
		return new UsuarioDAOImpl(em);
	}
}
