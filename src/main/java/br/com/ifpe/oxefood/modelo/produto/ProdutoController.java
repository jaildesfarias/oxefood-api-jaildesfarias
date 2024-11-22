package br.com.ifpe.oxefood.api.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

   @Autowired
   private ProdutoService produtoService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

       // Cria um objeto Cliente usando o método build() de ClienteRequest
       Produto produto = ProdutoService.save(request.build());
       
       // Retorna uma resposta HTTP 201 Created com o objeto Cliente criado
       return new ResponseEntity<>(produto, HttpStatus.CREATED);
   }
   @Transactional
   public void update(Long id, Produto produtoAlterado) {

      Produto.produto = repository.findById(id).get();
      Produto.setNome( produtoAlterado.getNome());
      Produto.setDataNascimento(produtoAlterado.getDataNascimento());
      Produto.setCpf(produtoAlterado.getCpf());
      Produto.setFoneCelular( produtorodutoAlterado.getFoneCelular());
      Produto.setFoneFixo(produtoAlterado.getFoneFixo());
	    
      repository.save (produto);
  }

}
