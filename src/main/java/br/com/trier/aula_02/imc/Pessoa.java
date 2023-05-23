package br.com.trier.aula_02.imc;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Pessoa {

	String nome;
	char sexo;
	double peso;
	double altura;

	double calculaImc() {
		return peso / (altura * altura);
	}

	void cadastrar() {
		nome = JOptionPane.showInputDialog("Nome");
		sexo = JOptionPane.showInputDialog("Sexo (M/F)").toUpperCase().charAt(0);
		peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Altura"));
	}

	String formataValor(double vl) {
		DecimalFormat df = new DecimalFormat("###,###.00");
		return df.format(vl);
	}

	String imprimir() {
		return "Nome:" + nome + " IMC: "+ formataValor(calculaImc()) + "(" + avaliaImc()+")\n";
	}

	String avaliaImc() {
		String ret = "Não identificado";
		double imc = calculaImc();

		if (sexo == 'F') {
			imc = imc * 0.9;
		}

		if (imc < 19.5) {
			ret = "Abaixo do peso";
		} else if (imc >= 19.1 && imc <= 25.8) {
			ret = "Peso ideal";
		} else if (imc > 25.8 && imc <= 27.3) {
			ret = "Pouco acima do peso";
		} else if (imc > 27.3 && imc <= 32.3) {
			ret = "Acima do peso";
		} else {
			ret = "Obesidade";
		}

		return ret;
	}

}
