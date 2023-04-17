package br.com.rmf.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = Arrays.asList("alura online", "casa do código", "caelum");

		palavras.sort(Comparator.comparing(String::length));

		palavras.forEach(System.out::println);
	}
}

class ConsumidorDeString implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);

	}

}

class ComparadorDeStringPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}
