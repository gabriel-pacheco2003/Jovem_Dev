package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MainLivro {
	public static void main(String[] args) {
		List<Autor> autores = new ArrayList<Autor>();
		List<Livro> livros = new ArrayList<Livro>();
				
		int op = 0;
		while(op != 8) {
			op = UtilLivro.escolheOp();
			
			switch (op) {
			case 1 :
				UtilLivro.cadastraAutores(autores);
				break;
				
			case 2 :
				UtilLivro.cadastraLivros(autores, livros);
				break;
				
			case 3 :
				UtilLivro.listaLivros(livros);
				break;
				
			case 4 :
				UtilLivro.listaLivrosDoAutor(livros);
				break;
				
			case 5 :
				UtilLivro.listaLivrosPorValor(livros);
				break;
				
			case 6 :
				UtilLivro.listaPorIdade(autores);
				break;
				
			case 7 :
				UtilLivro.listaLivrosPorSexo(livros, autores);
				break;
				
			case 8 :
				break;

			default :
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
			}
		}
	}
}
