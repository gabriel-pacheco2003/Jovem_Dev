package br.com.trier.aula_03.time;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Data;

@Data
public class Time {
	private String nome;
	private List<Jogador> jogadores;
	
	public Time(String nome, List<Jogador> jogadores) {
		this.nome = nome;
		this.jogadores = jogadores;
	}
	
	protected void cadastraTime(Jogador jogadores) {
		nome = JOptionPane.showInputDialog("Nome do time");
		
	}

}
