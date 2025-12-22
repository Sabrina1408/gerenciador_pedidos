// java
package com.example.gerenciador_pedidos.principal;

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

    public Principal(CategoriaRepository categoriaRepository,
                     PedidoRepository pedidoRepository,
                     ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void run(String... args) {
        Categoria carro = new Categoria("Ford");
        categoriaRepository.save(carro);

        Pedido carroPedido = new Pedido(1L, LocalDate.now());
        pedidoRepository.save(carroPedido);

        Produto carroProduto = new Produto("Carro", 12.3);
        produtoRepository.save(carroProduto);
    }
}
