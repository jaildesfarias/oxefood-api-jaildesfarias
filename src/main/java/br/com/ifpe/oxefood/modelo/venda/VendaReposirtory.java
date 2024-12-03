package br.com.ifpe.oxefood.modelo.venda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Venda, Long> {
}
