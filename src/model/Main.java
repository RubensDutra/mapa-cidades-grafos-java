package model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(3);

        Cidade cidade = new Cidade("Duque");
        Cidade cidade1 = new Cidade("CN");
        Cidade cidade2 = new Cidade("Buriti");


        grafo.adicionarCidade(cidade);
        grafo.adicionarCidade(cidade1);
        grafo.adicionarCidade(cidade2);


        grafo.adicionarEstrada("Duque", "Cn");

        boolean estarda = grafo.existeEstrada("Duque", "A");

        System.out.println("Exixtse?: " + estarda);
        grafo.imprimirMatriz();
    }

}
