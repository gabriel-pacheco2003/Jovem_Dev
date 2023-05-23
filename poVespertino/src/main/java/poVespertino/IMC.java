package poVespertino;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class IMC {
	
	static List<String> nomes = new ArrayList<String>();
	static List<String> sexos = new ArrayList<String>();
	static List<Double> pesos = new ArrayList<Double>();
	static List<Double> alturas = new ArrayList<Double>();

	public static void main(String[] args) {
		String menu = "1 - Cadastrar\n" + "2 - Avaliar\n" + "3 - Sair";

		int opcao = 0;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (opcao == 1) {
				cadastrar();
			}
			if (opcao == 2) {
				avaliar();
			}
		} while (opcao != 3);

	}

	public static void cadastrar() {
		nomes.add(JOptionPane.showInputDialog("Nome"));
		sexos.add(JOptionPane.showInputDialog("Sexo (M/F)"));
		pesos.add(Double.parseDouble(JOptionPane.showInputDialog("Peso")));
		alturas.add(Double.parseDouble(JOptionPane.showInputDialog("Altura")));
	}
	public static void avaliar() {
		String retorno = "IMCs\n\n";
		for(int i = 0; i < nomes.size(); i++) {
			String nome = nomes.get(i);
			String sexo = sexos.get(i);
			Double peso = pesos.get(i);
			Double altura = alturas.get(i);
			Double imc = peso / (altura * altura);
			String avaliacao = avaliaImc(sexo, imc);
			retorno += "\n" + nome + " - " + imc + " - " + avaliacao;
			
		}
		JOptionPane.showMessageDialog(null, retorno);
	}

	private static String avaliaImc(String sexo, Double imc) {
		if(sexo.equalsIgnoreCase("M")) {
			if(imc < 20.7) {
				return "Abaixo do peso";
				} else if(imc >= 20.7 && imc <= 26.4) {
					return "Peso Ideal";
				} else if (imc > 26.4 && imc <= 27.8) {
					return "Pouco acima do peso";
				} else if (imc > 27.8 && imc <= 31.1) {
					return "Acima do peso";
				} else {
					return "Obesidade";
				}
					
		}
		if(sexo.equalsIgnoreCase("F")) {
			if(imc < 19.1) {
				return "Abaixo do peso";
			} else if(imc >= 19.1 && imc <= 25.8) {
				return "Peso ideal";
			} else if(imc > 25.8 && imc <= 27.3) {
				return "Pouco acima do peso";
			} else if(imc > 27.3 && imc <= 32.3) {
				return "Acima do peso";
			} else {
				return "Obesidade";
			}
			
		}

		return "Não foi possivel avaliar";
	}

}
