package projeto_treino;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Produto {
	
	private String nome;
	private Double preco;
	
	public String precoTag() {
		return getNome() + " $ " + getPreco();
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nPreço: " + getPreco();
	}

	public Produto() {}
}
