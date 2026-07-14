package service;

import model.Cidade;
import model.Grafo;

import java.util.*;

public class BuscaDFS implements Busca {

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
        pais.put(indiceOrigem, -1);

        boolean destinoEncontrado = false;

        // PROMPT 04 parte gerada pela IA
        while (!pilha.isEmpty()) {

            int cidadeAtual = pilha.pop();

            if (cidadesVisitadas[cidadeAtual]) {
                continue;
            }
            cidadesVisitadas[cidadeAtual] = true;

            if (cidadeAtual == indiceDestino) {
                destinoEncontrado = true;
                break;
            }

            for (int i = qntCidades - 1; i >= 0; i--) {
                if (grafo.existeEstrada(cidadeAtual, i)) {
                    if (!cidadesVisitadas[i]) {
                        pais.put(i, cidadeAtual);
                        pilha.push(i);
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
