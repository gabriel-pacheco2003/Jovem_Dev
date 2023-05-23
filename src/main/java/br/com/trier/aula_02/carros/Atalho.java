package br.com.trier.aula_02.carros;

import javax.swing.JOptionPane;

public class Atalho {
	
	static int escolheOp() {
		
		String menu = "1 - Cadastrar Carro\n"
				+ "2 - Listar os carros por período de fabricação\n"
				+ "3 - Lsitar carros por marca\n"
				+ "4 - Lsitar carros por cor\n\n"
				+ "5 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
}
