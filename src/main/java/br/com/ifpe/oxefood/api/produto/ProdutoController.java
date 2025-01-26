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
import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
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
        try {
            // Validando a CategoriaProduto
            CategoriaProduto categoria = categoriaProdutoService.obterPorID(request.getIdCategoria());
            if (categoria == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // Retorna HTTP 400 se a categoria não for encontrada
            }

            // Construindo o Produto a partir do ProdutoRequest
            Produto produto = request.build();

            // Associando a Categoria ao Produto
            produto.setCategoria(categoria);

            // Salvando o Produto no banco de dados
            Produto produtoSalvo = produtoService.save(produto);

            // Retornando a resposta com o produto salvo e status HTTP 201 (Created)
            return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);

        } catch (Exception e) {
            // Tratamento genérico para erros
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null); // Retorna HTTP 500 em caso de falha
        }
    }
}
