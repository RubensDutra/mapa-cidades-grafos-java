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


        fila.add(indiceOrigem);
        cidadesVisitadas[indiceOrigem] = true;
        pais.put(indiceOrigem, -1);


        return caminho;
    }

}
