package Ordenacao;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra){
        if(!palavrasUnicasSet.isEmpty()){
            if (palavrasUnicasSet.contains(palavra)){
                palavrasUnicasSet.remove(palavra);
            } else {
                System.out.println("O conjunto está vazio!");
                }
            }
        }

    public boolean verificarPalavra(String palavra){
        return palavrasUnicasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        if(!palavrasUnicasSet.isEmpty()) {
            System.out.println(palavrasUnicasSet);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Ruby");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        conjuntoLinguagens.exibirPalavrasUnicas();

        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        conjuntoLinguagens.removerPalavra("C++");

        System.out.println("A linguagem Java está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
        System.out.println("A linguagem Flutter está no conjunto? " + conjuntoLinguagens.verificarPalavra("Flutter"));


    }
}




