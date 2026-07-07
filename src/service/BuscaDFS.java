package service;

import model.Cidade;
import model.Grafo;

import java.util.*;

public class BuscaDFS {

    public List<Cidade> buscaCaminho(Grafo grafo, String cidadeOrigem, String cidadeDestino) {

        int qntCidades = grafo.getQuantidadeCidades();

        Stack<Integer> pilha = new Stack<>();

        boolean[] cidadesVisitadas = new boolean[qntCidades];

        Map<Integer, Integer> pais = new HashMap<>();

        List<Cidade> caminho = new ArrayList<>();

        int indiceOrigem = grafo.buscarIndiceCidade(cidadeOrigem);

        if (indiceOrigem == -1) {
            return caminho;
        }

        int indiceDestino = grafo.buscarIndiceCidade(cidadeDestino);

        if (indiceDestino == -1) {
            return caminho;
        }

        if (indiceOrigem == indiceDestino) {

            Cidade cidade = grafo.getCidade(indiceOrigem);
            caminho.add(cidade);

            return caminho;
        }


        return caminho;
    }
}
