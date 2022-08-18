package br.gov.sp.prefeitura.smped.portalObservatorio.domain;

import java.util.List;

public class Regiao extends Item {

	private static final long serialVersionUID = 1L;
	private String cor;
	private List<Coordenada> coordenadas;
	
	public Regiao() {
		
	}
	public Regiao(String nome, float valor, String cor, List<Coordenada> coordenadas) {
		super(nome, valor);
		this.cor = cor;
		this.coordenadas = coordenadas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}
}
