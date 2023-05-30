package br.com.trier.teste.disciplina;

import org.junit.jupiter.api.BeforeEach;

import br.com.trier.disciplina.Util;
import br.com.trier.disciplina.NotaDisciplina;
import br.com.trier.disciplina.Disciplina;
import br.com.trier.disciplina.Professor;
import br.com.trier.disciplina.EnumFormacao;
import br.com.trier.disciplina.Aluno;

public class DisciplinaUtilTest {

	private Util ut = new Util();

	@BeforeEach
	void init() {
		
		ut.clearData();
		
		Aluno a1 = new Aluno("Aluno 1");
		Aluno a2 = new Aluno("Aluno 2");
		Aluno a3 = new Aluno("Aluno 3");
		ut.addAluno(a1);
		ut.addAluno(a2);
		ut.addAluno(a3);
		
		Professor p1 = new Professor("Professor 1", EnumFormacao.ESPECIALIZACAO);
		Professor p2 = new Professor("Professor 2", EnumFormacao.GRADUACAO);
		Professor p3 = new Professor("Professor 3", EnumFormacao.POS_GRADUACAO);
		ut.addProfessor(p1);
		ut.addProfessor(p2);
		ut.addProfessor(p3);
		
		Disciplina d1 = new Disciplina("Português" , 8.0, p1);
		Disciplina d2 = new Disciplina("Matemática" , 8.0, p2);
		Disciplina d3 = new Disciplina("Física" , 8.0, p3);
		

	}

}
