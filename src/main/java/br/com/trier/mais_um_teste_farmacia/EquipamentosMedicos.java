package br.com.trier.mais_um_teste_farmacia;

import lombok.Getter;

@Getter
public class EquipamentosMedicos extends Produtos{

	public EquipamentosMedicos(String nome, int estoque, double valor) {
		super(nome, 0, valor);
	}
	
	@Override
	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade) {
		cliente.setDivida(cliente.getDivida() + (valor * quantidade));
		return true;
	}

}