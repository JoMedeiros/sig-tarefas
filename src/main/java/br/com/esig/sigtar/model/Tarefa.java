package br.com.esig.sigtar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarefa")
public class Tarefa implements Serializable {

	public enum Prioridade {
		ALTA("alta"), MEDIA("média"), BAIXA("baixa");
		private String code;
		private Prioridade(String code) {
			this.code = code;
		}
		public String getCode() {
			return code;
		}
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="tarefa_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario responsavel;
	
	@Column(name="prioridade")
	//@Enumerated(EnumType.STRING)
	private String prioridade;
	
	@Column(name="concluida")
	private Boolean concluida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	public Boolean getConcluida() {
		return concluida;
	}
	
	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

}
