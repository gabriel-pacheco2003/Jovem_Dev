package br.com.trier.disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Professor {

	@NonNull
	private Integer Id;
	@NonNull
	private String nome;
	@NonNull
	private EnumFormacao formacao;

}
