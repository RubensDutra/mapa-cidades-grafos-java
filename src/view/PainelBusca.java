package view;

import javax.swing.*;
import java.awt.*;

public class PainelBusca extends JPanel {

    private JLabel lblOrigem;
    private JLabel lblDestino;

    private JTextField txtOrigem;
    private JTextField txtDestino;

    private JButton btnBuscarBFS;
    private JButton btnBuscarDFS;

    public PainelBusca() {

        setBorder(BorderFactory.createTitledBorder("Buscar Caminho"));

        setLayout(new FlowLayout(FlowLayout.LEFT));

        lblOrigem = new JLabel("Origem:");

        txtOrigem = new JTextField(15);

        lblDestino = new JLabel("Destino:");

        txtDestino = new JTextField(15);

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