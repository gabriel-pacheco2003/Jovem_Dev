package br.com.trier.aula_02.carros;

import javax.swing.JOptionPane;

public class Carro {
	String marca;
	Integer ano;
	CorCarro cor;
	
	public Carro(String marca, Integer ano, CorCarro cor) {

		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
	}

	public Carro() {}

	void cadastrar() {
		marca = JOptionPane.showInputDialog("Informe a marca do carro").toUpperCase();
		ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do carro"));
		
		boolean repeticao = true;
		
		while(repeticao) {
			String corString = JOptionPane.showInputDialog("Informe a cor do carro\n" + "1 - Vermelho\n" + "2 - Preto\n" + "3 - Branco\n" + "4 - Prata\n" + "5 - Outro");
		
			switch(corString) {
			
			case "1":
				cor = CorCarro.VERMELHO;
				repeticao = false;
				break;
				
			case "2":
				cor = CorCarro.PRETO;
				repeticao = false;
				break;
				
			case "3":
				cor = CorCarro.BRANCO;
				repeticao = false;
				break;
			
			case "4":
				cor  = CorCarro.PRATA;
				repeticao = false;
				break;
		
			case "5":
				cor = CorCarro.OUTRO;
				repeticao = false;
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
				
			}
		}
	}
	
	String imprimir() {
		return "Marca: " + marca + "\nCor: " + cor.getLabel() + "\nAno:	" + ano + " \n\n ";
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public CorCarro getCor() {
		return cor;
	}

	public void setCor(CorCarro cor) {
		this.cor = cor;
	}

}
