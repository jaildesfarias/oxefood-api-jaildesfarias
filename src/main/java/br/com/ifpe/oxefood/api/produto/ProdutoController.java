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
import br.com.ifpe.oxefood.modelo.categoria.CategoriaProdutoService;

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
        // Constrói o objeto Produto a partir do ProdutoRequest
        Produto produtoNovo = request.build();
        
        // Define a categoria do produto, recuperando pelo ID da categoria no request
        produtoNovo.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoria()));
        
        // Salva o produto no serviço
        Produto produtoSalvo = produtoService.save(produtoNovo);
        
        // Retorna o produto salvo com status 201 CREATED
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }
}
