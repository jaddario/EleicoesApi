package br.com.addario.eleicoesapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.addario.eleicoesapi.model.Municipio;

@Service
public interface PersistenceService {
	
	public List<Municipio> getListaMunicipios();
}
