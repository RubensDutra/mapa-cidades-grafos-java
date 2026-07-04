package model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private boolean[][] matrizAdjacente;
    private List<Cidade> cidades;

    public Grafo() {
        this.matrizAdjacente = new boolean[3][3];
        this.cidades = new ArrayList<>();
    }

    public void adicionarCidade(Cidade novaCidade) {
        cidades.add(novaCidade);
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
}
