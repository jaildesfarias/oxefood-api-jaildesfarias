package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

   @Autowired
   private ClienteRepository repository;

   @Transactional
   public Cliente save(Cliente cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       return repository.save(cliente);
   }
       
   public List<Cliente> listarTodos() {
        
    return repository.findAll();//select*from
}

public Cliente obterPorID(Long id) {

    return repository.findById(id).get();//select*from cliente where id =?
}
   
   @Transactional
   public void update(Long id, Cliente clienteAlterado) {

      Cliente cliente = repository.findById(id).get();//alterado e um objeto do tipo Cliente contendo os dados alterados do cliente.
      cliente.setNome(clienteAlterado.getNome());
      cliente.setDataNascimento(clienteAlterado.getDataNascimento());
      cliente.setCpf(clienteAlterado.getCpf());
      cliente.setFoneCelular(clienteAlterado.getFoneCelular());
      cliente.setFoneFixo(clienteAlterado.getFoneFixo());
	    
      repository.save(cliente);
  }
  @Transactional
  public void delete(Long id) {

      Cliente cliente = repository.findById(id).get();
      cliente.setHabilitado(Boolean.FALSE);

      repository.save(cliente);
  }
  @Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarClientePorCpf(String cpf) {
        Optional<Cliente> clienteOpt = clienteRepository.findByCpf(cpf);
        return clienteOpt.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }


        
}

}