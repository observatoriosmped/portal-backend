package br.gov.sp.prefeitura.smped.portalObservatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Serie {

	private String nome;
	private List<Item> itens = new ArrayList<>();
	
	public Serie() {
		
	}
	
	public Serie(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> dados) {
		this.itens = dados;
	}
	
	public void addItem(Item item) {
		this.itens.add(item);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Serie other = (Serie) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
