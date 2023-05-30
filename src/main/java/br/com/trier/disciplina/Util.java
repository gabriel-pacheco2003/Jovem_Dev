package br.com.trier.disciplina;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Util {

	private List<Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<NotaDisciplina> notasDisciplinas = new ArrayList<NotaDisciplina>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public Professor addProfessor(Professor p) {
		p.setId(professores.size() + 1);
		professores.add(p);
		return p;
	}
	
	public Aluno addAluno(Aluno a) {
		a.setId(alunos.size() + 1);
		alunos.add(a);
		return a;
	}
	
	public Aluno findAlunoById(final Integer id) {
		return alunos.stream().filter(a -> id.equals(a.getId())).findAny().orElse(null);
	}

	public Professor findProfessorById(final Integer id) {
		return professores.stream().filter(p -> id.equals(p.getId())).findAny().orElse(null);
	}
	
	public Disciplina findDisciplinaById(final Integer id) {
		return disciplinas.stream().filter(d -> id.equals(d.getId())).findAny().orElse(null);
	}

	private void addNota(Double nota, Disciplina disciplina, Aluno aluno) {
		NotaDisciplina notasDis = getNotasDisciplinaFrom(disciplina, aluno);
		for (int i = 0; i < notasDis.getNotas().length; i++) {
			if (Objects.isNull(Array.get(notasDis.getNotas(), i))) {
				notasDis.getNotas()[i] = nota;
				return;
			}
		}
		throw new IllegalArgumentException("Notas já preenchidas");
	}

	private NotaDisciplina getNotasDisciplinaFrom(Disciplina disciplina, Aluno aluno) {
		Optional<NotaDisciplina> notaDisciplina = aluno.getNotasDisciplina().stream()
				.filter(nd -> nd.getDisciplina().equals(disciplina)).findAny();
		if (!notaDisciplina.isPresent()) {
			throw new IllegalArgumentException("Disciplina não encrontrada para o aluno " + aluno.getNome());
		}
		return notaDisciplina.get();
	}

	private Double[] getNotasFromAluno(Aluno aluno, Disciplina disciplina) {
		return getNotasDisciplinaFrom(disciplina, aluno).getNotas();
	}

	private List<Disciplina> getDisciplinaByProfPosGraduacao() {
		return this.disciplinas.stream()
				.filter(disc -> disc.getProfessor().getFormacao().equals(EnumFormacao.POS_GRADUACAO))
				.collect(Collectors.toList());
	}
	
	public void clearData() {
		alunos.clear();
		disciplinas.clear();
		professores.clear();
	}
}
