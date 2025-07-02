package org.felipe.cadastroprodutos.repository;
// Esse Repository vai permitir fazer operações CRUD automaticamente
import org.felipe.cadastroprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
