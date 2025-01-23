package br.com.ifpe.oxefood.api.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import br.com.ifpe.oxefood.modelo.produto.CategoriaProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {
        // Construindo o Produto a partir do ProdutoRequest
        Produto produto = request.build();
        
        // Associando a Categoria ao Produto
        produto.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoria()));
        
        // Salvando o Produto no banco de dados
        Produto produtoSalvo = produtoService.save(produto);

        // Retornando a resposta com o produto salvo e status HTTP 201 (Created)
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }
}
//corrigir