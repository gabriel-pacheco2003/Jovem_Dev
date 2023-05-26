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
		+ " 2 - Cadastrar Livros (escolher entre os autores cadastrados)\n"
		+ " 3 - Listar todos os livros cadastrados (todos os dados do livro, inclusive os autores com todos os dados)\n"
		+ " 4 - Pesquisar por autor (listar todos os livros de um autor)\n"
		+ " 5 - Pesquisar por faixa de valor do livro (mínimo e máximo)\n"
		+ " 6 - Listar todos os livros cujo autores tenham crianças (idade <=12)\n"
		+ " 7 - Listar todos os livros que foram escritos apenas por mulheres ou por homens (o usuário informa qual sexo deseja realizar a consulta)\n"
		+ " 8 - Sair";
			return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	static void listaLivros(List<Livro> livros) {
		JOptionPane.showMessageDialog(null, livros.toString());
	}
	
	static void listaLivrosDoAutor(List<Livro> livros) {
		String autorInformado = JOptionPane.showInputDialog("Informe um autor").toUpperCase();
		for(Livro l : livros) {
			if(l.getAutores().equals(autorInformado)){
			JOptionPane.showMessageDialog(null, "Livro(s): " + l.getTitulo() + "\n");
			} else {
				JOptionPane.showMessageDialog(null, "Autor " + autorInformado + " não encontrado");
			} 	
		}
	}
	
	static void listaLivrosPorValor(List<Livro> livros ) {
		Double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor mínimo"));
		Double valorMaximo = Double.parseDouble(JOptionPane.showInputDialog("Entre com o valor máximo"));
		for(Livro l : livros) {
			if(valorMinimo <= l.getPreco() && valorMaximo >= l.getPreco()) {
				JOptionPane.showMessageDialog(null, l.getTitulo() + " R$" + l.getPreco());
			}
		}
	}
	
	static void listaPorIdade(List<Autor> autores) {
		for(Autor a : autores) {
			if (a.getIdade() <= 12) {
				JOptionPane.showMessageDialog(null, a.getNomeCompleto() + " - " + a.getIdade() + " anos ");	
			} 
		}
	}
	
	static void listaLivrosPorSexo(List<Livro> livros, List<Autor> autores) {
		String sexoInformado = JOptionPane.showInputDialog("Digite (M) para Masculino ou (F) para Femenino");
		if(!(sexoInformado.equalsIgnoreCase("M") || sexoInformado.equalsIgnoreCase("F"))) {
			JOptionPane.showMessageDialog(null, "Sexo inválido");
			
		} else {
			for(Livro l : livros) {
				for(Autor a : autores) {
					if(a.getSexo().equals(sexoInformado)) {
						JOptionPane.showMessageDialog(null, l.getTitulo());
					}
				}
			}
		}
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
	
}
