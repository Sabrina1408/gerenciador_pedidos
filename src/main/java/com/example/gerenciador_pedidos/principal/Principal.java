// java
package com.example.gerenciador_pedidos.principal;

import com.example.gerenciador_pedidos.model.Fornecedor;
import com.example.gerenciador_pedidos.repository.FornecedorRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.gerenciador_pedidos.model.Categoria;
import com.example.gerenciador_pedidos.model.Pedido;
import com.example.gerenciador_pedidos.model.Produto;
import com.example.gerenciador_pedidos.repository.CategoriaRepository;
import com.example.gerenciador_pedidos.repository.PedidoRepository;
import com.example.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;

@Component
public class Principal implements CommandLineRunner {
    private final CategoriaRepository categoriaRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final FornecedorRepository fornecedorRepository;

    public Principal(CategoriaRepository categoriaRepository,
                     PedidoRepository pedidoRepository,
                     ProdutoRepository produtoRepository,
                      FornecedorRepository fornecedorRepository) {
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public void run(String... args) {
        List<Categoria> categorias = categoriaRepository.findByNomeContaining("Ford");
        for (Categoria categoria : categorias) {
            System.out.println("Categoria encontrada: " + categoria.getNome());
        }
        Fornecedor fornecedor = new Fornecedor("Fornecedor A");
        fornecedorRepository.save(fornecedor);

        List<Produto> entradasProdutos = Arrays.asList(new Produto("Moto", 22.4, fornecedor ), new Produto("Caminhão", 55.7, fornecedor));
        Categoria ford = new Categoria("Ford");
        ford.setProdutos(entradasProdutos);
        categoriaRepository.save(ford);

        Pedido carroPedido = new Pedido(1L, LocalDate.now());
        pedidoRepository.save(carroPedido);



        Produto carroProduto = new Produto("Carro", 12.3, fornecedor);
        produtoRepository.save(carroProduto);
    }
}
