package br.com.addario.eleicoesapi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.addario.eleicoesapi.model.Candidato;
import br.com.addario.eleicoesapi.model.Municipio;

class PersistenceServiceImplTest {


	
	@Test
	void test() {
		PersistenceServiceImpl persistenceServiceImpl = new PersistenceServiceImpl();
		List<Municipio> listaMunicipios = persistenceServiceImpl.getListaMunicipios();
		assertEquals("Rio Branco", listaMunicipios.get(0).getNome());
		assertEquals("Cruzeiro do Sul", listaMunicipios.get(1).getNome());
		
		List<Candidato> canditados = listaMunicipios.get(0).getCanditados();
		
		canditados.forEach(candidato -> {
			System.out.println(candidato.getNome());
		});
	}

}
