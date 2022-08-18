package br.gov.sp.prefeitura.smped.portalObservatorio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Template implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer valor;
	private String viewValue;
	
	private List<Widget> widgets = new ArrayList<>();

	public Template() {
		super();
	}

	public Template(Integer valor, String viewValue) {
		super();
		this.valor = valor;
		this.viewValue = viewValue;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getViewValue() {
		return viewValue;
	}

	public void setViewValue(String viewValue) {
		this.viewValue = viewValue;
	}

	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

}
