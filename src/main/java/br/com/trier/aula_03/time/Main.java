package br.com.trier.aula_03.time;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Main {
	
	public static void main(String[] args) {
		List<Jogador> lista = new ArrayList<Jogador>();
		int op = 0;
		do { 
				op = Util.escolheOp();
				switch (op) {
				case 1 :
						Jogador j = new Jogador();
						j.cadastraJogadores();
						lista.add(j);
						break;

				default:
					break;
				}
			
		} while (op != 5);
	}

}
