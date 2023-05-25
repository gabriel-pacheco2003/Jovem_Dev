package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {
	
	private String nome;
	private List<Jogador> jogadores;
	
	public Time(String nome) {
		
		this.nome = nome;
		this.jogadores = new ArrayList<Jogador>();
	}
			
	public Time() {
		this.jogadores = new ArrayList<Jogador>();

	}
	  public void adicionarJogador(Jogador jogador) {
	        jogadores.add(jogador);
	}

	protected void cadastraTime() {
		String nomeTime = JOptionPane.showInputDialog("Nome do time");
		
		Time time = new Time(nomeTime);
		int op = 0;
		
		do {
		Jogador j = new Jogador();
		j.cadastraJogadores();
		time.adicionarJogador(j);
		
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
    
	@Override
	public String toString() {
		return "Time: " + getNome() + "\n" + "Jogadores: \n" + getJogadores() + " ";
	}
	
}


