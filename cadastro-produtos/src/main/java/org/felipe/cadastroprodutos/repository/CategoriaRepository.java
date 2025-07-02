package org.felipe.cadastroprodutos.repository;

import org.felipe.cadastroprodutos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
