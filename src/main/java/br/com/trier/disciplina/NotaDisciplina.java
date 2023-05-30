package br.com.trier.disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotaDisciplina {
	
	@NonNull
	private Disciplina disciplina;
	
	private Double[] notas;

	private Double media;

	public NotaDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
		this.notas = new Double[3];
	}

}
