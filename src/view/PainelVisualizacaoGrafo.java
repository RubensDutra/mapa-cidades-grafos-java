package view;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

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

}