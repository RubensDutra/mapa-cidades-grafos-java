package app;

import model.Cidade;
import model.Grafo;
import service.BuscaBFS;
import service.BuscaDFS;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(8);

        Cidade cidade1 = new Cidade("Caxias");
        Cidade cidade2 = new Cidade("Timom");
        Cidade cidade3 = new Cidade("Codó");
        Cidade cidade4 = new Cidade("Teresina");
        Cidade cidade5 = new Cidade("São Luis");
        Cidade cidade6 = new Cidade("Bacabal");
        Cidade cidade7 = new Cidade("Chapadinha");
        Cidade cidade8 = new Cidade("Presidente Dutra");

        grafo.adicionarCidade(cidade1);
        grafo.adicionarCidade(cidade2);
        grafo.adicionarCidade(cidade3);
        grafo.adicionarCidade(cidade4);
        grafo.adicionarCidade(cidade5);
        grafo.adicionarCidade(cidade6);
        grafo.adicionarCidade(cidade7);
        grafo.adicionarCidade(cidade8);

        grafo.adicionarEstrada("Caxias", "Timom");
        grafo.adicionarEstrada("Caxias", "Codó");
        grafo.adicionarEstrada("Codó", "Chapadinha");
        grafo.adicionarEstrada("Chapadinha", "Presidente Dutra");
        grafo.adicionarEstrada("Presidente Dutra", "Teresina");
        grafo.adicionarEstrada("Codó", "Bacabal");
        grafo.adicionarEstrada("Bacabal", "São Luís");


        grafo.imprimirMatriz();

        System.out.println("===== CIDADES =====");
        grafo.listarCidades();
        System.out.println("===================");


        BuscaBFS buscaBFS = new BuscaBFS();

        List<Cidade> listaBFS = buscaBFS.buscaCaminho(grafo, "Caxias", "Teresina");
        listaBFS.forEach(System.out::println);

        System.out.println("===================");

        BuscaDFS buscaDFS = new BuscaDFS();
        List<Cidade> listaDFS = buscaDFS.buscaCaminho(grafo, "Caxias", "Caxias");
        listaDFS.forEach(System.out::println);

    }

}
