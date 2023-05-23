package br.com.trier.aula_02.carros;

import java.util.ArrayList;
import java.util.List;

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

		} while (op != 5);
	}

}
