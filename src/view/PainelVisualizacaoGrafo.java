package view;

import model.Grafo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import service.BuscaBFS;
import service.BuscaDFS;

import javax.swing.*;
import java.awt.*;

public class PainelVisualizacaoGrafo extends JPanel {

    private Graph grafoVisual;

    private Viewer viewer;

    private ViewPanel viewPanel;

    public PainelVisualizacaoGrafo() {


        setLayout(new BorderLayout());

        setBorder(BorderFactory.createTitledBorder("Mapa das Cidades"));

        inicializarGraphStream();

    }

    private void inicializarGraphStream() {

        System.setProperty("org.graphstream.ui", "swing");

        grafoVisual = new SingleGraph("Mapa");

        viewer = new SwingViewer(grafoVisual, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);

        viewer.enableAutoLayout();

        viewPanel = (ViewPanel) viewer.addDefaultView(false);

        add(viewPanel, BorderLayout.CENTER);

    }

    public Graph getGrafoVisual() {
        return grafoVisual;
    }

}
