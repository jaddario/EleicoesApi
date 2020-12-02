package br.com.addario.eleicoesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.addario.eleicoesapi.model.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

}
