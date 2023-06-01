package br.com.trier.farmacia;

public class Medicamento extends Produto {
	
	private boolean reterReceitaMedica;// informar quando preciso se é true or false

	public Medicamento(String nome, Integer estoque, Integer valor, boolean reterReceitaMedica) {
		super(nome, estoque, valor);
		this.reterReceitaMedica = reterReceitaMedica;
	}
	
	public void venderMedicamento(Integer qtdRequerida) {
		if(estoque >= qtdRequerida ){
			estoque -= qtdRequerida;	
		}
	}
}
