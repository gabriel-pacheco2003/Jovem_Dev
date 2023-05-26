package br.com.trier.aula_03;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Autor {
	
	private String nomeCompleto;
	private String sexo;
	private Integer idade;	
	
	public void cadastra() {
		nomeCompleto = JOptionPane.showInputDialog("Digite o nome completo").toUpperCase();
		sexo = JOptionPane.showInputDialog("Digite (M) para Masculino ou (F) para Feminino");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do autor"));
		if(!valida()) {
			cadastra();
		}
	}
	
	private boolean valida() {
		if(nomeCompleto.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Nome obrigatório");
			return false;
		}
		
		if(!(sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F"))) {
			JOptionPane.showMessageDialog(null, "Sexo inválido");
			return false;
		}
		
		if(idade < 1 || idade > 122 ) {
			JOptionPane.showMessageDialog(null, "Idade inválida");
			return false;
		}
		
		return true;
	}
	
	private String retornaSexo() {
		if(sexo.equalsIgnoreCase("M")) {
			return "Masculino";
		} else if(sexo.equalsIgnoreCase("F")) {
			return "Feminino";
		} 
		return null;
	}
	
	@Override
	public String toString() {
		return nomeCompleto + " - " + retornaSexo() + " - " + idade + " anos\n";
	}

}
