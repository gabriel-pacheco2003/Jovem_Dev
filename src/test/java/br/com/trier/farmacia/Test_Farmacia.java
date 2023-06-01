package br.com.trier.farmacia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test_Farmacia {

	private Farmacia farmacia = new Farmacia();

	@BeforeEach
	void init() {
		farmacia.getProdutos().clear();

		Produto produto1 = new Produto("Produto", 5, 10.00);
		Produto medicamento1 = new Medicamento("Medicamento", 10, 20.00, true);
		Produto perfume1 = new Perfumaria("Perfumaria", 7, 60.00);
		Produto equip1 = new EquipamentoMedico("Equipamento", 2, 200.00);
		
		farmacia.addProduto(produto1);
		farmacia.addProduto(medicamento1);
		farmacia.addProduto(perfume1);
		farmacia.addProduto(equip1);
		

	}

	@Test
	@DisplayName("Venda Produto")
	void vendaProdutoTest() {
		
	}

}
