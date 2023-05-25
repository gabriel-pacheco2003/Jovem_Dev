package br.com.trier.aula_03;

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
		+ " 2 – Cadastrar Livros (escolher entre os autores cadastrados)\n"
		+ " 3 - Listar todos os livros cadastrados (todos os dados do livro, inclusive os autores com todos os dados)\n"
		+ " 4 - Pesquisar por autor (listar todos os livros de um autor)\n"
		+ " 5 - Pesquisar por faixa de valor do livro (mínimo e máximo)\n"
		+ " 6 - Listar todos os livros cujo autores tenham crianças (idade <=12)\n"
		+ " 7 – Listar todos os livros que foram escritos apenas por mulheres ou por homens (o usuário informa qual sexo deseja realizar a consulta)\n"
		+ " 8 - Sair";
			return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	static void listaAutores(List<Autor> autores) {
		
	}
	
	static int escolheOpAutor(List<Autor> autores) {
		int op = 0;
		int contador = 0;
		int num = 0;
		
		do {
			int i = 0;
			op = Integer.parseInt(JOptionPane.showInputDialog("Selecione um autor\n" + (i+1) + " - " + autores ));
			num = Integer.parseInt(JOptionPane.showInputDialog("Deseja selecionar mais autores?\n 1 - Sim\n 2 - Não"));
			contador++;
			i++;
			
		}while(contador < 4 && num == 1);
		
		return op;
	}
	
	public static void cadastraAutores(List<Autor> autores) { 
		int op = 0;
			do {
				Autor a = new Autor();
				a.cadastra();
				autores.add(a);
				System.out.println(autores);
				op = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais autores?\n 1 - Sim\n 2 - Não"));
			} while (op == 1);
		
	}
	public static Autor escolheAutor(List<Autor> sutores) {
		String menu = "Escolha um autor\n";
		int pos = 1;
		for (Autor a : sutores) {
			menu += pos + " - " +  + "\n";
			pos ++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return times.get(op-1);
		
	}
	
	public static String listaJogadoresTime(List<Time> times) {
		return escolheTime(times).listaJogadores();
	}

}
