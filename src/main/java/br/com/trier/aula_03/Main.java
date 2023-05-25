package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Main {
	
	public static void main(String[] args) {
		List<Time> lista = new ArrayList<Time>();
		int op = 0;
		do { 
				op = Util.escolheOp();
				switch (op) {
				case 1 :
						Util.cadastraTime(lista);
						break;
						
				case 2 : 
						Util.listaJogadoresTime(lista);
						break;
						
				case 3 :
						Util.exibeArtilheiro(lista);
						break;
						
				case 4 :
						Util.exibeTimeComMaisGols(lista);
						break;
						
				case 5 :
						break;
						
				default:
					JOptionPane.showMessageDialog(null,"Opção inválida");
						break;
				}
			
		} while (op != 5);
	
	}

}
	

