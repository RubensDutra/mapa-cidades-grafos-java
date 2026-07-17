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
        setBackground(Color.WHITE);
        setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(),
                        "Mapa das Cidades"
                )
        );

        System.setProperty("org.graphstream.ui", "swing");

        grafoVisual = new SingleGraph("Mapa das Cidades");
        grafoVisual.setAttribute(
                "ui.stylesheet",
                """
                graph {
                    fill-color: white;
                    padding: 40px;
                }
        
                node {
                    size: 28px;
                    fill-color: #D6D6D6;
                    stroke-mode: plain;
                    stroke-color: #2C3E50;
                    stroke-width: 2px;
        
                    text-size: 18;
                    text-style: bold;
                    text-color: #2C3E50;
                    text-alignment: above;
                    text-offset: 0, -8;
                }
        
                edge {
                    fill-color: #B0B0B0;
                    size: 3px;
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
        
                edge.caminhoBFS {
                    fill-color: #3498DB;
                    size: 5px;
                }
        
                node.caminhoDFS {
                    fill-color: #27AE60;
                }
        
                edge.caminhoDFS {
                    fill-color: #27AE60;
                    size: 5px;
                }
                """
        );

        viewer = new SwingViewer(
                grafoVisual,
                Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD
        );

        viewer.enableAutoLayout();
        grafoVisual.setAttribute("layout.quality", 4);
        grafoVisual.setAttribute("layout.stabilization-limit", 0.95);

        painelGraphStream = (ViewPanel) viewer.addDefaultView(false);


        add(painelGraphStream, BorderLayout.CENTER);

        add(criarLegenda(), BorderLayout.SOUTH);

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
        destacarCaminho(caminho, "caminhoDFS");
    }
    public void destacarCaminhoBFS(List<Cidade> caminho) {
        destacarCaminho(caminho, "caminhoBFS");
    }

    private void destacarCaminho(List<Cidade> caminho, String classeCSS) {

        limparDestaques();

        if (caminho == null || caminho.isEmpty()) {
            return;
        }

        for (Cidade cidade : caminho) {

            if (grafoVisual.getNode(cidade.getNome()) != null) {

                grafoVisual
                        .getNode(cidade.getNome())
                        .setAttribute("ui.class", classeCSS);
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
                edge.setAttribute("ui.class", classeCSS);
            }
        }

        grafoVisual
                .getNode(caminho.get(0).getNome())
                .setAttribute("ui.class", "origem");

        grafoVisual
                .getNode(caminho.get(caminho.size() - 1).getNome())
                .setAttribute("ui.class", "destino");
    }

    private JPanel criarLegenda() {

        JPanel painelLegenda = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 8));

        painelLegenda.add(criarItemLegenda("●", Color.decode("#2ECC71"), "Origem"));

        painelLegenda.add(criarItemLegenda("●", Color.decode("#E74C3C"), "Destino"));

        painelLegenda.add(criarItemLegenda("●", Color.decode("#3498DB"), "Caminho BFS"));

        painelLegenda.add(criarItemLegenda("●", Color.decode("#27AE60"), "Caminho DFS"));

        return painelLegenda;
    }

    private JPanel criarItemLegenda(String simbolo, Color cor, String texto) {

        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

        JLabel lblSimbolo = new JLabel(simbolo);
        lblSimbolo.setForeground(cor);
        lblSimbolo.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel lblTexto = new JLabel(texto);
        lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        painel.add(lblSimbolo);
        painel.add(lblTexto);

        return painel;
    }
}