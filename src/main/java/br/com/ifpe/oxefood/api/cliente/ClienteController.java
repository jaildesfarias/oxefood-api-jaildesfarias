package br.com.ifpe.oxefood.api.cliente;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
    @Tag(
    name = "API Cliente",
    description = "API responsável pelos servidos de cliente no sistema"
)

public class ClienteController {

    @Autowired
    private ClienteService clienteService;
@Operation(
       summary = "Serviço responsável por salvar um cliente no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema."
   )

    // Salvar um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {
        Cliente cliente = clienteService.save(request.build());
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    // Listar todos os clientes
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }
    // Obter cliente por ID
    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    // Buscar cliente por nome
    @GetMapping("/nome/{nome}")
    public List<Cliente> buscarPorNome(@PathVariable String nome) {
        return clienteService.buscarClientesPorNome(nome);
    }

    // Buscar cliente por CPF
    @GetMapping("/cpf/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarClientePorCpf(cpf);
    }

    // Atualizar dados de um cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id,
                                          @RequestBody @Valid ClienteRequest request) {
        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    // Remover (desabilitar) um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Adicionar endereço para um cliente
    @PostMapping("/endereco/{clienteId}")
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(
            @PathVariable("clienteId") Long clienteId,
            @RequestBody @Valid ClienteRequest request) {

        Cliente endereco = clienteService.adicionarCliente(clienteId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    // Atualizar endereço de um cliente
    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<Cliente> atualizarCliente(
            @PathVariable("enderecoId") Long enderecoId,
            @RequestBody @Valid ClienteRequest request) {

        Cliente endereco = clienteService.atualizarCliente(enderecoId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    // Remover (desabilitar) endereço de um cliente
    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerCliente(@PathVariable("enderecoId") Long enderecoId) {
        clienteService.removerCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }
}
