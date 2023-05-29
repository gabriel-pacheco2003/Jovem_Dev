package br.com.trier.disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Disciplina {

	@NonNull
	private String nome;
	@NonNull
	private Double cargaHoraria;
	@NonNull
	private Professor professor;

}
