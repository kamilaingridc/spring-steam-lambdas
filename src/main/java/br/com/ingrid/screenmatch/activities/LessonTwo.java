package br.com.ingrid.screenmatch.activities;

import java.util.Arrays;
import java.util.List;

// https://docs.oracle.com/javase/8/docs/api/?java/util/stream/Stream.html

public class LessonTwo {
    public static void main(String[] args) {
        // 1 - Dada a lista de números inteiros abaixo, filtre apenas os números pares e imprima-os.
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(numero -> numero %2 == 0)
                .forEach(System.out::println);

        // 2 - Dada a lista de strings abaixo, converta todas para letras maiúsculas e imprima-as.
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 3 - Dada a lista de números inteiros abaixo, filtre os números ímpares, multiplique cada um por 2 e colete os resultados em uma nova lista.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // 4 - Dada a lista de strings abaixo, remova as duplicatas (palavras que aparecem mais de uma vez) e imprima o resultado.
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana");

        // 5 - Dada a lista de sublistas de números inteiros abaixo, extraia todos os números primos em uma única lista e os ordene em ordem crescente.
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        // 6 - Dado um objeto Pessoa com os campos nome e idade, filtre as pessoas com mais de 18 anos, extraia os nomes e imprima-os em ordem alfabética. A classe Pessoa está definida abaixo.
        class Pessoa {
            String nome;
            int idade;

            Pessoa(String nome, int idade) {
                this.nome = nome;
                this.idade = idade;
            }

            public String getNome() {
                return nome;
            }

            public int getIdade() {
                return idade;
            }
        }

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );

        // 7 - Você tem uma lista de objetos do tipo Produto, onde cada produto possui os atributos nome (String), preco (double) e categoria (String). Filtre todos os produtos da categoria "Eletrônicos" com preço menor que R$ 1000, ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista.
        class Produto {
            private String nome;
            private double preco;
            private String categoria;

            public Produto(String nome, double preco, String categoria) {
                this.nome = nome;
                this.preco = preco;
                this.categoria = categoria;
            }

            public String getNome() {
                return nome;
            }

            public double getPreco() {
                return preco;
            }

            public String getCategoria() {
                return categoria;
            }

            @Override
            public String toString() {
                return "Produto{" +
                        "nome='" + nome + '\'' +
                        ", preco=" + preco +
                        ", categoria='" + categoria + '\'' +
                        '}';
            }
        }

        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        // 8 - Tomando o mesmo código do exercício anterior como base, modifique o código para que a saída mostre apenas os três produtos mais baratos da categoria "Eletrônicos".
    }

}
