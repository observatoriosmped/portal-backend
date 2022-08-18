package br.gov.sp.prefeitura.smped.portalObservatorio.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoGrafico {

	PIZZA(1, "pie"),
	BARRAS(2, "bar");

	private Integer id;
	private String nome;
	
	private TipoGrafico(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonValue
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static TipoGrafico toEnum(String cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoGrafico x : TipoGrafico.values()) {
			if (cod.equals(x.getNome())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
