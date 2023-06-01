package br.com.trier.mais_um_teste_farmacia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class FarmaciaUtil {
	
	private List<Produtos> produtos = new ArrayList<Produtos>();
	
	
	public Produtos cadastraProduto(Produtos produto) {
		produtos.add(produto);
		return produto;
	}
	
	public List<Produtos> listaTodos(){
		return produtos;
	}
	
	public List<Produtos> listaEquipamentosMedico() {
		List<Produtos> equipamentosMedicos = produtos.stream().filter(e -> e instanceof EquipamentosMedicos).collect(Collectors.toList());
		return equipamentosMedicos;
	}
	
	public List<Produtos> listaMedicamento(){
		List<Produtos> medicamentos = produtos.stream().filter(m -> m instanceof Medicamentos).collect(Collectors.toList());
		return medicamentos;
	}
	
	public List<Medicamentos> listaMedicamentosReceita(){
		List<Medicamentos> medicamentos = produtos.stream().filter(p -> p instanceof Medicamentos && ((Medicamentos) p).isReceita()).map(p -> (Medicamentos) p).collect(Collectors.toList());
		return medicamentos;
	}

	public List<Produtos> listaPerfumadia(){
		List<Produtos> perfumaria = produtos.stream().filter(p -> p instanceof Perfumaria).collect(Collectors.toList());
		return perfumaria;
	}
	
	public boolean pagamentoTotal(Cliente cliente) {
		if (cliente.isDevedor(cliente)) {
			cliente.setDivida(0);
			return true;
		}
		return false;
	}
	
	public boolean pagamentoParcial(Cliente cliente, Double pagamento) {
		
		if (cliente.isDevedor(cliente) && pagamento <= cliente.getDivida()) {
			cliente.setDivida(cliente.getDivida() - pagamento);
			return true;
		}
		return false;
	}
	
	
	
}