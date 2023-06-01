package br.com.trier.farmacia;

public class Medicamento extends Produto {
	
	private boolean reterReceitaMedica;// informar quando preciso se é true or false

	public Medicamento(String nome, Integer estoque, Double valor, boolean reterReceitaMedica) {
		super(nome, estoque, valor);
		this.reterReceitaMedica = reterReceitaMedica;
	}
	
	@Override
	public void venda(Integer qtdRequerida, Cliente cliente) {
		if(getEstoque() >= qtdRequerida && reterReceitaMedica){
			estoque = getEstoque() - qtdRequerida;
			cliente.setSaldoDevedor(cliente.getSaldoDevedor() + getValor());
		}
	}
}
