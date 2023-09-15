package org.example;

import java.util.Arrays;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
		List<String> nombres = Arrays.asList("alessio", "fernando", "gonzalo", "aduardo", "diego", "manuel");

		// List<String> nombres = new ArrayList<>();
		// nombres.add("alessio");
		// nombres.add("fernando");
		// nombres.add("gonzalo");
		// nombres.add("eduardo");
		// nombres.add("diego");
		// nombres.add("manuel");

		nombres.forEach(System.out::println);
		// nombres.stream().filter(name->name.contains("d")).forEach(System.out::println);

		// String[] names = {"jose", "floromero", "robertina"};
		// List<String> nombres2 = Arrays.asList(names);
		// nombres2.forEach(System.out::println);

		String name = "iniciamos nuevamente con selenium en java por medio de udemy para tcs.";
		String nameInvertido = "";

		// para invertir la palabra
		for (int i = name.length() - 1; i >= 0; i--) {
			nameInvertido += name.charAt(i);
		}

		System.out.println(nameInvertido);
		// String[] textos = name.split(" ");
		List<String> palabras = Arrays.asList(nameInvertido.split(" "));
		// palabras.stream().forEach(System.out::println);
		palabras.stream().forEach(test2::caracteres);
	}

	public static void caracteres(String palabra) {
		List<String> caract = Arrays.asList(palabra.split(""));
		caract.forEach(System.out::print);
	}

}
