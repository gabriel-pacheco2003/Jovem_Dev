package formas;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Poligono extends Forma{
	protected int lados;

	public Poligono(String nome, int lados) {
		super(nome);
		this.lados = lados;
	}
	@Override
	public String toString() {
		return super.toString()+ " tenho " + getLados() + " Lados";
	}
}
