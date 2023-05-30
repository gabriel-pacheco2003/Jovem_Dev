package br.com.trier.medicamento.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class Pessoa {

	@NonNull
	private String nome;

	@NonNull
	private String sintoma;

	private List<String> alergias = new ArrayList<String>();

	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	public void addAlergia(String alergias) {
		this.alergias.add(alergias);
	}

	public boolean addMedicamento(Medicamento medicamento) {
		if (medicamento.isIndicado(sintoma) && !medicamento.isContraIndicado(alergias)) {
			medicamentos.add(medicamento);
			return true;
		}
		return false;
	}
}
