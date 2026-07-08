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

        pilha.push(indiceOrigem);
        cidadesVisitadas[indiceOrigem] = true;
        pais.put(indiceOrigem, -1);

        boolean destinoEncontrado = false;

        while (!destinoEncontrado && !pilha.isEmpty()) {

            int cidadeAtual = pilha.pop();

            for (int i = 0; i < qntCidades; i++) {

                if (grafo.existeEstrada(cidadeAtual, i)) {

                    if (!cidadesVisitadas[i]) {

                        cidadesVisitadas[i] = true;

                        pais.put(i, cidadeAtual);

                        pilha.push(i);


                        if (i == indiceDestino) {
                            destinoEncontrado = true;
                        }
                    }
                }
            }
        }

        if (!destinoEncontrado) {
            return caminho;
        }

        int cidade = indiceDestino;

        while (cidade != -1) {

            Cidade cidadeEncontrada = grafo.getCidade(cidade);

            caminho.add(cidadeEncontrada);

            cidade = pais.get(cidade);

        }

        Collections.reverse(caminho);

        return caminho;
    }
}
