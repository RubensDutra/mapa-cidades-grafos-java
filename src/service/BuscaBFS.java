package service;

import model.Cidade;
import model.Grafo;

import java.util.*;

public class BuscaBFS {


    public List<Cidade> buscaCaminho(Grafo grafo, String cidadeOrigem, String cidadeDestino) {

        int qntCidades = grafo.getQuantidadeCidades();

        Queue<Integer> fila = new LinkedList<>();

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

        fila.add(indiceOrigem);

        cidadesVisitadas[indiceOrigem] = true;

        pais.put(indiceOrigem, -1);

        boolean destinoEncontrado = false;

        while (!destinoEncontrado && !fila.isEmpty()) {

            int cidadeAtual = fila.remove();

            for (int i = 0; i < qntCidades; i++) {

                if (grafo.existeEstrada(cidadeAtual, i)) {

                    if (!cidadesVisitadas[i]) {

                        cidadesVisitadas[i] = true;
                        fila.add(i);
                        pais.put(i, cidadeAtual);

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

    public void caminho(List<Cidade> cidades) {

    }
}
