package view;

import javax.swing.*;
import java.awt.*;

public class PainelResultado extends JPanel {

    private JTextArea txtResultado = new JTextArea();

    public PainelResultado() {
        setBorder(BorderFactory.createTitledBorder("Resultado da Busca"));

        setLayout(new BorderLayout());

        txtResultado = new JTextArea(8, 40);

        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);
        txtResultado.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(txtResultado);

        add(scroll, BorderLayout.CENTER);
    }

    public JTextArea getTxtResultado() {
        return txtResultado;
    }

}