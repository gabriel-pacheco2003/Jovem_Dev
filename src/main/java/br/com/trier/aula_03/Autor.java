package br.com.trier.aula_03;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Autor {
	
	private String nome;
	private String sobrenome;
	private String sexo;
	private Integer idade;	
	
	public void cadastra() {
		nome = JOptionPane.showInputDialog("Digite o primeiro nome");
		sobrenome = JOptionPane.showInputDialog("Digite o sobrenome");
		sexo = JOptionPane.showInputDialog("Digite (M) para Masculino ou (F) para Femenino");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do autor"));
		if(!valida()) {
			cadastra();
		}
	}
	private boolean valida() {
		if(nome.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Nome obrigatório");
			return false;
		}
		if(sobrenome.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Sobrenome obrigatório");
			return false;
		}
		if(!(sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F"))) {
			JOptionPane.showMessageDialog(null, "Sexo inválido");
			return false;
		}
		if(idade < 1 || idade > 122) {
			JOptionPane.showMessageDialog(null, "Idade inválida");
			return false;
		}
		
		return true;
	}
	private String retornaSexo() {
		if(sexo.equalsIgnoreCase("M")) {
			return "Masculino";
		} else if(sexo.equalsIgnoreCase("F")) {
			return "Femenino";
		} 
		return null;
	}
	@Override
	public String toString() {
		return nome + " " + sobrenome + " - " + retornaSexo() + " - " + idade + " anos";
	}

}
