package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Livro {
	
	private String titulo;
	private Double preco;
	private List<Autor> autores = new ArrayList<Autor>();
	
	private void cadastraLivros(List<Autor> autores) {
		titulo = JOptionPane.showInputDialog("Título do livro");
		preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do livro"));
		
		
	}

}
