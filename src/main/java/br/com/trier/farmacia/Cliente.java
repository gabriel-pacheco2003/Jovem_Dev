package br.com.trier.farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Cliente {
	
	private String nome;
	private Double saldoDevedor;

}
