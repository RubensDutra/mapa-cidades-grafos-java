package view;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import model.Cidade;
import org.graphstream.graph.Edge;

import java.util.List;

import javax.swing.*;
import java.awt.*;

public class PainelVisualizacaoGrafo extends JPanel {

    private final Graph grafoVisual;

    private final Viewer viewer;

    private final ViewPanel painelGraphStream;

    public PainelVisualizacaoGrafo() {

        setLayout(new BorderLayout());

        setBorder(BorderFactory.createTitledBorder("Visualização do Grafo"));

        System.setProperty("org.graphstream.ui", "swing");

        grafoVisual = new SingleGraph("Mapa das Cidades");
        grafoVisual.setAttribute(
                "ui.stylesheet",
                """
                node {
                    size: 20px;
                    fill-color: #D6D6D6;
                    stroke-mode: plain;
                    stroke-color: black;
                    stroke-width: 1px;
                    text-size: 16;
                    text-alignment: above;
                    text-style: bold;
                }
            
                node.origem {
                    fill-color: #2ECC71;
                }
            
                node.destino {
                    fill-color: #E74C3C;
                }
            
                node.caminhoBFS {
                    fill-color: #3498DB;
                }
            
                node.caminhoDFS {
                    fill-color: #27AE60;
                }
            
                edge {
                    fill-color: #808080;
                    size: 2px;
                }
            
                edge.caminhoBFS {
                    fill-color: #3498DB;
                    size: 4px;
                }
            
                edge.caminhoDFS {
                    fill-color: #27AE60;
                    size: 4px;
                }
                """
        );

        viewer = new SwingViewer(
                grafoVisual,
                Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD
        );

        viewer.enableAutoLayout();

        painelGraphStream = (ViewPanel) viewer.addDefaultView(false);

        add(painelGraphStream, BorderLayout.CENTER);


    }

    public Graph getGrafoVisual() {
        return grafoVisual;
    }

    public void adicionarCidade(String nomeCidade) {

        if (grafoVisual.getNode(nomeCidade) != null) {
            return;
        }

        Node cidade = grafoVisual.addNode(nomeCidade);

        cidade.setAttribute("ui.label", nomeCidade);

    }

    public void adicionarEstrada(String cidadeOrigem, String cidadeDestino) {

        String idEstrada = cidadeOrigem + "-" + cidadeDestino;

        String idEstradaInvertida = cidadeDestino + "-" + cidadeOrigem;

        if (grafoVisual.getEdge(idEstrada) != null ||
                grafoVisual.getEdge(idEstradaInvertida) != null) {
            return;
        }

        Edge estrada = grafoVisual.addEdge(
                idEstrada,
                cidadeOrigem,
                cidadeDestino
        );

        estrada.setAttribute("ui.label", "");

    }

    public void limparDestaques() {

        // Limpa todos os vértices
        grafoVisual.nodes().forEach(node -> {
            node.removeAttribute("ui.class");
        });

        // Limpa todas as arestas
        grafoVisual.edges().forEach(edge -> {
            edge.removeAttribute("ui.class");
        });

    }

    public void destacarOrigemDestino(String origem, String destino) {

        limparDestaques();


        if (grafoVisual.getNode(origem) != null) {
            grafoVisual
                    .getNode(origem)
                    .setAttribute("ui.class", "origem");
        }

        if (grafoVisual.getNode(destino) != null) {
            grafoVisual
                    .getNode(destino)
                    .setAttribute("ui.class", "destino");
        }

    }

    public void destacarCaminhoDFS(List<Cidade> caminho) {

        limparDestaques();

        if (caminho == null || caminho.isEmpty()) {
            return;
        }

        for (Cidade cidade : caminho) {

            if (grafoVisual.getNode(cidade.getNome()) != null) {

                grafoVisual
                        .getNode(cidade.getNome())
                        .setAttribute("ui.class", "caminhoDFS");
            }
        }

        for (int i = 0; i < caminho.size() - 1; i++) {

            String origem = caminho.get(i).getNome();
            String destino = caminho.get(i + 1).getNome();

            Edge edge = grafoVisual.getEdge(origem + "-" + destino);

            if (edge == null) {
                edge = grafoVisual.getEdge(destino + "-" + origem);
            }

            if (edge != null) {
                edge.setAttribute("ui.class", "caminhoDFS");
            }
        }

        grafoVisual
                .getNode(caminho.get(0).getNome())
                .setAttribute("ui.class", "origem");

        grafoVisual
                .getNode(caminho.get(caminho.size() - 1).getNome())
                .setAttribute("ui.class", "destino");
    }

    public void destacarCaminhoBFS(List<Cidade> caminho) {

        limparDestaques();

        if (caminho == null || caminho.isEmpty()) {
            return;
        }

        for (Cidade cidade : caminho) {

            if (grafoVisual.getNode(cidade.getNome()) != null) {

                grafoVisual
                        .getNode(cidade.getNome())
                        .setAttribute("ui.class", "caminhoBFS");
            }
        }

        for (int i = 0; i < caminho.size() - 1; i++) {

            String origem = caminho.get(i).getNome();
            String destino = caminho.get(i + 1).getNome();

            Edge edge = grafoVisual.getEdge(origem + "-" + destino);

            if (edge == null) {
                edge = grafoVisual.getEdge(destino + "-" + origem);
            }

            if (edge != null) {
                edge.setAttribute("ui.class", "caminhoBFS");
            }
        }

        grafoVisual
                .getNode(caminho.get(0).getNome())
                .setAttribute("ui.class", "origem");

        grafoVisual
                .getNode(caminho.get(caminho.size() - 1).getNome())
                .setAttribute("ui.class", "destino");

    }
}