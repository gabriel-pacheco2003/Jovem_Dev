package br.com.trier.teste;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Animais {
	private String tipo;
	private String nome;
	private String sexo;
	
	public Animais(String tipo, String nome, String sexo) {
		this.tipo = tipo;
		this.nome = nome;
		this.sexo = sexo;
	}
	
	public Animais() {}
	
	void cadastraAnimais() {
		this.tipo = JOptionPane.showInputDialog("Tipo");
		this.nome = JOptionPane.showInputDialog("Nome");
		this.sexo = JOptionPane.showInputDialog("Sexo (M/F)").toUpperCase();
		
	}


	
}
