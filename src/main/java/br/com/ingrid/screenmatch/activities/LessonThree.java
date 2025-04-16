package br.com.ingrid.screenmatch.activities;

public class LessonThree {
//    1 - Dada a lista de números inteiros a seguir, encontre o maior número dela.
//
//    public class Main {
//        public static void main(String[] args) {
//            List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
//
//            // código do agrupamento
//        }
//    }
//    Copiar código
//2 -Dada a lista de palavras (strings) abaixo, agrupe-as pelo seu tamanho. No código a seguir, há um exemplo prático do resultado esperado.
//
//    public class Main {
//        public static void main(String[] args) {
//            List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
//
//            // código do agrupamento
//
//            // Resultado Esperado: {4=[java, code], 6=[stream, lambda]}
//        }
//    }
//    Copiar código
//3 - Dada a lista de nomes abaixo, concatene-os separados por vírgula. No código a seguir, há um exemplo prático do resultado esperado.
//
//    public class Main {
//        public static void main(String[] args) {
//            List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
//            // código do agrupamento de dados
//
//            // Resultado Esperado: "Alice, Bob, Charlie"
//        }
//    }
//    Copiar código
//4 - Dada a lista de números inteiros abaixo, calcule a soma dos quadrados dos números pares.
//
//    public class Main {
//        public static void main(String[] args) {
//            List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
//            // código da filtragem e agrupamento dos dados
//        }
//    }
//    Copiar código
//5 - Dada uma lista de números inteiros, separe os números pares dos ímpares.
//
//    public class Main {
//        public static void main(String[] args) {
//            List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
//            // código do particionamento da lista
//        }
//    }
//    Copiar código
//    Nos próximos exercícios, iremos usar o mesmo código base, dado a seguir:
//
//    Você tem uma lista de objetos do tipo Produto, onde cada produto possui os atributos nome (String), preco (double) e categoria (String). Filtre todos os produtos da categoria "Eletrônicos" com preço menor que R$ 1000, ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista.
//
//    Produto.java
//
//    public class Produto {
//        private String nome;
//        private double preco;
//        private String categoria;
//
//        public Produto(String nome, double preco, String categoria) {
//            this.nome = nome;
//            this.preco = preco;
//            this.categoria = categoria;
//        }
//
//        public String getNome() {
//            return nome;
//        }
//
//        public double getPreco() {
//            return preco;
//        }
//
//        public String getCategoria() {
//            return categoria;
//        }
//
//        @Override
//        public String toString() {
//            return "Produto{" +
//                    "nome='" + nome + '\'' +
//                    ", preco=" + preco +
//                    ", categoria='" + categoria + '\'' +
//                    '}';
//        }
//    }
//    Copiar código
//    Main.java
//
//    public class Main {
//        public static void main(String[] args) {
//            List<Produto> produtos = Arrays.asList(
//                    new Produto("Smartphone", 800.0, "Eletrônicos"),
//                    new Produto("Notebook", 1500.0, "Eletrônicos"),
//                    new Produto("Teclado", 200.0, "Eletrônicos"),
//                    new Produto("Cadeira", 300.0, "Móveis"),
//                    new Produto("Monitor", 900.0, "Eletrônicos"),
//                    new Produto("Mesa", 700.0, "Móveis")
//            );
//
//            // código usando streams
//        }
//    }
//    Copiar código
//6 - Dada a lista de produtos acima, agrupe-os por categoria em um Map<String, List<Produto>>.
//
//            7 - Dada a lista de produtos acima, conte quantos produtos há em cada categoria e armazene em um Map<String, Long>.
//
//8 - Dada a lista de produtos acima, encontre o produto mais caro de cada categoria e armazene o resultado em um Map<String, Optional<Produto>>.
//
//            9 - Dada a lista de produtos acima, calcule o total dos preços dos produtos em cada categoria e armazene o resultado em um Map<String, Double>.
}
