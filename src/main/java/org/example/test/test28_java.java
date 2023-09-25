package org.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test28_java {

    @Test
    public void test() {

        List<String> names = new ArrayList<>();
        names.add("Diego");
        names.add("Manuel");
        names.add("Micaela");
        names.add("Alessio");
        names.add("Elizeth");
        names.add("Anthonella");
        names.add("Francis");
        names.add("Maria");

        // me retorna los nombres que inician con la letra A
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
        long cantidad = names.stream().filter(name -> name.startsWith("A")).count();

        System.out.println("SI Inician con la A: Pasaron " + cantidad + " nombre(s).\n");

        // me retorna los nombres que no retornan con la letra A
        names.stream().filter(name -> !name.startsWith("A")).forEach(System.out::println);
        long cantidad2 = names.stream().filter(name -> !name.startsWith("A")).count();
        System.out.println("NO Inician con la A: Pasaron " + cantidad2 + " nombre(s).\n");

        // me retorna los nombres que terminan con la letra a
        names.stream().filter(name -> name.endsWith("a")).forEach(System.out::println);
        long cantidad3 = names.stream().filter(name -> name.endsWith("a")).count();

        System.out.println("Terminan con la a: Pasaron " + cantidad3 + " nombre(s).\n");

        System.out.println("Nombres que tienen mas de 6 letras:");
        names.stream().filter(name -> name.length() > 6).forEach(System.out::println);
        System.out.println();
        System.out.println("Nombres que tienen mas de 6 letras, maximo 2:");
        names.stream().filter(name -> name.length() > 6).limit(2).forEach(System.out::println);

    }

    @Test
    public void test2() {
        Stream.of("Alessio", "Francis", "Diego", "Margaret", 45, true, 34.56, 2f)
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(n -> n % 2 == 0).forEach(System.out::println);

    }

    @Test
    public void test3() {
        Stream.of("Alessio", "Francis", "Diego", "Margaret", "Maria", "Anthonella").filter(n -> n.endsWith("a"))
                .map(n -> n.toUpperCase()).forEach(System.out::println);

        List<String> nombres = Arrays.asList("Alessio", "Francis", "Diego", "Margaret", "Maria", "Anthonella");
        nombres.stream().sorted().map(n -> n.toUpperCase()).forEach(System.out::println);

        List<String> apellidos = Arrays.asList("Gutierrez", "Rojas", "Gutierrez2", "Gutierrez3", "Castro",
                "Gutierrez4");
        System.out.println();
        Stream<String> nombreCompleto = Stream.concat(nombres.stream(), apellidos.stream());
        nombreCompleto.forEach(System.out::println);

        boolean validacion = Stream.concat(nombres.stream(), apellidos.stream())
                .anyMatch(n -> n.equalsIgnoreCase("Diego"));
        System.out.println(validacion);
        Assert.assertTrue(validacion);

    }

    @Test
    public void test4() {
        List<String> names = Stream.of("Elizeth", "Yaqueli", "Rojas", "Delgado", "Eduardo")
                .filter(name -> name.endsWith("o"))
                .map(name -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println(names.get(0));
        names.forEach(System.out::println);
    }

    @Test
    public void test5() {
        List<Integer> numeros = Arrays.asList(2, 5, 8, 3, 1, 3, 5, 8, 6, 4, 3, 7, 9, 6, 4, 3, 7, 9, 2, 8);
        // ordena solo los elementos que no se repiten
        numeros.stream().distinct().sorted().collect(Collectors.toList()).forEach(System.out::print);
    }

}
