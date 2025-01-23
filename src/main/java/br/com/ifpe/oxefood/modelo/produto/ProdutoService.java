package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
        produto.setHabilitado(Boolean.TRUE); // Habilita o produto por padrão.
        return repository.save(produto); // Salva o produto no banco.
    }

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

    @Transactional
    public void update(Long id, Produto produtoAlterado) {
        // Verifica se o produto existe no banco ou lança uma exceção.
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado para o ID: " + id));


        // Validação: Verifica se o valor unitário é menor que o mínimo permitido.
        if (produtoAlterado.getValorUnitario() < 10) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        }

        // Atualiza os campos do produto com os valores recebidos.
        produto.setCategoria(produtoAlterado.getCategoria());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

        // Incrementa a versão para controle de concorrência.
        produto.setVersao(produto.getVersao() + 1);

        // Salva o produto atualizado no repositório.
        repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll(); // Corrigido o método para retornar todos os produtos.
    }

}
//corrig
