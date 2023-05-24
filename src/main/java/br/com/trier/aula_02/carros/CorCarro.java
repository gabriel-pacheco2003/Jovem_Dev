package br.com.trier.aula_02.carros;

public enum CorCarro {
	VERMELHO("Vermelho", 0),
	PRETO("Preto", 1),
	BRANCO("Branco", 2),
	PRATA("Prata", 3),
	OUTRO("Outro", 4);
	
	private String label;
	private int value;
	
	private CorCarro(String label, int value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}	
	
}
