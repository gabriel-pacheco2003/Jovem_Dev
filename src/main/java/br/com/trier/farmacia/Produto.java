package br.com.trier.farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Produto {
	
	private String nome;
	protected Integer estoque;
	private Double valor;

	public void isEstoque(Produto produto) {
		if(getEstoque() > 0) {
			estoque = getEstoque();
		} else {
			throw new IllegalArgumentException("Estoque vazio");
		}
	}
	
	public void venda(Integer qtdRequerida, Cliente cliente) {
		if(getEstoque() > 0) {
			estoque = getEstoque() - qtdRequerida;
			cliente.setSaldoDevedor(cliente.getSaldoDevedor() + getValor());
		} else {
			throw new IllegalArgumentException("Estoque vazio");
		}
	}
}
