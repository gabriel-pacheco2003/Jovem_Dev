package br.com.trier.disciplina;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Professor {

	private Integer id;

	@NonNull
	private String nome;

	@NonNull
	private EnumFormacao formacao;

}
