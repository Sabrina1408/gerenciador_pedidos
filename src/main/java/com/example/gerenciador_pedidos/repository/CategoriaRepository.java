package com.example.gerenciador_pedidos.repository;

import com.example.gerenciador_pedidos.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
  List<Categoria> findByNomeContaining(String nome);
}
