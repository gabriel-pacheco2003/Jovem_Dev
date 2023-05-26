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
	
	public void cadastraLivro(List<Autor> autores) {
		
		titulo = JOptionPane.showInputDialog("Título do livro").toLowerCase();
		preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do livro R$"));
		escolheOpAutor(autores);
		
		if(!valida()) {
			cadastraLivro(autores);
		}
	}
	
	private boolean valida() {
		if (titulo.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Título inválido");
			return false;
		}
		if(preco <= 0) {
			JOptionPane.showMessageDialog(null, "Preço inválido");
			return false;
		}
		return true;
	}
		
	public void escolheOpAutor(List<Autor> autores) {
		int op = 0;
		int contador = 0;
		int num = 0;
		
		do {	
			op = Integer.parseInt(JOptionPane.showInputDialog("Selecione um autor\n" + getAutores(autores)));
			this.autores.add(autores.get(op - 1));
			num = Integer.parseInt(JOptionPane.showInputDialog("Deseja selecionar mais autores?\n 1 - Sim\n 2 - Não"));
			contador++;

		} while(contador < 4 && num == 1 && !autores.isEmpty());

	}
	
	public String getAutores(List<Autor> autores) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < autores.size(); j++) {
			String autor = autores.get(j).toString();
			sb.append((j + 1) + " - " + autor);
		}
		return sb.toString();
	}
	
	public boolean sexoAutor(String sexo) {
			for (Autor a : autores) {
				if (!a.getSexo().equals(sexo)) {
					return false;
				}
			}
			return true;
	}

	@Override
	public String toString() {
		return titulo + " - R$" + preco + "\n" + getAutores(autores);
	}
}
