package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

   @Autowired
   private ProdutoRepository repository;

   @Transactional
   public Produto save(Produto produto) {

    produto.setHabilitado(Boolean.TRUE);
       return repository.save(produto);
      @Transactional
public void update(Long id, Produto produtoAlterado) {

    // Busca o produto pelo ID ou lança uma exceção se não encontrado
    Produto produto = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado para o ID: " + id));

    // Atualiza os campos do produto com os valores recebidos
    produto.setCategoria(produtoAlterado.getCategoria());
    produto.setCodigo(produtoAlterado.getCodigo());
    produto.setTitulo(produtoAlterado.getTitulo());
    produto.setDescricao(produtoAlterado.getDescricao());
    produto.setValorUnitario(produtoAlterado.getValorUnitario());
    produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
    produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

    // Incrementa a versão para controle de concorrência
    produto.setVersao(produto.getVersao() + 1);

    // Salva o produto atualizado no repositório
    repository.save(produto);
}


   }



