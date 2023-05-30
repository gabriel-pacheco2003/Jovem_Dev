package br.com.trier.medicamento;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Medicamento {
	
	private Integer id;
	
	private String nome;
	
	private EnumAdministracao administracao;
	
	private List<String> contraindicacoes;
	
	private List<String> indicacoes;

}
