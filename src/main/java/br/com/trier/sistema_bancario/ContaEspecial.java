package br.com.trier.sistema_bancario;

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
}
