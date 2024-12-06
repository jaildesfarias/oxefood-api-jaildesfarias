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
   }
   @Transactional
   public void update(Long id, Produto produtoAlterado) {

       Produto produto = repository.findById(id).get();
       produto.setCategoria(produtoAlterado.getCategoria());
       produto.setCodigo(produtoAlterado.getCodigo());
       produto.setTitulo(produtoAlterado.getTitulo());
       produto.setDescricao(produtoAlterado.getDescricao());
       produto.setValorUnitario(produtoAlterado.getValorUnitario());
       produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
       produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

       produto.setVersao(produto.getVersao() + 1);
       repository.save(produto);
   }


}

