package service;

import model.Cidade;
import model.Grafo;

import java.util.List;

public interface Busca {

  List<Cidade> buscaCaminho(Grafo grafo, String cidadeOrigem, String cidadeDestino);

}
