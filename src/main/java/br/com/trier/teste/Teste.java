package br.com.trier.teste;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		List<Animais> animais = new ArrayList<Animais>();
		
		Animais ani = new Animais();
		ani.cadastraAnimais();
		animais.add(ani);
		
		JOptionPane.showMessageDialog(null, animais);
	}
	

}
