package view;

import javax.swing.*;
import java.awt.*;

public class PainelResultado extends JPanel {

    private JTextArea txtResultado;

    public PainelResultado() {

        setBorder(BorderFactory.createTitledBorder("Resultado"));

        setLayout(new BorderLayout());

        txtResultado = new JTextArea(8,40);

        txtResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtResultado);

        add(scroll, BorderLayout.CENTER);

    }

    public JTextArea getTxtResultado() {
        return txtResultado;
    }

}