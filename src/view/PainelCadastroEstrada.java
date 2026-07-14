package view;

import javax.swing.*;
import java.awt.*;

public class PainelCadastroEstrada extends  JPanel{

    private final JTextField txtOrigem;
    private final JTextField txtDestino;

    private final JButton btnAdicionarEstrada;

    public PainelCadastroEstrada() {

        setBorder(BorderFactory.createTitledBorder("Cadastro de Estradas"));

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblOrigem = new JLabel("Origem:");
        txtOrigem = new JTextField(20);

        JLabel lblDestino = new JLabel("Destino:");
        txtDestino = new JTextField(20);

        btnAdicionarEstrada = new JButton("Adicionar Estrada");

        add(lblOrigem);
        add(txtOrigem);
        add(lblDestino);
        add(txtDestino);
        add(btnAdicionarEstrada);

    }

    public JTextField getTxtOrigem() {
        return txtOrigem;
    }

    public JTextField getTxtDestino() {
        return txtDestino;
    }

    public JButton getBtnAdicionarEstrada() {
        return btnAdicionarEstrada;
    }

}
