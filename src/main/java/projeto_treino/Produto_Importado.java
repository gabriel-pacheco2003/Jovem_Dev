package projeto_treino;

import lombok.Getter;

@Getter
public class Produto_Importado extends Produto {

	private Double taxaAlf;

	public Produto_Importado(String nome, Double preco) {
		super(nome, preco);
		this.taxaAlf = taxaAlf;
	}

	@Override
	public String precoTag() {
		return getNome() + " $ " + precoTotal() + "(Taxa de alfândega: $ " + getTaxaAlf() + " )";
	}

	public Double precoTotal() {
		return getPreco() + getTaxaAlf();
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nPreço: " + getPreco() + "\nTaxa de alfândega: " + getTaxaAlf();
	}

}
