package br.com.ifpe.oxefood.api.cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    description = "API responsável pelos serviços de cliente no sistema"
)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Salvar um novo cliente
    @PostMapping
    @Operation(
        summary = "Salvar cliente",
        description = "Serviço responsável por salvar um cliente no sistema."
    )
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {
        Cliente cliente = clienteService.save(request.build());
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    // Listar todos os clientes
    @GetMapping
    @Operation(
        summary = "Listar todos os clientes",
        description = "Serviço responsável por listar todos os clientes cadastrados no sistema."
    )
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    // Obter cliente por ID
    @GetMapping("/{id}")
    @Operation(
        summary = "Obter cliente por ID",
        description = "Serviço responsável por obter um cliente com base no ID fornecido."
    )
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    // Buscar cliente por nome
    @GetMapping("/nome/{nome}")
    @Operation(
        summary = "Buscar cliente por nome",
        description = "Serviço responsável por buscar clientes cujo nome contenha o texto informado."
    )
    public List<Cliente> buscarPorNome(@PathVariable String nome) {
        return clienteService.buscarClientesPorNome(nome);
    }

    // Buscar cliente por CPF
    @GetMapping("/cpf/{cpf}")
    @Operation(
        summary = "Buscar cliente por CPF",
        description = "Serviço responsável por buscar um cliente com base no CPF informado."
    )
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarClientePorCpf(cpf);
    }

    // Atualizar dados de um cliente
    @PutMapping("/{id}")
    @Operation(
        summary = "Atualizar cliente",
        description = "Serviço responsável por atualizar os dados de um cliente existente no sistema."
    )
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id,
                                          @RequestBody @Valid ClienteRequest request) {
        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    // Remover (desabilitar) um cliente
    @DeleteMapping("/{id}")
    @Operation(
        summary = "Remover cliente",
        description = "Serviço responsável por desabilitar (remover logicamente) um cliente do sistema."
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Adicionar endereço para um cliente
    @PostMapping("/endereco/{clienteId}")
    @Operation(
        summary = "Adicionar endereço ao cliente",
        description = "Serviço responsável por adicionar um novo endereço para um cliente existente."
    )
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(
            @PathVariable("clienteId") Long clienteId,
            @RequestBody @Valid ClienteRequest request) {

        Cliente endereco = clienteService.adicionarCliente(clienteId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    // Atualizar endereço de um cliente
    @PutMapping("/endereco/{enderecoId}")
    @Operation(
        summary = "Atualizar endereço do cliente",
        description = "Serviço responsável por atualizar os dados de um endereço de um cliente."
    )
    public ResponseEntity<Cliente> atualizarCliente(
            @PathVariable("enderecoId") Long enderecoId,
            @RequestBody @Valid ClienteRequest request) {

        Cliente endereco = clienteService.atualizarCliente(enderecoId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    // Remover (desabilitar) endereço de um cliente
    @DeleteMapping("/endereco/{enderecoId}")
    @Operation(
        summary = "Remover endereço do cliente",
        description = "Serviço responsável por desabilitar (remover logicamente) um endereço de um cliente."
    )
    public ResponseEntity<Void> removerCliente(@PathVariable("enderecoId") Long enderecoId) {
        clienteService.removerCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }
}//corrigir 
