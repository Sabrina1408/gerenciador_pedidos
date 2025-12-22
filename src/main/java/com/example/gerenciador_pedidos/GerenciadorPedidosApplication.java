package com.example.gerenciador_pedidos;

import com.example.gerenciador_pedidos.principal.Principal;
import com.example.gerenciador_pedidos.repository.CategoriaRepository;
import com.example.gerenciador_pedidos.repository.PedidoRepository;
import com.example.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication  {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

}
