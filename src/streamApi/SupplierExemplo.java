package streamApi;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExemplo {
    public static void main(String[] args) {
        Supplier<String> saudacao = () -> "Olá, bem vindo!";

        List<String> listaSaudacoes = Stream.generate(saudacao).limit(5).collect(Collectors.toList());

        listaSaudacoes.forEach(s -> System.out.println(s));
    }
}
