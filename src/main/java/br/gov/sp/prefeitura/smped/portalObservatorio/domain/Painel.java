package br.gov.sp.prefeitura.smped.portalObservatorio.domain;

import java.io.Serializable;

public class Painel implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String titulo;
	private String descricao;
	private String autor;
	private String tema;
	
	private Long criacao;
	private Long utimaAlteracao;
	
	private Template template;
	
	public Painel() {
		
	}

	public Painel(String id, String titulo, String descricao, String autor, String tema) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.tema = tema;
	}

	public Painel(String id, String titulo, String descricao, String autor, Long criacao, Long utimaAlteracao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.criacao = criacao;
		this.utimaAlteracao = utimaAlteracao;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
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



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public Long getCriacao() {
		return criacao;
	}



	public void setCriacao(Long criacao) {
		this.criacao = criacao;
	}



	public Long getUtimaAlteracao() {
		return utimaAlteracao;
	}



	public void setUtimaAlteracao(Long utimaAlteracao) {
		this.utimaAlteracao = utimaAlteracao;
	}



	public Template getTemplate() {
		return template;
	}



	public void setTemplate(Template template) {
		this.template = template;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Painel other = (Painel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public String getTema() {
		return tema;
	}



	public void setTema(String tema) {
		this.tema = tema;
	}
	
	
	
	
}
