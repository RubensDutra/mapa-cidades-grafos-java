package view;

import javax.swing.*;
import java.awt.*;

public class PainelListaCidades extends JPanel {

    private final JTextArea txtLista;

    public PainelListaCidades() {

        setBorder(BorderFactory.createTitledBorder("Cidades Cadastradas"));
        setLayout(new BorderLayout());

        //Define o tamanho da area de texto
        txtLista = new JTextArea(8,40);

        //Cria barra de rolagem
        txtLista.setEditable(false);

        //Cria barra de rolagem
        JScrollPane scroll = new JScrollPane(txtLista);

        add(scroll, BorderLayout.CENTER);

    }

    public JTextArea getTxtLista() {
        return txtLista;
    }

}