package br.com.trier.aula_02.carros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_02.imc.Pessoa;

public class Main {
	static List<Carro> carros = new ArrayList<Carro>();

	public static void main(String[] args) {
		int op = 0;

		do {

			op = Atalho.escolheOp();

			if (op == 1) {
				Carro car = new Carro();
				car.cadastrar();
				carros.add(car);
			}

			if (op == 2) {
				String ret = "Lista de carros dentro do período de tempo informado\n\n";
				for (Carro car : listaPeriodoFabricacao(carros)) {
					ret += car.imprimir();
				}
				JOptionPane.showMessageDialog(null, ret);
			}
			
			if (op == 3) {
				String ret = "Lista de carros com a mesma marca informada\n\n";
				for(Carro car : listaPorMarca(carros)) {
					ret += car.imprimir();
				}
				JOptionPane.showMessageDialog(null, ret);
			}
			
			if(op == 4) {
				String ret = "Lista de carros com a mesma cor\n\n";
				for(Carro car : listaPorCor(carros)) {
					ret += car.imprimir();
				}
				JOptionPane.showMessageDialog(null, ret);
			}

		} while (op != 5);
	}

	static List<Carro> listaPeriodoFabricacao(List<Carro> carros) {
		int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano inicial"));
		int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano final"));

		for (Carro carro : carros) {
			if (!(Integer.compare(carro.ano, anoInicial) > 0 && Integer.compare(carro.ano, anoFinal) < 0)) {
				carros.remove(carro);
			}
		}
		return carros;

	}
	
	static List<Carro> listaPorMarca(List<Carro> carros) {
		String marcaInformada = JOptionPane.showInputDialog("Informe a marca desejada").toUpperCase();
		
		for(Carro carro : carros) {
			if(!(marcaInformada.equals(carro.getMarca()))) {
				carros.remove(carro);
			}
		}
		return carros;
	}
	
	static List<Carro> listaPorCor(List<Carro> carros) {
		String corInformada = JOptionPane.showInputDialog("Informe a cor desejada\n" + "1 - Vermelho\n" + "2 - Preto\n" + "3 - Branco\n" + "4 - Prata\n" + "5 - Outro");
		
		CorCarro corInformada = CorCarro.valueOf();
		
		for(Carro carro : carros) {
			if(!(1 == 2)) {
				carros.remove(carro);
			} else if (!(corInformada == 2)) {
				carros.remove(carro);
			} else if (!(corInformada == 3)) {
				carros.remove(carro);
			} else if (!(corInformada == 4)) {
				carros.remove(carro);
			} else if (!(corInformada == 5)) {
				carros.remove(carro);
			} else {
				JOptionPane.showMessageDialog(null, "Cor ínválida");
			}
		}
		return carros;
	}

}
