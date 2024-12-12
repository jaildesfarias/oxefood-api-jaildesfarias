package br.com.ifpe.oxefood.api.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

import br.com.ifpe.oxefood.api.cliente.ClienteRequest;

import jakarta.validation.Valid;

@RestController // Define a classe como um controlador REST.
@RequestMapping("/api/cliente") // Mapeia o endpoint base (/api/cliente).
@CrossOrigin // Permite chamadas de diferentes origens (CORS).
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/endereco/{clienteId}")// Adicionar endereço para um cliente
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(
            @PathVariable("clienteId") Long clienteId,
            @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);

    @PostMapping // Mapeia rotas HTTP específicas (POST).
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {
        // Encapsula a resposta HTTP com status e corpo.
        Cliente cliente = clienteService.save(request.build());
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    // Atualizar endereço de um cliente
    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(
            @PathVariable("enderecoId") Long enderecoId,
            @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.OK);
    }

    // Remover endereço de um cliente
    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {
        clienteService.removerEnderecoCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}") // Obter cliente por ID
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @GetMapping("/nome/{nome}")// Buscar clientes por nome
    public List<Cliente> buscarPorNome(@PathVariable String nome) {
        return clienteService.buscarClientesPorNome(nome);
    }

    // Buscar cliente por CPF
    @GetMapping("/cpf/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarClientePorCpf(cpf);
    }

    @PutMapping("/{id}") // Atualizar dados de um cliente
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody @Valid ClienteRequest request) {

    @PutMapping("/{id}") // Extrai o valor do ID da URL.
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id,
            @RequestBody @Valid ClienteRequest request) {
        
            
        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")// Deletar cliente por ID
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
