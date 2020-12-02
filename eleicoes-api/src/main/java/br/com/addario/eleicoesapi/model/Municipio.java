package br.com.addario.eleicoesapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "municipios")
public class Municipio extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8913144359076215605L;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "identificador_municipio")
	private int identificadorMunicipio;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "identificador_tipo")
	private String identificadorTipo;
	@Column(name = "estado")
	private String estado;
	@Column(name = "sigla_estado")
	private String siglaEstado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio")
	private List<Candidato> canditados;

}
