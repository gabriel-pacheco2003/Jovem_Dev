package br.com.trier.disciplina;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum EnumFormacao {
	
	GRADUACAO("Graduação", 1),
	ESPECIALIZACAO("Especialização", 2),
	POS_GRADUACAO("Pós Graduação", 3);
	
	private String label;
	private int value;
	
}
