package br.com.trier.exercicio_farmacia_prof;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Produto {
	
	private String nome;
	private int estoque;
	private double valor;
	
	public boolean vender(Venda v) {
		estoque = getEstoque() - v.getQuantidade();
		v.getCliente().adicionaValor(v.getQuantidade()*getValor());
		return true;
	}

}