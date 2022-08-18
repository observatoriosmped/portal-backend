package br.gov.sp.prefeitura.smped.portalObservatorio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.prefeitura.smped.portalObservatorio.domain.Painel;
import br.gov.sp.prefeitura.smped.portalObservatorio.services.PainelService;

@RestController
@RequestMapping(value = "/paineis")
public class PainelResource {
	
	@Autowired
	private PainelService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Painel>> findAll() {
		List<Painel> paineis = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(paineis);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Painel> find(@PathVariable String id) {
		Painel painel = service.findById(id);
		return ResponseEntity.ok().body(painel);
	}
}
