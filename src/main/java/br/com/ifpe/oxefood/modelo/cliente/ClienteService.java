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

    /**
     * Salva um novo cliente no banco de dados.
     *
     * @param cliente Objeto Cliente a ser salvo.
     * @return Cliente salvo.
     */
    @Transactional
    public Cliente save(Cliente cliente) {
        cliente.setHabilitado(Boolean.TRUE); // Define o cliente como habilitado por padrão
        return repository.save(cliente);
    }

    /**
     * Lista todos os clientes do banco de dados.
     *
     * @return Lista de clientes.
     */
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    /**
     * Obtém um cliente pelo ID.
     *
     * @param id Identificador do cliente.
     * @return Cliente encontrado.
     * @throws ClienteNotFoundException Se o cliente não for encontrado.
     */
    public Cliente obterPorID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente com ID " + id + " não encontrado."));
    }

    /**
     * Atualiza os dados de um cliente existente.
     *
     * @param id              Identificador do cliente a ser atualizado.
     * @param clienteAlterado Dados atualizados do cliente.
     * @throws ClienteNotFoundException Se o cliente não for encontrado.
     */
    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente com ID " + id + " não encontrado."));

        // Atualiza os dados
        cliente.setNome(clienteAlterado.getNome());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());

        repository.save(cliente);
    }

    /**
     * Desativa um cliente (soft delete).
     *
     * @param id Identificador do cliente a ser desativado.
     * @throws ClienteNotFoundException Se o cliente não for encontrado.
     */
    @Transactional
    public void delete(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente com ID " + id + " não encontrado."));
        cliente.setHabilitado(Boolean.FALSE);
        repository.save(cliente);
    }

    /**
     * Busca um cliente pelo CPF.
     *
     * @param cpf CPF do cliente.
     * @return Cliente encontrado.
     * @throws ClienteNotFoundException Se o cliente não for encontrado.
     */
    public Cliente buscarClientePorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente com CPF " + cpf + " não encontrado."));
    }

    /**
     * Atualiza os dados de um endereço existente.
     *
     * @param id               Identificador do endereço.
     * @param enderecoAlterado Dados atualizados do endereço.
     * @return Endereço atualizado.
     * @throws EnderecoNotFoundException Se o endereço não for encontrado.
     */
    @Transactional
    public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoCliente enderecoAlterado) {
        EnderecoCliente endereco = enderecoClienteRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço com ID " + id + " não encontrado."));

        endereco.setRua(enderecoAlterado.getRua());
        endereco.setNumero(enderecoAlterado.getNumero());
        endereco.setBairro(enderecoAlterado.getBairro());
        endereco.setCep(enderecoAlterado.getCep());
        endereco.setCidade(enderecoAlterado.getCidade());
        endereco.setEstado(enderecoAlterado.getEstado());
        endereco.setComplemento(enderecoAlterado.getComplemento());

        return enderecoClienteRepository.save(endereco);
    }

    /**
     * Remove um endereço de cliente (soft delete).
     *
     * @param idEndereco Identificador do endereço a ser removido.
     * @throws EnderecoNotFoundException Se o endereço ou cliente não for encontrado.
     */
    @Transactional
    public void removerEnderecoCliente(Long idEndereco) {
        EnderecoCliente endereco = enderecoClienteRepository.findById(idEndereco)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço com ID " + idEndereco + " não encontrado."));

        endereco.setHabilitado(Boolean.FALSE);
        enderecoClienteRepository.save(endereco);

        Cliente cliente = this.obterPorID(endereco.getCliente().getId());
        cliente.getEnderecos().removeIf(e -> e.getId().equals(idEndereco));
        repository.save(cliente);
    }
}
