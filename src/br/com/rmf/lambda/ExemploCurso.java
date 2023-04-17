package br.com.rmf.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
}

public class ExemploCurso {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));

		cursos.removeIf(t -> t.getAlunos() < 50);

		cursos.forEach(t -> t.setAlunos(t.getAlunos() + 1));

		cursos.forEach(c -> System.out.println(c.getNome() + " --> " + c.getAlunos()));

		cursos.stream().mapToInt(value -> value.getAlunos()).average().ifPresent(System.out::println);

		List<String> names = cursos.stream().map(t -> t.getNome().toUpperCase()).collect(Collectors.toList());

		names.forEach(System.out::println);

	}
}

class aumentaConsumer implements Consumer<Curso> {

	@Override
	public void accept(Curso t) {
		t.setAlunos(t.getAlunos() + 1);

	}

}

class RemoveListaPredicate implements Predicate<Curso> {

	@Override
	public boolean test(Curso t) {
		return t.getAlunos() < 50;
	}

}

class UpperCaseFuction implements Function<Curso, String> {

	@Override
	public String apply(Curso t) {
		return t.getNome().toUpperCase();
	}

}

class ToInt implements ToIntFunction<Curso> {

	@Override
	public int applyAsInt(Curso value) {
		return value.getAlunos();
	}
}

