package br.com.trier.medicamento.util;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.medicamento.models.Medicamento;
import br.com.trier.medicamento.models.Pessoa;
import lombok.Getter;

@Getter
public class UtilMedicamento {

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	public Medicamento cadastraMedicamento(Medicamento m) {
		medicamentos.add(m);
		return m;
	}

	public Pessoa cadastraPessoas(Pessoa p) {
		pessoas.add(p);
		return p;
	}

	public boolean existePessoa(Pessoa p) {
		return pessoas.contains(p);
	}

	public boolean existeMedicamento(Medicamento m) {
		return medicamentos.contains(m);
	}

	public boolean prescreveMedicamento(Pessoa p, Medicamento m) {
		if (existePessoa(p) && existeMedicamento(m)) {
			return p.addMedicamento(m);

		}
		return false;
	}
	
	public void clearData() {
		pessoas.clear();
		medicamentos.clear();
	}

}
