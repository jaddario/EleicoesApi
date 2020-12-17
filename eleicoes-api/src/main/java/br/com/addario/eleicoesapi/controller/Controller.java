package br.com.addario.eleicoesapi.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.eleicoesapi.model.Municipio;
import br.com.addario.eleicoesapi.service.MunicipioService;

@RestController
@RequestMapping("/municipios")
public class Controller {

	@Autowired
	private MunicipioService service;

	@PostConstruct
	public void persiste() {
		service.persisteMunicipios("./resource/resultado-1-turno-presidente-2014.json");
	}

	@GetMapping
	public ResponseEntity<?> getMunicipios() {
		return service.getMunicipios();
	}

	@PostMapping
	public ResponseEntity<?> adicionaMunicipios(@RequestBody Municipio municipio) {
		return service.adicionaMunicipio(municipio);
	}
}
