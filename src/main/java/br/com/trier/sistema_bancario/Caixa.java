package br.com.trier.sistema_bancario;

public class Caixa {

	public void operacaoDeposito(ContaCorrente conta, Double valor) {
		conta.deposito(valor);
	}

	public void operacaoSaque(ContaCorrente conta, Double valor) {
		conta.saque(valor);
	}

	public void operacaoTransferencia(ContaCorrente conta, ContaCorrente contaDestino,
			Double valor) {
		conta.transferencia(valor, contaDestino);
	}

}
