package br.com.ingrid.screenmatch.main;

import br.com.ingrid.screenmatch.model.DadosEpisodio;
import br.com.ingrid.screenmatch.model.DadosSerie;
import br.com.ingrid.screenmatch.model.DadosTemporada;
import br.com.ingrid.screenmatch.model.Episodio;
import br.com.ingrid.screenmatch.service.ConsumoAPI;
import br.com.ingrid.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO="https://www.omdbapi.com/?t=";
    private final String API_KEY="&apikey=3461c496";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca: ");
        var nomeSerie = leitura.nextLine();

        var json = consumoAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i<=dados.totalTemporadas(); i++) {
			json = consumoAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()) // puxar todas listas juntas (episodios)
                .collect(Collectors.toList());  // joga em uma lista
                // .toList();  // resulta uma lista imutável (não consegue alterar)

        System.out.println("\n Top 10 episódios: \n");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primeiro filtro (N/A) "))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .peek(e -> System.out.println("Ordenação "))
                .limit(10)
                .peek(e -> System.out.println("Limite "))
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("Mapeamento "))
                .forEach(System.out::println);

//        List<Episodio> episodios = temporadas.stream()
//                .flatMap(t -> t.episodios().stream()
//                        .map(d -> new Episodio(t.numero(), d))
//                ).collect(Collectors.toList());
//
//        episodios.forEach(System.out::println);
//
//        System.out.println("A partir de que ano deseja ver os episódios?");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter( e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                "Episódio: " + e.getTitulo() +
//                                "Data Lançamento: " + e.getDataLancamento().format(formatador)
//                ));

//        for (int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }


//        List<String> nomes = Arrays.asList("Marcela", "Laura", "Vanessa", "Ingrid", "Teste");
//
//        nomes.stream()  // pode-se criar tudo em uma linha só
//                .sorted()  // ordena alfabeticamente
//                .limit(3) // vai pegar a lista de nomes com os três primeiros
//                .filter(n -> n.startsWith("M")) // filtra os nomes começa com M
//                .map(n -> n.toUpperCase()) // coloca como letra maiúscula
//                .forEachOrdered(System.out::println);  // printa depois de todas exigencias
    }
}
