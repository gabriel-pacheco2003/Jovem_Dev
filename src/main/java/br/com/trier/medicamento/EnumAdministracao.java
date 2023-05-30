package br.com.trier.medicamento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumAdministracao {
	
	INJETAVEL("Injetável", 1),
	TOPICO("Tópico", 2),
	ORAL("Oral", 3),
	SUPOSITORIO("Supositório", 4);
	
	private String label;
	private Integer value;
	

}
