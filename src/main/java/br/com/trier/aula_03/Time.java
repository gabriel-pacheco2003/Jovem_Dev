package br.com.trier.aula_03;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Data;

@Data
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

	protected void cadastraTime() {
		nome = JOptionPane.showInputDialog("Nome do time");
		
		int op = 0;
		
		do {
		Jogador j = new Jogador();
		j.cadastraJogadores();
		this.jogadores.add(j);
		
		op = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar mais jogadores?\n 1 - Sim\n 2 - Não"));
		} while (op == 1);
		
	}
	@Override
	public String toString() {
		return "Time: " + nome + "\n" + "Jogadores: \n" + jogadores + " ";
	}
	
}


