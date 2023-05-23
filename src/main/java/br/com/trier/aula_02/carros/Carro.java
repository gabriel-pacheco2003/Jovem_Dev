package br.com.trier.aula_02.carros;

import javax.swing.JOptionPane;

public class Carro {
	String marca;
	Integer ano;
	CorCarro cor;

	void cadastrar() {
		marca = JOptionPane.showInputDialog("Informe a marca do carro".toUpperCase());
		ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do carro"));
		cor = CorCarro.VERMELHO;

	}

	void periodoFabricacao() {
		int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano inicial"));
		int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano final"));
		
		for(Carro carros : Main.carros)
			

		System.out.println();
	}

}
