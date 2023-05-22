package br.com.trier.aula_01;

import javax.swing.JOptionPane;

public class IMC {

	public static void main(String[] args) {

		cadastraPessoas();

	}

	public static void cadastraPessoas() {

		Integer N = Integer.parseInt(JOptionPane.showInputDialog("Insira o número de pessoas a serem avaliadas"));	

		for (int i = 0; i < N; i++) {
			String nome = JOptionPane.showInputDialog("Insira o nome completo da " + (i+1) + "º pessoa");
			String sexo = JOptionPane.showInputDialog("Insira o sexo da " + (i+1) + "º pessoa");
			Double peso = Double.parseDouble(JOptionPane.showInputDialog("Insira o peso da " + (i+1) + "º pessoa"));
			Double altura = Double.parseDouble(JOptionPane.showInputDialog("Insira a altura da " + (i+1) + "º pessoa"));
			
			//System.out.println(nome + " \n" + sexo + " \n" + peso + " kg \n" + altura + " m");
			
		}

	}

}
