package br.com.trier.medicamento.util;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.medicamento.models.Medicamento;
import br.com.trier.medicamento.models.Pessoa;
import br.com.trier.medicamento.util.UtilMedicamento;

class UtilMedicamentoTest { 
	
	private UtilMedicamento utilMed = new UtilMedicamento();
	
	@BeforeEach
	public void init() {
			utilMed.clearData();
			
			Pessoa p1 = new Pessoa("João", "Dor");
			p1.addAlergia("Rinite");
			
			Pessoa p2 = new Pessoa("Maria", "Febre");
			p2.addAlergia("Dengue");
			
			Pessoa p3 = new Pessoa("Zé", "Gripe");
			
			utilMed.cadastraPessoas(p1);
			utilMed.cadastraPessoas(p2);
			utilMed.cadastraPessoas(p3);
			
			Medicamento m1 = new Medicamento("Med 1");
			m1.addIndicacao("Dor");
			m1.addContraIndicacao("Rinite");
			
			Medicamento m2 = new Medicamento("Med 2");
			m2.addIndicacao("Gripe");
			m2.addContraIndicacao("Dengue");
			
			Medicamento m3 = new Medicamento("Med 3");
			m3.addIndicacao("Virose");
			m3.addContraIndicacao("Gripe");
			
			utilMed.cadastraMedicamento(m1);
			utilMed.cadastraMedicamento(m2);
			utilMed.cadastraMedicamento(m3);
			
	}
	
	@Test
	void prescreverOk() {
		Pessoa p = utilMed.getPessoas().get(2);
		Medicamento m = utilMed.getMedicamentos().get(1);
		boolean prescrito = utilMed.prescreveMedicamento(p, m);
		assertEquals(true, prescrito);
		assertEquals(1, p.getMedicamentos().size());
		assertEquals("Med 2", p.getMedicamentos().get(0).getNome());
		
	}
	
	@Test
	void prescreverFalhaIndicacao(){
		Pessoa p = utilMed.getPessoas().get(0);
		Medicamento m = utilMed.getMedicamentos().get(0);
		boolean prescrito = utilMed.prescreveMedicamento(p, m);
		assertEquals(false, prescrito);
		assertEquals(0, p.getMedicamentos().size());
		
	}
	
	@Test
	void prescreverFalhaContraIndicacao() {
		Pessoa p = utilMed.getPessoas().get(1);
		Medicamento m = utilMed.getMedicamentos().get(2);
		boolean prescrito = utilMed.prescreveMedicamento(p, m);
		assertEquals(false, prescrito);
		assertEquals(0, p.getMedicamentos().size());
	}

}

