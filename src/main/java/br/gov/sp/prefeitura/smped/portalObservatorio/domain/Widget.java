package br.gov.sp.prefeitura.smped.portalObservatorio.domain;

import br.gov.sp.prefeitura.smped.portalObservatorio.domain.Indicador;

public class Widget {
	
	private Integer placement;
	private Indicador indicador;
	
	public Widget() {
		super();
	}
	public Integer getPlacement() {
		return placement;
	}
	public void setPlacement(Integer placement) {
		this.placement = placement;
	}
	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}
	
	

}
