package br.com.trier.mais_um_teste_farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produtos {
	private String nome;
	private int estoque;
	protected double valor;
	
	
	public boolean isEstoque(Produtos produto, int quantidade) {		
		if ((produto.getEstoque() - quantidade) > 0) {
			return true ;
		}
		return false;
	}
	
	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade) {
		if ((estoque - quantidade) > 0) {
			estoque -= quantidade;
			cliente.setDivida(cliente.getDivida() + (valor * quantidade)); 
			return true;
		}
		return false;
	}

}