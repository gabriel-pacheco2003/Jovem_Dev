package br.com.trier.farmacia;

public class Perfumaria extends Produto{

	private static final Double LIMITE_SALDO_DEVEDOR = 300.00;
	
	public Perfumaria(String nome, Integer estoque, Double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public void venda(Integer qtdRequerida, Cliente cliente) {
		if(cliente.getSaldoDevedor() <= LIMITE_SALDO_DEVEDOR && getEstoque() <= qtdRequerida) {
			estoque = getEstoque() - qtdRequerida;
			cliente.setSaldoDevedor(cliente.getSaldoDevedor() + getValor());
		}
	}
}
