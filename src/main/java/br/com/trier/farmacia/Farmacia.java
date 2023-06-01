package br.com.trier.farmacia;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Farmacia {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public Produto addProduto(Produto produto) {
		produtos.add(produto);
		return produto;
	}
	
	public Cliente addCliente(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}
	
	public void realizaVenda(Produto produto, Cliente cliente) {
		produto.venda(null, cliente);
	}
	
	public void pagarConta(Cliente cliente, Double valor) {
		if(valor > 0.0) {
			cliente.setSaldoDevedor(cliente.getSaldoDevedor() - valor);
		} else {
			throw new IllegalArgumentException("Valor insuficiente");
		}
	}
	
	public List<Produto> listaProdutos() {
		return produtos;
	}
	
	public List<Cliente> listaClientes() {
		return clientes;
	}
	
	

}
