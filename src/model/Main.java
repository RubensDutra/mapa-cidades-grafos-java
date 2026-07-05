package model;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Cidade cidade = new Cidade("Duque");
        Cidade cidade1 = new Cidade("Coelho neto");
        Cidade cidade2 = new Cidade("Buriti");
        Cidade cidade3 = new Cidade("Carro");
        Cidade cidade4 = new Cidade("Bosta");


        Grafo grafo = new Grafo();
        grafo.listarCidades();

        grafo.adicionarCidade(cidade);
        grafo.adicionarCidade(cidade1);
        grafo.adicionarCidade(cidade2);
        grafo.adicionarCidade(cidade3);
        grafo.adicionarCidade(cidade4);


       int cidade122 = grafo.buscarIndiceCidade("Duque");

        System.out.println(cidade122);

        grafo.listarCidades();
    }
}
