package model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private boolean[][] matrizAdjacente;
    private List<Cidade> cidades;

    public Grafo(int capacidade) {
        this.matrizAdjacente = new boolean[capacidade][capacidade];
        this.cidades = new ArrayList<>();
    }

    public void adicionarCidade(Cidade novaCidade) {
        cidades.add(novaCidade);
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public int buscarIndiceCidade(String cidadeProcurada) {

        for (int i = 0; i < cidades.size(); i++) {

            String cidade = cidades.get(i).getNome();

            if (cidade.equalsIgnoreCase(cidadeProcurada)) {
                return i;
            }
        }
        return -1;
    }

    public void imprimirMatriz() {

        for (int i = 0; i < matrizAdjacente.length; i++) {
            for (int j = 0; j < matrizAdjacente[i].length; j++) {
                System.out.print(matrizAdjacente[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void adicionarEstrada(String cidadeOrigem, String cidadeDestino) {

        int origem = buscarIndiceCidade(cidadeOrigem);
        int destino = buscarIndiceCidade(cidadeDestino);

        if (origem != -1 && destino != -1) {
            matrizAdjacente[origem][destino] = true;
            matrizAdjacente[destino][origem] = true;
        }

    }

    public boolean existeEstrada(int cidadeOrigem, int cidadeDestino) {

        int indiceMaximo = (cidades.size() - 1);

        if (cidadeOrigem < 0 || cidadeOrigem > indiceMaximo) {
            return false;
        }

        if (cidadeDestino < 0 || cidadeDestino > indiceMaximo) {
            return false;
        }

        return matrizAdjacente[cidadeOrigem][cidadeDestino];
    }


    public boolean existeEstrada(String cidadeOrigem, String cidadeDestino) {

        int origem = buscarIndiceCidade(cidadeOrigem);
        int destino = buscarIndiceCidade(cidadeDestino);

        return existeEstrada(origem, destino);
    }

    public void listarCidades() {

        if (cidades.isEmpty()) {
            return;
        }

        cidades.forEach(System.out::println);
    }

    public int getQuantidadeCidades() {
        return cidades.size();
    }

    public Cidade getCidade(int indiceCidade) {
        return cidades.get(indiceCidade);
    }

}
