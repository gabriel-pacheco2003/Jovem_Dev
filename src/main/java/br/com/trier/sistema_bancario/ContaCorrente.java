package br.com.trier.sistema_bancario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ContaCorrente {
	
	private String correntista;
	private String numero;
	private String agencia;
	protected Double saldo;
	
	public void deposito(Double valor) {
		saldo += valor;
	}
	
	public void saque(Double valor) {
		 if(saldo >= valor) {
			 saldo -= valor;
		 } else {
			 throw new IllegalArgumentException("Saldo insuficiente");
		 }
	}
	
	public void transferencia(Double valor, ContaCorrente destino) {
		if(saldo >= valor) {
			saldo -= valor;
			destino.saldo += valor;
		} else {
			 throw new IllegalArgumentException("Saldo insuficiente");
		}
	}

}
