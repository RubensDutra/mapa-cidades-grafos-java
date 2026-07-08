package view;


import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JPanel {

    private JFrame janela;

    private PainelCadastroCidade painelCadastroCidade;
    private PainelCadastroEstrada painelCadastroEstrada;
    private PainelBusca painelBusca;
    private PainelResultado painelResultado;
    private PainelListaCidades painelLista;

    public TelaPrincipal() {

        configurarJanela();

        criarComponentes();

        organizarTela();

        janela.setVisible(true);

    }

    private void configurarJanela() {

        janela = new JFrame("Mapa de Cidades");

        janela.setSize(900,700);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setLocationRelativeTo(null);

    }

    private void criarComponentes() {

        painelCadastroCidade = new PainelCadastroCidade();

        painelCadastroEstrada = new PainelCadastroEstrada();

        painelBusca = new PainelBusca();

        painelResultado = new PainelResultado();

        painelLista = new PainelListaCidades();

    }

    private void organizarTela() {

        janela.setLayout(new GridLayout(5,1));

        janela.add(painelCadastroCidade);

        janela.add(painelCadastroEstrada);

        janela.add(painelBusca);

        janela.add(painelResultado);

        janela.add(painelLista);

    }

}