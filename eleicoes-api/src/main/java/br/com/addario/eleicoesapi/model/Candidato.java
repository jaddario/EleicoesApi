package br.com.addario.eleicoesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "candidatos")
public class Candidato extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2064968955182697524L;

	public Candidato(String partido, String nome, Long numeroVotos, Double percentualVotos, String flag) {
		this.partido = partido;
		this.nome = nome;
		this.numeroVotos = numeroVotos;
		this.percentualVotos = percentualVotos;
		this.flag = flag;
	}

	@Column(name = "nome")
	private String nome;
	@Column(name = "partido")
	private String partido;
	@Column(name = "numero_de_votos")
	private Long numeroVotos;
	@Column(name = "percentual_de_votos")
	private Double percentualVotos;
	@Column(name = "flag")
	private String flag;

	@ManyToOne
	private Municipio municipio;
}
