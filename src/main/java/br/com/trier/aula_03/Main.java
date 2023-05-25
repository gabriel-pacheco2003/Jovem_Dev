package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Data;

@Data
public class Main {
	
	public static void main(String[] args) {
		List<Time> lista = new ArrayList<Time>();
		int op = 0;
		do { 
				op = Util.escolheOp();
				switch (op) {
				case 1 :
						Time t = new Time();
						t.cadastraTime();
						lista.add(t);
						break;
						
				case 2 : 
						JOptionPane.showMessageDialog(null, Util.listaJogadores(lista));
						break;

				default:
						break;
				}
			
		} while (op != 5);
	}

}
