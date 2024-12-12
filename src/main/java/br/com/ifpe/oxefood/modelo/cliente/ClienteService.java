package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoClienteRepository enderecoClienteRepository;

    // Salva um cliente no banco de dados
    @Transactional
    public Cliente save(Cliente cliente) {
        cliente.setHabilitado(Boolean.TRUE); // Define o cliente como habilitado por padrão
        return repository.save(cliente);
    }

    // Lista todos os clientes
    public List<Cliente> listarTodos() {
        return repository.findAll(); // Executa o select * from Cliente
    }

    // Obtém um cliente pelo ID
    public Cliente obterPorID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " não encontrado")); // Mensagem personalizada
    }

    // Atualiza um cliente existente
    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " não encontrado"));

        // Atualiza os dados do cliente
        cliente.setNome(clienteAlterado.getNome());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());

        repository.save(cliente); // Salva as alterações
    }

    // Desativa um cliente (soft delete)
    @Transactional
    public void delete(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " não encontrado"));
        cliente.setHabilitado(Boolean.FALSE); // Marca o cliente como desabilitado
        repository.save(cliente); // Salva a alteração
    }

    // Busca cliente pelo CPF
    public Cliente buscarClientePorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente com CPF " + cpf + " não encontrado"));
    }

    // Atualiza um endereço existente
    @Transactional
    public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoCliente enderecoAlterado) {
        EnderecoCliente endereco = enderecoClienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço com ID " + id + " não encontrado"));

        // Atualiza os dados do endereço
        endereco.setRua(enderecoAlterado.getRua());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setEstado(enderecoAlterado.getEstado());
        endereco.setComplemento(enderecoAlterado.getComplemento());

        return enderecoClienteRepository.save(endereco); // Salva as alterações
    }

    // Remove um endereço de cliente (soft delete)
    @Transactional
    public void removerEnderecoCliente(Long idEndereco) {
        EnderecoCliente endereco = enderecoClienteRepository.findById(idEndereco)
                .orElseThrow(() -> new RuntimeException("Endereço com ID " + idEndereco + " não encontrado"));

        // Marca o endereço como desabilitado
        endereco.setHabilitado(Boolean.FALSE);
        enderecoClienteRepository.save(endereco);

        // Remove o endereço da lista do cliente
        Cliente cliente = this.obterPorID(endereco.getCliente().getId());
        cliente.getEnderecos().removeIf(e -> e.getId().equals(idEndereco));
        repository.save(cliente); // Salva o cliente atualizado
    }
}
