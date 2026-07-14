package view;

import javax.swing.*;
import java.awt.*;

public class PainelBusca extends JPanel {

    private final JTextField txtOrigem;
    private final JTextField txtDestino;

    private final JButton btnBuscarBFS;
    private final JButton btnBuscarDFS;

    public PainelBusca() {

        //Serve para agrupar visualmente os elementos de busca.
        setBorder(BorderFactory.createTitledBorder("Buscar Caminho"));

        //Serve para alinha os compenetes a esquerda
        setLayout(new FlowLayout(FlowLayout.LEFT));

        //Cria o rotulo de texto
        JLabel lblOrigem = new JLabel("Origem:");

        //Cria a caixa de texto
        txtOrigem = new JTextField(20);

        JLabel lblDestino = new JLabel("Destino:");
        txtDestino = new JTextField(20);

        btnBuscarBFS = new JButton("Buscar BFS");
        btnBuscarDFS = new JButton("Buscar DFS");

        add(lblOrigem);
        add(txtOrigem);
        add(lblDestino);
        add(txtDestino);
        add(btnBuscarBFS);
        add(btnBuscarDFS);

    }

    public JTextField getTxtOrigem() {
        return txtOrigem;
    }

    public JTextField getTxtDestino() {
        return txtDestino;
    }

    public JButton getBtnBuscarBFS() {
        return btnBuscarBFS;
    }

    public JButton getBtnBuscarDFS() {
        return btnBuscarDFS;
    }
}