package app;


import model.Grafo;
import service.BuscaBFS;
import service.BuscaDFS;
import view.TelaPrincipal;


public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(7);

        BuscaBFS buscaBFS = new BuscaBFS();
        BuscaDFS buscaDFS = new BuscaDFS();

        new TelaPrincipal(grafo, buscaBFS, buscaDFS);

    }

}

