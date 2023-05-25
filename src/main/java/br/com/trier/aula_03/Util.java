package br.com.trier.aula_03;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Util {
	
	static int escolheOp() {
		
	String menu =  "1 - Cadastrar times \r\n"
			+ "2 - Listar todos jogadores de um time\r\n"
			+ "3 - Verificar artilheiro do campeonato\r\n"
			+ "4 - Verificar qual time fez mais gols no campeonato\r\n"
			+ "5 - Sair\r";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	
	}
	public static void cadastraTime(List<Time> lista) {
		Time t = new Time();
		t.cadastraTime();
		lista.add(t);
	}
	public static Time escolheTime(List<Time> lista) {
		String menu = "Escolha um time\n";
		int pos = 1;
		for (Time time : lista) {
			menu += pos + " - " + time.getNome() + "\n";
			pos ++;
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return lista.get(op-1);
		
	}
	
	public static void listaJogadoresTime(List<Time> lista) {
		JOptionPane.showMessageDialog(null, escolheTime(lista).listaJogadores()); ;
	}
				
	static void exibeArtilheiro(List<Time> lista) {
		Jogador artilheiro = null;
		int maxGols = 0;

		for (Time time : lista) {
			List<Jogador> jogadores = time.getJogadores();
			for (Jogador jogador : jogadores) {
				if (jogador.getGolsMarcados() > maxGols) {
					maxGols = jogador.getGolsMarcados();
					artilheiro = jogador;
				}
			}
		}
		if (artilheiro != null) {
			JOptionPane.showMessageDialog(null, "Artilhieiro do campeonato: " + artilheiro.getNome() + ", Com um total de " + artilheiro.getGolsMarcados() + " gols");
		}else {
			JOptionPane.showMessageDialog(null, "Não há jogadores cadastrados.");
		}
	}
	static void exibeTimeComMaisGols(List<Time> lista) {
		Time timeMaisGols = null;
		int maxGols = 0;

		for (Time time : lista) {
			int totalGols = time.getTotalGolsMarcados();
			if (totalGols > maxGols) {
				maxGols = totalGols;
				timeMaisGols = time;
			}
		}

		if (timeMaisGols != null) {
			JOptionPane.showMessageDialog(null,
					"Time com mais gols: " + timeMaisGols + ", Com um total de " + maxGols + " gols");
		} else {
			JOptionPane.showMessageDialog(null, "Não há times cadastrados.");
		}
	}

	
}
