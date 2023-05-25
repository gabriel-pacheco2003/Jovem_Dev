package br.com.trier.aula_03;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Data;

@Data
public class Util {
	
	static int escolheOp() {
		
	String menu =  "1 - Cadastrar times \r\n"
			+ "2 - Listar todos jogadores de um time\r\n"
			+ "3 - Verificar artilheiro do campeonato\r\n"
			+ "4 - Verificar qual time fez mais gols no campeonato\r\n"
			+ "5 - Sair\r";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	
	}
	static String listaJogadores(List<Time> times) {
		String timeInformado = JOptionPane.showInputDialog("Entre com o time desejado");
		String ret = "Jogadores do time: \n";
		for(Time t : times) {
				if (t.equals(timeInformado)) {
					ret += t.toString();
				}
		}
		return ret;
	}
	
}
