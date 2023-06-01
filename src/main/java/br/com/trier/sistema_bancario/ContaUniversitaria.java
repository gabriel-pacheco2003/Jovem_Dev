package br.com.trier.sistema_bancario;

public class ContaUniversitaria extends ContaCorrente{
	
	private static final Double LIMITE_MAX = 2000.00;
			
	public ContaUniversitaria(String correntista, String numero, String agencia, Double saldo) {
		super(correntista, numero, agencia, saldo);
	}
	
	@Override
	public void deposito(Double valor) {
		if(saldo + valor <= LIMITE_MAX) {
			saldo += valor;
		} else {
			 throw new IllegalArgumentException("Limite de saldo ultrapassado");
		}
	}

}
