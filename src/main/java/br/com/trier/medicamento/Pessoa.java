package br.com.trier.medicamento;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Pessoa {

	private Integer id;
	
	private String nome;

	private String sintoma;

	private List<String> alergias;

}
