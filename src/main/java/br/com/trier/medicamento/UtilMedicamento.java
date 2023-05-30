package br.com.trier.medicamento;

import java.util.ArrayList;
import java.util.List;

public class UtilMedicamento {

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

	private Medicamento addMedicamento(Medicamento m) {
		m.setId(medicamentos.size() + 1);
		medicamentos.add(m);
		return m;
	}

	private Pessoa addPessoas(Pessoa p) {
		p.setId(pessoas.size() + 1);
		pessoas.add(p);
		return p;
	}

	private void doPrescricao() {
		for(Pessoa p : pessoas) {
			
			boolean findMedicamento = false;
			for(Medicamento m : medicamentos) {
				if(m.getIndicacoes().contains(p.getSintoma())) &&
				 !m.getContraindicacoes().stream().anyMatch(p.getAlergias()::contains)) {
					 
				 }
			}
		}
	}

}
