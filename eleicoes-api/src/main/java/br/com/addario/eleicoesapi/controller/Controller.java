package br.com.addario.eleicoesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.eleicoesapi.model.Municipio;
import br.com.addario.eleicoesapi.repository.MunicipioRepository;

@RestController
@RequestMapping("/municipios")
public class Controller {

	@Autowired
	private MunicipioRepository repository;

	@GetMapping
	public ResponseEntity<?> getAllMunicipios() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Municipio municipio) {
		return new ResponseEntity<>(repository.save(municipio), HttpStatus.OK);
	}

}
