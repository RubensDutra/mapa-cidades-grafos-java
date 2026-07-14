package view;

import javax.swing.*;
import java.awt.*;

public class PainelResultado extends JPanel {

    private JTextArea txtResultado = new JTextArea();

    public PainelResultado() {

        //Cria a borda retangular com o titulo
        setBorder(BorderFactory.createTitledBorder("Resultado da Busca"));

        //Define layout
        setLayout(new BorderLayout());

        //Cria a caixa de texto
        txtResultado = new JTextArea(8, 40);

        //impede que o usuário digite ou apague o resultado da busca
        txtResultado.setEditable(false);

        //Ativa aquebra de linha
        txtResultado.setLineWrap(true);

        //Garante que a quebra de linha respeite as palavras inteiras.
        txtResultado.setWrapStyleWord(true);

        //Adiciona uma margem interna (um "respiro") de 10 pixels nas quatro bordas (Superior, Esquerda, Inferior, Direita).
        txtResultado.setMargin(new Insets(10, 10, 10, 10));

        //Cria um botão de rolar texto
        JScrollPane scroll = new JScrollPane(txtResultado);

        add(scroll, BorderLayout.CENTER);
    }

    public JTextArea getTxtResultado() {
        return txtResultado;
    }

}