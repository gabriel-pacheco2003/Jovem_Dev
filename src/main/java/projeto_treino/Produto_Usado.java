package projeto_treino;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Produto_Usado extends Produto {

	private LocalDate dataFabricacao;

	public Produto_Usado(String nome, Double preco, LocalDate dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	@Override
	public String precoTag() {
		return getNome() + " (usado) $ " + getPreco() 
			+ "( Data de fabricação: " + getDataFabricacao() + " )";
	}

}
