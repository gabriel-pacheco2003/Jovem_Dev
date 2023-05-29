package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Aluno {

	private String nome;
	private Map<Disciplina, List<Double>> notas;

	public void adicionarDisciplina(Disciplina disciplina) {
		notas.put(disciplina, new ArrayList<>());
	}

	public void adicionarNotas(Disciplina disciplina, double nota) {
		List<Double> listaNotas = notas.get(disciplina);
		if (listaNotas != null) {
			listaNotas.add(nota);
		}
	}

	public double calcularMedia(Disciplina disciplina) {
		List<Double> listaNotas = notas.get(disciplina);

		double soma = 0;
		for (double nota : listaNotas)
			soma += nota;

		return soma / listaNotas.size();
	}
}
