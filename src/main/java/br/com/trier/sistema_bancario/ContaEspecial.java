package br.com.trier.sistema_bancario;

import lombok.Getter;

@Getter
public class ContaEspecial extends ContaCorrente {

	private Double limite;

	public ContaEspecial(String correntista, String numero, String agencia, Double saldo, Double limite) {
		super(correntista, numero, agencia, saldo);
		this.limite = limite;
	}

	@Override
	public void saque(Double valor) {
		if (saldo + limite >= valor) {
			saldo -= valor;

		} else {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
	}
	
	@Override
	public void transferencia(Double valor, ContaCorrente destino) {
		if(saldo + limite >= valor) {
			saldo -= valor;
			destino.saldo += valor;
		} else {
			 throw new IllegalArgumentException("Saldo insuficiente");
		}
	}
}
