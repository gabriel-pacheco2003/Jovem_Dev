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
	
	static void listaJogadores (String nomeTime, List<Time> lista) {
		boolean achou = false;
		
		String timeInformado = JOptionPane.showInputDialog("Informe o Time desejado");
			for(Time t : lista) {
				if(t.getNome().equalsIgnoreCase(timeInformado)) {
					
					List<Jogador> jogadores = t.getJogadores();
					System.out.println("Jogadores do time: " + t.getNome());
					
					for(Jogador jogador : jogadores) {
						System.out.println("Nome: " + jogador.getNome() + "\nNúmero da camisa: " + jogador.getNumeroCamisa()
											+ "\nGols marcados: " + jogador.getGolsMarcados());
					}
					
				}
					
		} 
		if(!achou) {	
		JOptionPane.showConfirmDialog(null,"Time não encontrado");	
		}
				
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
