package br.com.trier.exemploPolimorfismo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter 
public class Forma {
	
	private String nome;
	
	public String desenhar() {
		return "Desenhando um " + getNome();
	}

}
