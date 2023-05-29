package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Repository {
	
	private List<Professor> dados = new ArrayList<Professor>();
	
	public Professor add (Professor p) {
			p.setId(dados.size()+1);
			dados.add(p);
			return p;
	}

}
