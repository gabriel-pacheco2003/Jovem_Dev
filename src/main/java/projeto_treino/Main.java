package projeto_treino;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Main {
	
	public static void main(String[] args) {
		
	int qtde = Integer.parseInt(JOptionPane.showInputDialog("Entre com a quantidade de produtos"));
	
	Produto prod = new Produto();
	
	for (int i = 0; i < qtde; i++) {
		System.out.println("Produto " + (i + 1) + " data:");
		String p = JOptionPane.showInputDialog("Comum, usado ou importado (c, u, i)?");
		if(p.equals("c")) {
			System.out.println("Nome: " + prod.getNome() + "\nPreço: " + prod.getNome());
		}
	}
		
	}
}
