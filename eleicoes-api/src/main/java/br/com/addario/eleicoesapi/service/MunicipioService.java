package br.com.addario.eleicoesapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.addario.eleicoesapi.model.Municipio;

@Service
public interface MunicipioService {

	public ResponseEntity<?> getMunicipios();

	public ResponseEntity<?> adicionaMunicipio(Municipio municipio);

	public List<Municipio> persisteMunicipios(String arquivoJson);
}
