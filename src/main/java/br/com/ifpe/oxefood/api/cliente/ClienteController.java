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
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente; // Importe a classe EnderecoCliente
import br.com.ifpe.oxefood.api.cliente.ClienteRequest;
import br.com.ifpe.oxefood.api.cliente.EnderecoClienteRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Adicionar endereço para um cliente
    @PostMapping("/endereco/{clienteId}")
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(
            @PathVariable("clienteId") Long clienteId,
            @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {
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

    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @GetMapping("/nome/{nome}")
    public List<Cliente> buscarPorNome(@PathVariable String nome) {
        return clienteService.buscarClientesPorNome(nome);
    }

    @GetMapping("/cpf/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarClientePorCpf(cpf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id,
                                          @RequestBody @Valid ClienteRequest request) {
        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
