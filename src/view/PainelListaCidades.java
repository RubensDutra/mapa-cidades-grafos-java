package view;

import javax.swing.*;
import java.awt.*;

public class PainelListaCidades extends JPanel {

    private JTextArea txtLista;

    public PainelListaCidades() {

        setBorder(BorderFactory.createTitledBorder("Cidades Cadastradas"));

        setLayout(new BorderLayout());

        txtLista = new JTextArea(8,40);

        txtLista.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtLista);

        add(scroll, BorderLayout.CENTER);

    }

    public JTextArea getTxtLista() {
        return txtLista;
    }

}