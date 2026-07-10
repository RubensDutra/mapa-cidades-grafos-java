# Sistema de Mapeamento de Cidades

## Sobre o Projeto

O Sistema de Mapeamento de Cidades é uma aplicação desenvolvida em Java com interface gráfica Swing
que permite cadastrar cidades, cadastrar estradas entre elas e realizar buscas de caminhos utilizando
os algoritmos de grafos **Breadth-First Search (BFS)** e **Depth-First Search (DFS)**.

O projeto foi desenvolvido como Trabalho Final da disciplina de Estruturas de Dados
do curso de Análise e Desenvolvimento de Sistemas.

---

## Objetivos

- Aplicar os conceitos de Grafos.
- Implementar uma matriz de adjacência.
- Desenvolver os algoritmos BFS e DFS.
- Construir uma interface gráfica utilizando Java Swing.
- Organizar o projeto utilizando arquitetura em camadas.

---

## Tecnologias Utilizadas

- Java 21
- Java Swing
- IntelliJ IDEA
- Git
- GitHub

---

## Estrutura do Projeto

```
src
│
├── app
│   └── Main.java
│
├── model
│   ├── Cidade.java
│   └── Grafo.java
│
├── service
│   ├── Busca.java
│   ├── BuscaBFS.java
│   └── BuscaDFS.java
│
└── view
    ├── PainelBusca.java
    ├── PainelCadastroCidade.java
    ├── PainelCadastroEstrada.java
    ├── PainelListaCidades.java
    ├── PainelResultado.java
    └── TelaPrincipal.java
```

---

## Funcionalidades

- Cadastro de cidades.
- Cadastro de estradas.
- Listagem das cidades cadastradas.
- Busca de caminhos utilizando BFS.
- Busca de caminhos utilizando DFS.
- Exibição do caminho encontrado.
- Validação dos dados informados pelo usuário.

---

## Algoritmos Utilizados

### Breadth-First Search (BFS)

A busca em largura percorre o grafo nível por nível, garantindo encontrar o menor caminho em quantidade de arestas.

Estrutura utilizada:

- Queue (Fila)

---

### Depth-First Search (DFS)

A busca em profundidade percorre um caminho até o final antes de retornar para explorar outras possibilidades.

Estrutura utilizada:

- Stack (Pilha)

---

## Interface do Sistema

O sistema possui:

- Cadastro de cidades;
- Cadastro de estradas;
- Área de busca;
- Área de resultados.

*(Imagem da interface
<img width="1125" height="885" alt="image" src="https://github.com/user-attachments/assets/0a02b7e3-396a-448b-98df-275305872869" />
)*

---

## Como Executar

1. Clone o repositório

```bash
git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
```

2. Abra o projeto no IntelliJ IDEA.

3. Execute a classe:

```
Main.java
```

---

## Conceitos Aplicados

- Programação Orientada a Objetos
- Encapsulamento
- Interfaces
- Polimorfismo
- Grafos
- Matriz de Adjacência
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Java Swing
- Arquitetura em Camadas

---

## Melhorias Futuras

- Persistência dos dados em banco de dados.
- Remoção de cidades.
- Remoção de estradas.
- Grafo ponderado.
- Busca pelo menor custo.
- Visualização gráfica do mapa.

---

## Autor

**Rubens Dutra**

Acadêmico de Análise e Desenvolvimento de Sistemas.

GitHub:

https://github.com/RubensDutra