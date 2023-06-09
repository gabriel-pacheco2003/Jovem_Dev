package br.com.trier.medicamento.models;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.medicamento.enums.EnumAdministracao;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class Medicamento {

	@NonNull
	private String nome;

	private EnumAdministracao administracao;

	private List<String> contraIndicacoes = new ArrayList<String>();

	private List<String> indicacoes = new ArrayList<String>();

	public void addIndicacao(String indicacao) {
		indicacoes.add(indicacao);
	}

	public void addContraIndicacao(String contraIndicacao) {
		contraIndicacoes.add(contraIndicacao);
	}

	public boolean isIndicado(String sintoma) {
		return indicacoes.contains(sintoma);
	}

	public boolean isContraIndicado(List<String> condicaoSaude) {
		return contraIndicacoes.stream().anyMatch(condicaoSaude::contains);
	}
}
