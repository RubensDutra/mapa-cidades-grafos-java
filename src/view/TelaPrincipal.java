package view;
import javax.swing.JFrame;

public class TelaPrincipal {

    private JFrame janela;

    public TelaPrincipal() {

        janela = new JFrame("Mapa de Cidades");

        janela.setSize(900, 600);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setLocationRelativeTo(null);

        janela.setResizable(false);

        janela.setVisible(true);
    }

}
