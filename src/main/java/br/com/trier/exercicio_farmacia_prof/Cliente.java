package br.com.trier.exercicio_farmacia_prof;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cliente {
	
	private String nome;
	private double saldo;
	
	public double pagarConta(double vl) {
		if(vl > 0 && getSaldo() >= vl) {
			saldo = getSaldo() - vl;
		}
		return getSaldo();
	}
	
	public void adicionaValor(double vl) {
		saldo = getSaldo() + vl;
	}

}
