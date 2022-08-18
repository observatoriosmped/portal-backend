package br.gov.sp.prefeitura.smped.portalObservatorio.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoAgregacao {
	
	CONTAGEM(1, "Contagem", "contagem simples"),
	SOMA(2, "Soma", "soma dos valores"),
	MEDIA(3,  "Média", "média dos valores");
	
	private int id;
	private String cod;
	private String descricao;
	
	private TipoAgregacao(int id, String cod, String descricao) {
		this.setId(id);
		this.cod = cod;
		this.descricao = descricao;
	}

	@JsonValue
	public String getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static TipoAgregacao toEnum(String cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoAgregacao x : TipoAgregacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
