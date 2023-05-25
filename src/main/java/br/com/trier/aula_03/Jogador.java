package br.com.trier.aula_03;
import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {

	private String nome;
	private Integer numeroCamisa;
	private Integer golsMarcados;

	public Jogador(String nome, Integer numeroCamisa, Integer golsMarcados) {
		
		this.nome = nome;
		this.numeroCamisa = numeroCamisa;
		this.golsMarcados = golsMarcados;
	}
	
	public Jogador(){}

	protected void cadastraJogadores() {
		nome = JOptionPane.showInputDialog("Nome do jogador");
		numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Número da camisa"));
		golsMarcados = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de gols marcados no campeonato"));
			if(!valida()) {
				cadastraJogadores();
			}

		}
	
		private boolean valida() {
			if(nome.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Nome obrigatório");
				return false;
			}
			if(numeroCamisa < 0 || numeroCamisa > 99) {
				JOptionPane.showMessageDialog(null, "Número de camisa inválido");
				return false;
			}
			if(golsMarcados < 0) {
				JOptionPane.showMessageDialog(null, "Quantidade de gols inválida");
				return false;
			}
			
			return true;
		}

}
