package view;

import javax.swing.*;
import java.awt.*;

public class PainelCadastroCidade extends JPanel {

    private final JTextField txtCidade;
    private final JButton btnAdicionarCidade;

    public PainelCadastroCidade() {

        setBorder(BorderFactory.createTitledBorder("Cadastro de Cidades"));

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblCidade = new JLabel("Nome:");
        txtCidade = new JTextField(20);
        btnAdicionarCidade = new JButton("Adicionar Cidade");

        add(lblCidade);
        add(txtCidade);
        add(btnAdicionarCidade);
    }

    public JTextField getTxtCidade() {
        return txtCidade;
    }

    public JButton getBtnAdicionarCidade() {
        return btnAdicionarCidade;
    }
}
