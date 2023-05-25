package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {
	
	private String nome;
	private List<Jogador> jogadores = new ArrayList<Jogador>();	

	public void cadastraTime() {
		nome = JOptionPane.showInputDialog("Nome do time");
		int op = 0;
		
		do {
		Jogador j = new Jogador();
		j.cadastraJogadores();
		jogadores.add(j);
		
		op = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais jogadores?\n 1 - Sim\n 2 - Não"));
		} while (op == 1);
		
		
	}
    public int getTotalGolsMarcados() {
    	
    	int totalGols = 0;
    	for (Jogador jogador : jogadores) {
			totalGols += jogador.getGolsMarcados();
		}
        return totalGols;
    }
    public Jogador getArtilheiro() {
    	Jogador artilheiro = null;
    	int maxGols = 0;
    	
    	for (Jogador jogador : jogadores) {
			if(jogador.getGolsMarcados() > maxGols)
				maxGols = jogador.getGolsMarcados();
				artilheiro = jogador;
		}
    	
    	return artilheiro;
    }
    
	public String listaJogadores() {
		String ret = "Jogadores do time: " + nome+"\n";
		for (Jogador jogador : jogadores) {
			ret += jogador;
		}
		return ret;
	}
    
	@Override
	public String toString() {
		return "Time: " + getNome() + "\n" + "Jogadores: \n" + getJogadores() + " ";
	}
	
}


