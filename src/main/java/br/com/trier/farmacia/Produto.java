package br.com.trier.farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Produto {
	
	private String nome;
	protected Integer estoque;
	private Integer valor;

}
