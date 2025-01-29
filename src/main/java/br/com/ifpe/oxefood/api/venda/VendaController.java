package br.com.ifpe.oxefood.api.venda;

import io.swagger.v3.oas.annotations.Operation
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.venda.Venda;
import br.com.ifpe.oxefood.modelo.venda.VendaService;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/venda")
@CrossOrigin
    @Tag(
    name = "API Venda",
    description = "API responsável pelos servidos de venda no sistema"
)

public class VendaController {

    @Autowired
    private VendaService vendaService;
    @Operation(
       summary = "Serviço responsável por salvar um vendae no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um venda no sistema."
   )


    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Venda> realizarVenda(@RequestBody VendaRequest request) {
        // Recupera o cliente (supondo que você tenha o ID do cliente no request)
        Cliente cliente = clienteService.obterPorId(request.getClienteId());
        
        // Recupera os produtos
        List<Produto> produtos = produtoService.obterProdutosPorIds(request.getProdutoIds());
        
        try {
            // Processa a venda
            Venda venda = vendaService.processarVenda(produtos, cliente);
            return new ResponseEntity<>(venda, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
