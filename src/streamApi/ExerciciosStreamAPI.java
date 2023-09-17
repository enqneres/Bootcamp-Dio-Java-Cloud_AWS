package streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Desafio 1 - Mostre a lista na ordem numérica
        List<Integer> listaOrdenada = numeros.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Desafio 1: " + listaOrdenada);

        //Desafio 2 - Imprima a soma dos números pares da lista
        int somaPares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Desafio 2: " + somaPares);

        //Desafio 3 - Verifique se todos os números da lista são positivos
        boolean todosPositivos = numeros.stream()
                .allMatch(num -> num > 0);
        System.out.println("Desafio 3: " + todosPositivos);

        //Desafio 4 - Remova todos os valores ímpares
        List<Integer> listaSemImpares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Desafio 4: " + listaSemImpares);

        //Desafio 5 - Calcule a média dos números maiores que 5
        double mediaMaioresQue5 = numeros.stream()
                .filter(num -> num > 5)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Desafio 5: " + mediaMaioresQue5);

        //Desafio 6 - Verificar se a lista contém algum número maior que 10
        boolean contemMaiorQue10 = numeros.stream()
                .anyMatch(num -> num > 10);
        System.out.println("Desafio 6: " + contemMaiorQue10);

        //Desafio 7 - Encontrar o segundo número maior da lista
        List<Integer> numerosOrdenados = numeros.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int segundoMaior = numerosOrdenados.size() > 1 ? numerosOrdenados.get(1) : 0;
        System.out.println("Desafio 7: " + segundoMaior);

        //Desafio 8 - Somar os dígitos de todos os números da lista
        int somaDigitos = numeros.stream()
                .map(num -> Math.abs(num))
                .map(num -> Integer.toString(num)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum())
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Desafio 8: " + somaDigitos);

        //Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem)
        boolean todosDistintos = numeros.stream()
                .allMatch(new HashSet<>()::add);
        System.out.println("Desafio 9: " + todosDistintos);

        //Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5
        Map<Boolean, List<Integer>> grupos = numeros.stream()
                .filter(num -> num % 2 != 0 && (num % 3 == 0 || num % 5 == 0))
                .collect(Collectors.partitioningBy(num -> num % 2 != 0));
        System.out.println("Desafio 10: " + grupos);

        //Desafio 11 - Encontre a soma dos quadrados de todos os números da lista
        int somaQuadrados = numeros.stream()
                .mapToInt(num -> num * num)
                .sum();
        System.out.println("Desafio 11: " + somaQuadrados);

        //Desafio 12 - Encontre o produto de todos os números da lista
        int produto = numeros.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Desafio 12: " + produto);

        //Desafio 13 - Filtrar os números que estão dentro de um intervalo
        int limiteInferior = 5;
        int limiteSuperior = 10;
        List<Integer> numerosNoIntervalo = numeros.stream()
                .filter(num -> num >= limiteInferior && num <= limiteSuperior)
                .collect(Collectors.toList());
        System.out.println("Desafio 13: [" + limiteInferior + ", " + limiteSuperior + "]: " + numerosNoIntervalo);

        //Desafio 14 - Encontre o maior número primo da lista
        Optional<Integer> maiorPrimo = numeros.stream()
                .filter(ExerciciosStreamAPI::isPrime)
                .max(Comparator.naturalOrder());
        System.out.println("Desafio 14: " + maiorPrimo.orElse(0));

        //Desafio 15 - Verifique se a lista contém pelo menos um número negativo
        boolean contemNegativo = numeros.stream()
                .anyMatch(num -> num < 0);
        System.out.println("Desafio 15: " + contemNegativo);

        //Desafio 16 - Agrupe os números em pares e ímpares
        Map<Boolean, List<Integer>> paresEImpares = numeros.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.print("Desafio 16: ");
        System.out.print("Pares: " + paresEImpares.get(true));
        System.out.println(" e " + "Impares: " + paresEImpares.get(false));

        //Desafio 17 - Filtrar os números primos da lista
        List<Integer> primos = numeros.stream()
                .filter(ExerciciosStreamAPI::isPrime)
                .collect(Collectors.toList());
        System.out.println("Desafio 17 " + primos);

        //Desafio 18 - Verifique se todos os números da lista são iguais
        boolean todosIguais = numeros.stream()
                .distinct()
                .count() == 1;
        System.out.println("Desafio 18: " + todosIguais);

        //Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5
        int somaDivisiveisPor3e5 = numeros.stream()
                .filter(num -> num % 3 == 0 && num % 5 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Desafio 19: " + somaDivisiveisPor3e5);

    }
    private static boolean isPrime(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }
}


