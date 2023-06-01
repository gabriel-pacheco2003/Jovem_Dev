package br.com.trier.farmacia;

public class EquipamentoMedico extends Produto{

	public EquipamentoMedico(String nome, Integer estoque, Double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public void venda(Integer qtdRequerida, Cliente cliente) {
		if(qtdRequerida > 0) {
			estoque = getEstoque() - qtdRequerida;
			cliente.setSaldoDevedor(cliente.getSaldoDevedor() + getValor());
		}
	}
	
}
