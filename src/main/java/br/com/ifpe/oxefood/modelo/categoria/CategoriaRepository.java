package br.com.ifpe.oxefood.modelo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.oxefood.modelo.produto.ProdutoRepository;

public interface CategoriaRepository extends JpaRepository<ProdutoRepository, Long>{
    
}
