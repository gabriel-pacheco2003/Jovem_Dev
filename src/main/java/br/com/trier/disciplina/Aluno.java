package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Aluno {

	private Integer id;
	
	@NonNull
	private String nome;
	
	@NonNull
	private List<NotaDisciplina> notasDisciplina;

	public Aluno(String nome) {
		this.nome = nome;
		this.notasDisciplina = new ArrayList<>();
	}
	
	public void addDisciplina(Disciplina disciplina,Aluno aluno, NotaDisciplina notasDisciplinas){
		NotaDisciplina notaDisciplina = new NotaDisciplina(disciplina);
		this.notasDisciplina.add(notaDisciplina);
	}
	
	private List<NotaDisciplina> calcularMediaDisciplinas() {
		for (NotaDisciplina notaDisciplina : getNotasDisciplina()) {
			double media = (notaDisciplina.getNotas()[0] + notaDisciplina.getNotas()[1] + notaDisciplina.getNotas()[2])
					/ 3;
			notaDisciplina.setMedia(media);
		}

		return getNotasDisciplina();
	}


}
