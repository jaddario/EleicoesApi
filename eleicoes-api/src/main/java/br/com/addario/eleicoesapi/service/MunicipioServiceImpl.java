package br.com.addario.eleicoesapi.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.addario.eleicoesapi.model.Candidato;
import br.com.addario.eleicoesapi.model.Municipio;
import br.com.addario.eleicoesapi.repository.MunicipioRepository;

@Service
public class MunicipioServiceImpl implements MunicipioService {

	@Autowired
	private MunicipioRepository repository;

	@Override
	public ResponseEntity<?> getMunicipios() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> adicionaMunicipio(Municipio municipio) {
		return new ResponseEntity<>(repository.save(municipio), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> persisteMunicipios(String arquivoJson) {

		JSONParser parser = new JSONParser();
		List<Municipio> municipios = new ArrayList<Municipio>();

		try (FileReader leitorArquivo = new FileReader(arquivoJson)) {
			JSONArray listaDeMunicipios = (JSONArray) parser.parse(leitorArquivo);
			List<Candidato> candidatos = new ArrayList<Candidato>();
			listaDeMunicipios.forEach(linhaMunicipio -> {

				String nomeMunicipio, identificadorMunicipio, tipo, identificadorTipo, estado, siglaEstado;
				nomeMunicipio = identificadorMunicipio = tipo = identificadorTipo = estado = siglaEstado = "";
				int index = 0;

				JSONArray linha = (JSONArray) linhaMunicipio;
				if (!linha.get(0).equals("#N/A") && !linha.get(0).equals("UF") && !linha.get(0).equals("BR")) {

					while (index < 6) {
						switch (index) {
						case 0:
							nomeMunicipio = (String) linha.get(index);
							break;

						case 1:
							identificadorMunicipio = (String) linha.get(index);
							break;

						case 2:
							tipo = (String) linha.get(index);
							break;

						case 3:
							identificadorTipo = (String) linha.get(index);
							break;

						case 4:
							estado = (String) linha.get(index);
							break;

						case 5:
							siglaEstado = (String) linha.get(index);
							break;
						default:
							break;
						}
						index++;
					}

					IntStream.range(6, linha.size()).forEach(item -> {
						JSONArray jsonArrayCandidato = (JSONArray) linha.get(item);
						Candidato candidato = new Candidato((String) jsonArrayCandidato.get(0),
								(String) jsonArrayCandidato.get(1), (Long) jsonArrayCandidato.get(2),
								(Double) jsonArrayCandidato.get(3), (String) jsonArrayCandidato.get(4));
						candidatos.add(candidato);
					});

					Municipio municipio = new Municipio(nomeMunicipio, identificadorMunicipio, tipo, identificadorTipo,
							estado, siglaEstado, candidatos);
					municipios.add(municipio);
					
					this.adicionaMunicipio(municipio);
				}
			});

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return municipios;
	}

}
