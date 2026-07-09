package view;


import model.Grafo;
import model.Cidade;

import service.BuscaBFS;
import service.BuscaDFS;

import javax.swing.*;

import java.awt.GridLayout;

import java.util.List;

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

    public TelaPrincipal(Grafo grafo, BuscaBFS buscaBFS, BuscaDFS buscaDFS) {

        this.grafo = grafo;
        this.buscaBFS = buscaBFS;
        this.buscaDFS = buscaDFS;

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

        // Botão "Adicionar Cidade"
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

            if (grafo.existeCidade(nomeCidade)) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Essa cidade já está cadastrada!"
                );

                return;
            }

            grafo.adicionarCidade(cidade);

            atualizarListaCidades();

            painelCadastroCidade.getTxtCidade().setText("");

            painelCadastroCidade.getTxtCidade().requestFocus();
        });

        // Botão "Adicionar Estrada"
        painelCadastroEstrada.getBtnAdicionarEstrada().addActionListener(e -> {

            String cidadeOrigem = painelCadastroEstrada
                    .getTxtOrigem()
                    .getText()
                    .trim();

            String cidadeDestino = painelCadastroEstrada
                    .getTxtDestino()
                    .getText()
                    .trim();

            if (cidadeOrigem.isEmpty() || cidadeDestino.isEmpty()) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Informe a cidade de origem e destino."
                );

                return;
            }

            if (!grafo.existeCidade(cidadeOrigem)) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Cidade de origem não existe."
                );

                return;
            }

            if (!grafo.existeCidade(cidadeDestino)) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Cidade de destino não existe."
                );

                return;
            }

            if (cidadeOrigem.equalsIgnoreCase(cidadeDestino)) {

                JOptionPane.showMessageDialog(
                        janela,
                        "A cidade de origem deve ser diferente da cidade de destino."
                );

                return;
            }

            if (grafo.existeEstrada(cidadeOrigem, cidadeDestino)) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Essa estrada já está cadastrada."
                );

                return;
            }

            grafo.adicionarEstrada(cidadeOrigem, cidadeDestino);
            JOptionPane.showMessageDialog(janela, "Estrada cadastrada com sucesso!");

            painelCadastroEstrada.getTxtOrigem().setText("");

            painelCadastroEstrada.getTxtDestino().setText("");

            painelCadastroEstrada.getTxtOrigem().requestFocus();


        });

        // Botão "Buscar BFS"
        painelBusca.getBtnBuscarBFS().addActionListener(e -> {

            String cidadeOrigem = painelBusca
                    .getTxtOrigem()
                    .getText()
                    .trim();

            String cidadeDestino = painelBusca
                    .getTxtDestino()
                    .getText()
                    .trim();

            if (cidadeOrigem.isEmpty() || cidadeDestino.isEmpty()) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Informe a cidade de origem e destino."
                );

                return;
            }

            List<Cidade> caminho = buscaBFS.buscaCaminho(
                    grafo,
                    cidadeOrigem,
                    cidadeDestino
            );

            mostrarResultado(caminho);

            painelBusca.getTxtOrigem().setText("");

            painelBusca.getTxtDestino().setText("");

            painelBusca.getTxtOrigem().requestFocus();

        });

        // Botão "Buscar DFS"
        painelBusca.getBtnBuscarDFS().addActionListener(e -> {

            String cidadeOrigem = painelBusca
                    .getTxtOrigem()
                    .getText()
                    .trim();

            String cidadeDestino = painelBusca
                    .getTxtDestino()
                    .getText()
                    .trim();

            if (cidadeOrigem.isEmpty() || cidadeDestino.isEmpty()) {

                JOptionPane.showMessageDialog(
                        janela,
                        "Informe a cidade de origem e destino."
                );

                return;
            }

            List<Cidade> caminho = buscaDFS.buscaCaminho(
                    grafo,
                    cidadeOrigem,
                    cidadeDestino
            );

            mostrarResultado(caminho);

            painelBusca.getTxtOrigem().setText("");

            painelBusca.getTxtDestino().setText("");

            painelBusca.getTxtOrigem().requestFocus();

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

    private void mostrarResultado(List<Cidade> caminho) {

        JTextArea area = painelResultado.getTxtResultado();

        area.setText("");

        if (caminho.isEmpty()) {

            area.setText("Nenhum caminho encontrado.");

            return;
        }


        /*for (Cidade cidade : caminho) {

            area.append(cidade.getNome());

            area.append("\n");

        }*/

        for (int i = 0; i < caminho.size(); i++) {

            area.append(caminho.get(i).getNome());

            if (i < caminho.size() - 1) {
                area.append(" → ");
            }
        }


    }

}