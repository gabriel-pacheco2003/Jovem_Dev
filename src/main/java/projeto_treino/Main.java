package projeto_treino;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public class Main {
	
	public static void main(String[] args) {
		
	int qtde = Integer.parseInt(JOptionPane.showInputDialog("Entre com a quantidade de produtos"));
	
	for (int i = 0; i < qtde; i++) {
		System.out.println("Produto " + (i + 1) + " data:");
		String p = JOptionPane.showInputDialog("Comum");
	}
		
	}
}
