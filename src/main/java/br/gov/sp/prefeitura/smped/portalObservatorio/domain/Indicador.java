package br.gov.sp.prefeitura.smped.portalObservatorio.domain;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.prefeitura.smped.portalObservatorio.enums.TipoAgregacao;
import br.gov.sp.prefeitura.smped.portalObservatorio.enums.TipoIndicador;


public class Indicador {

	private String id;
	private String titulo;
	private String descricao;
	private String autor;
	private Long criacao;
	private String dimensao;
	private String metrica;
	private TipoAgregacao agregacao;
	private TipoIndicador tipo;
	private List<Serie> series = new ArrayList<>();
	private List<Regiao> regioes = new ArrayList<>();
	
		
	public Indicador() {
	}
	
	public TipoIndicador getTipo() {
		return tipo;
	}
	


	public void setTipo(TipoIndicador tipo) {
		this.tipo = tipo;
	}


	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Regiao> getRegioes() {
		return regioes;
	}

	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	private float max;
	
	
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

	public String getDimensao() {
		return dimensao;
	}

	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}

	public String getMetrica() {
		return metrica;
	}

	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}

	public TipoAgregacao getAgregacao() {
		return agregacao;
	}

	public void setAgregacao(TipoAgregacao agregacao) {
		this.agregacao = agregacao;
	}


	
}
