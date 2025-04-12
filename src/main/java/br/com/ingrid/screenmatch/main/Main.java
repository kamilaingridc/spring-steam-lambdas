package br.com.ingrid.screenmatch.main;

import br.com.ingrid.screenmatch.model.DadosEpisodio;
import br.com.ingrid.screenmatch.model.DadosSerie;
import br.com.ingrid.screenmatch.model.DadosTemporada;
import br.com.ingrid.screenmatch.model.Episodio;
import br.com.ingrid.screenmatch.service.ConsumoAPI;
import br.com.ingrid.screenmatch.service.ConverteDados;

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

        System.out.println("\n Top 5 episódios: \n");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios =

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
