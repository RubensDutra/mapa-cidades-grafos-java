package view;


import model.Grafo;
import model.Cidade;

import service.BuscaBFS;
import service.BuscaDFS;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JPanel {

    private JFrame janela;

    private Grafo grafo;
    private BuscaBFS buscaBFS;
    private BuscaDFS buscaDFS;

    private PainelCadastroCidade painelCadastroCidade;
    private PainelCadastroEstrada painelCadastroEstrada;
    private PainelBusca painelBusca;
    private PainelResultado painelResultado;
    private PainelListaCidades painelLista;

    public TelaPrincipal() {

        configurarJanela();

        criarComponentes();

        organizarTela();

        configurarEventos();

        janela.setVisible(true);

    }

    private void configurarJanela() {

        janela = new JFrame("Mapa de Cidades");

        janela.setSize(900, 700);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setLocationRelativeTo(null);

    }

    private void criarComponentes() {

        grafo = new Grafo(4);

        painelCadastroCidade = new PainelCadastroCidade();
        painelCadastroEstrada = new PainelCadastroEstrada();
        painelBusca = new PainelBusca();
        painelResultado = new PainelResultado();
        painelLista = new PainelListaCidades();

    }

    private void organizarTela() {

        janela.setLayout(new GridLayout(5, 1));

        janela.add(painelCadastroCidade);

        janela.add(painelCadastroEstrada);

        janela.add(painelBusca);

        janela.add(painelResultado);

        janela.add(painelLista);

    }

    private void configurarEventos() {

        painelCadastroCidade.getBtnAdicionarCidade().addActionListener(e -> {

            String nomeCidade = painelCadastroCidade
                    .getTxtCidade()
                    .getText()
                    .trim();

            if (nomeCidade.isEmpty()) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Digite o nome da cidade."
                );

                return;
            }

            Cidade cidade = new Cidade(nomeCidade);

            grafo.adicionarCidade(cidade);

            atualizarListaCidades();

            painelCadastroCidade.getTxtCidade().setText("");

        });

    }

    private void atualizarListaCidades() {

        JTextArea area = painelLista.getTxtLista();

        area.setText("");

        for (Cidade cidade : grafo.getCidades()) {

            area.append(cidade.getNome());

            area.append("\n");

        }

    }

}