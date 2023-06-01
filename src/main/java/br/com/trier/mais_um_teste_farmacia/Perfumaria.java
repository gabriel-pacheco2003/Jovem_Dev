package br.com.trier.mais_um_teste_farmacia;

import lombok.Getter;

@Getter
public class Perfumaria extends Produtos{

	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade) {
		if (cliente.getDivida() + (produto.getValor() * quantidade) < 300.00 && isEstoque(produto, quantidade)) {
			super.realizaVenda(cliente, produto, quantidade);
			return true;
		}
		return false;
	}

}