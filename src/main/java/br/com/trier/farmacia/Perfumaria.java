package br.com.trier.farmacia;

public class Perfumaria extends Produto{

	private static final Double LIMITE_SALDO_DEVEDOR = 300.00;
	
	public Perfumaria(String nome, Integer estoque, Integer valor) {
		super(nome, estoque, valor);
	}
	
	public void venderPerfumaria(Integer qtdRequerida, Double saldoDevedor) {
		if(saldoDevedor <= LIMITE_SALDO_DEVEDOR && getEstoque() <= qtdRequerida) {
			saldoDevedor -= getValor();
		}
	}
}
