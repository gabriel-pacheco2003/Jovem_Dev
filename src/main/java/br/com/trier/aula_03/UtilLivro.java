package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UtilLivro {
	
	static int escolheOp() {
		
		String menu = "Menu\n"
		+ " 1 - Cadastrar Autor \n" 
		+ " 2 - Cadastrar Livros\n"
		+ " 3 - Listar todos os livros cadastrados\n"
		+ " 4 - Pesquisar por autor\n"
		+ " 5 - Pesquisar por faixa de valor do livro\n"
		+ " 6 - Listar todos os livros cujo autores tenham crianças\n"
		+ " 7 - Listar todos os livros que foram escritos apenas por mulheres ou por homens\n"
		+ " 8 - Sair";
			return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	static void listaLivros(List<Livro> livros) {
		JOptionPane.showMessageDialog(null, retornaString(livros));
	}
	
	static void listaLivrosDoAutor(List<Livro> livros, List<Autor> autores) {
		Livro livro = new Livro();
		String autorInformado = JOptionPane.showInputDialog(livro.getAutores(autores) + "Informe um autor").toUpperCase();
		for(Livro l : livros) {
			for(Autor a : autores)
			if(a.getNomeCompleto().equalsIgnoreCase(autorInformado)){
				JOptionPane.showMessageDialog(null, "Livro(s): " + l.getTitulo() + "\n");
			}	
		}
	}
	
	static String listaLivrosPorValor(List<Livro> livros ) {
		List<Livro> livrosPorValor = new ArrayList<Livro>();
		
		Double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor mínimo"));
		Double valorMaximo = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor máximo"));
		for(Livro l : livros) {
			if(valorMinimo <= l.getPreco() && valorMaximo >= l.getPreco()) {
				livrosPorValor.add(l);
			}
		}
		return retornaString(livrosPorValor);
	}
	
	static String listaPorIdade(List<Autor> autores) {
		List<Autor> listaIdade = new ArrayList<Autor>();
		for(Autor a : autores) {
			if (a.getIdade() <= 12) {
				listaIdade.add(a);
			}
		}
		return retornaString(listaIdade);
	}
	
	static String listaLivrosPorSexo(List<Livro> livros) {
		List<Livro> livroGenero = new ArrayList<Livro>();
		String sexoSelecionado = JOptionPane.showInputDialog("Digite (M) para Masculino ou (F) para Feminino");
		for(Livro l : livros) {
			if(l.sexoAutor(sexoSelecionado)) {
					livroGenero.add(l);
				}
			}
		
		return retornaString(livroGenero);
	}
	
	public static void cadastraLivros(List<Autor> autores, List<Livro> livros) { 
		int op = 0;
			do {
				Livro l = new Livro();
				l.cadastraLivro(autores);
				livros.add(l);
				op = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais livros?\n 1 - Sim\n 2 - Não"));
			} while (op == 1);
	}
		
	public static void cadastraAutores(List<Autor> autores) { 
		int op = 0;
			do {
				Autor a = new Autor();
				a.cadastra();
				autores.add(a);
				op = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais autores?\n 1 - Sim\n 2 - Não"));
			} while (op == 1);
	}
	
	static <A> String retornaString(List<A> Array) {
		String ret = "";
			for (A objeto : Array) {
				ret += objeto.toString();
			}
		return ret;
	}
	
}
