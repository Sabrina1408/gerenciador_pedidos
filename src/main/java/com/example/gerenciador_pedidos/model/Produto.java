package com.example.gerenciador_pedidos.model;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "valor")
    private double preco;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public Produto() {
    }

    /**
     * Construtor para Produto sem categoria.
     */
    public Produto(String nome, double preco, Fornecedor fornecedor) {
        this(nome, preco, null, fornecedor);
    }

    public Produto(String nome, double preco, Categoria categoria, Fornecedor fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
      return categoria;
    }

    public void setCategoria(Categoria categoria) {
      this.categoria = categoria;
    }

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

    /**
     * Cria um produto com nome, preço e fornecedor.
     * @param nome Nome do produto
     * @param preco Preço do produto
     * @param fornecedor Fornecedor do produto
     * @return Produto criado
     */
    public static Produto criarProduto(String nome, double preco, Fornecedor fornecedor) {
        return new Produto(nome, preco, null, fornecedor);
    }
}
