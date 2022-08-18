package br.gov.sp.prefeitura.smped.portalObservatorio.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.prefeitura.smped.portalObservatorio.APIConnectors.APIPaineis;
import br.gov.sp.prefeitura.smped.portalObservatorio.domain.Painel;
import br.gov.sp.prefeitura.smped.portalObservatorio.services.exceptions.ObjectNotFoundException;

@Service
public class PainelService {
	
	@Autowired
	private APIPaineis apiPaineis;

	public List<Painel> findAll() {
		return apiPaineis.getPaineis();
	}

	public Painel findById(String id) {
		try {
			return apiPaineis.getPainel(id);
		} catch (Exception e) {
			throw new ObjectNotFoundException("Painel não encontrado!");
		}
	}



}
