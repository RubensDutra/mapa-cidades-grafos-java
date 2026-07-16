package view;

import exception.CidadeDuplicadaException;
import exception.CidadeInvalidaException;
import exception.CidadeNaoEncontradaException;
import exception.EstradaDuplicadaException;

import model.Grafo;
import model.Cidade;

import service.Busca;
import service.BuscaBFS;
import service.BuscaDFS;

import javax.swing.*;

import java.awt.*;

import java.util.List;

public class TelaPrincipal extends JPanel {

    private JFrame janela;

    private final Grafo grafo;
    private final BuscaBFS buscaBFS;
    private final BuscaDFS buscaDFS;

    private PainelCadastroCidade painelCadastroCidade;
    private PainelCadastroEstrada painelCadastroEstrada;
    private PainelBusca painelBusca;
    private PainelResultado painelResultado;
    private PainelListaCidades painelLista;
    private PainelVisualizacaoGrafo painelVisualizacaoGrafo;

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

        janela = new JFrame("Sistema de Mapeamento de Cidades");

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setSize(1200, 850);

        janela.setLocationRelativeTo(null);

        janela.setResizable(true);

        janela.getRootPane().setBorder(
                BorderFactory.createEmptyBorder(10,10,10,10)
        );


    }

    private void criarComponentes() {

        painelCadastroCidade = new PainelCadastroCidade();

        painelCadastroEstrada = new PainelCadastroEstrada();

        painelBusca = new PainelBusca();

        painelResultado = new PainelResultado();

        painelLista = new PainelListaCidades();

        painelVisualizacaoGrafo = new PainelVisualizacaoGrafo();

    }

    private void organizarTela() {

        janela.setLayout(new BorderLayout(10, 10));

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new GridLayout(3, 1, 5, 5));

        painelSuperior.add(painelCadastroCidade);
        painelSuperior.add(painelCadastroEstrada);
        painelSuperior.add(painelBusca);

        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new GridLayout(1, 2, 10, 10));

        painelInferior.add(painelResultado);
        painelInferior.add(painelLista);

        janela.add(painelSuperior, BorderLayout.NORTH);

        janela.add(painelVisualizacaoGrafo, BorderLayout.CENTER);

        janela.add(painelInferior, BorderLayout.SOUTH);
    }

    // PROMPT 09 parte gerada pela IA
    private void realizarBusca(Busca busca) {

        String cidadeOrigem = painelBusca
                .getTxtOrigem()
                .getText()
                .trim();
        String cidadeDestino = painelBusca
                .getTxtDestino()
                .getText()
                .trim();

        if (cidadeOrigem.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Informe a cidade de origem.");
            return;
        }

        if (cidadeDestino.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Informe a cidade de destino.");
            return;
        }

        if (!grafo.existeCidade(cidadeOrigem)) {
            JOptionPane.showMessageDialog(janela, "A cidade de origem não está cadastrada.");
            return;
        }

        if (!grafo.existeCidade(cidadeDestino)) {
            JOptionPane.showMessageDialog(janela, "A cidade de destino não está cadastrada.");
            return;
        }

        List<Cidade> caminho = busca.buscaCaminho(
                grafo,
                cidadeOrigem,
                cidadeDestino
        );

        mostrarResultado(caminho);

        painelBusca.getTxtOrigem().setText("");
        painelBusca.getTxtDestino().setText("");
        painelBusca.getTxtOrigem().requestFocus();
    }

    private void mostrarResultado(List<Cidade> caminho) {

        JTextArea area = painelResultado.getTxtResultado();

        area.setText("");

        if (caminho.isEmpty()) {
            area.setText("Nenhum caminho encontrado.");
            return;
        }

        area.setText("Caminho encontrado: \n");

        for (int i = 0; i < caminho.size(); i++) {

            area.append(caminho.get(i).getNome());

            if (i < caminho.size() - 1) {
                area.append(" → ");
            }
        }

    }

    private void configurarEventos() {

        // Botão "Adicionar Cidade"
        painelCadastroCidade.getBtnAdicionarCidade().addActionListener(e -> {

            String nomeCidade = painelCadastroCidade
                    .getTxtCidade()
                    .getText()
                    .trim();

            if (nomeCidade.isEmpty()) {
                JOptionPane.showMessageDialog(janela, "Digite o nome da cidade.");
                return;
            }

            Cidade cidade = new Cidade(nomeCidade);

            try {

                grafo.adicionarCidade(cidade);
                atualizarListaCidades();
                painelCadastroCidade.getTxtCidade().setText("");
                painelCadastroCidade.getTxtCidade().requestFocus();

            } catch (CidadeDuplicadaException ex) {
                JOptionPane.showMessageDialog(janela, ex.getMessage());
            }

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
                JOptionPane.showMessageDialog(janela, "Informe a cidade de origem e destino.");
                return;
            }


            try {
                grafo.adicionarEstrada(cidadeOrigem, cidadeDestino);

                JOptionPane.showMessageDialog(janela, "Estrada cadastrada com sucesso!");

                painelCadastroEstrada.getTxtOrigem().setText("");
                painelCadastroEstrada.getTxtDestino().setText("");
                painelCadastroEstrada.getTxtOrigem().requestFocus();

            } catch (CidadeNaoEncontradaException | EstradaDuplicadaException | CidadeInvalidaException ex) {
                JOptionPane.showMessageDialog(janela, ex.getMessage());
            }

        });


        // Botão "Buscar BFS"
        painelBusca.getBtnBuscarBFS().addActionListener(e ->
                realizarBusca(buscaBFS)
        );

        // Botão "Buscar DFS"
        painelBusca.getBtnBuscarDFS().addActionListener(e ->
                realizarBusca(buscaDFS)
        );
    }

    private void atualizarListaCidades() {

        JTextArea area = painelLista.getTxtLista();

        area.setText("");

        for (Cidade cidade : grafo.getCidades()) {

            area.append(cidade.getNome());

            area.append("\n");

        }
    }

    public PainelVisualizacaoGrafo getPainelVisualizacaoGrafo() {
        return painelVisualizacaoGrafo;
    }
}