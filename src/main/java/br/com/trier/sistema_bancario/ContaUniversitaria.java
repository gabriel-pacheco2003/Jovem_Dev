package br.com.trier.sistema_bancario;

public class ContaUniversitaria extends ContaCorrente{

	public ContaUniversitaria(String correntista, String numero, String agencia, Double saldo) {
		super(correntista, numero, agencia, saldo);
	}
	
	@Override
	public void deposito(Double valor) {
		if(saldo >= valor && saldo + valor <= 2000.0) {
			saldo += valor;
		} else {
			 throw new IllegalArgumentException("Limite de saldo ultrapassado");
		}
	}
	
	@Override
	public void transferencia(Double valor, ContaCorrente destino) {
		if(saldo >= valor && saldo + valor <= 2000.0) {
			saldo -= valor;
			destino.saldo += valor;
		} else {
			 throw new IllegalArgumentException("Saldo insuficiente ou limite de saldo ultrapassado");
		}
	}

}
