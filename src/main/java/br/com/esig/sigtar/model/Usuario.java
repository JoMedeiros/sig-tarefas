package br.com.esig.sigtar.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="usuario_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome", unique=true, nullable=false)
	private String nome;
	
	@Column(name="senha")
	private String senha;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private List<Tarefa> tarefas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
}
