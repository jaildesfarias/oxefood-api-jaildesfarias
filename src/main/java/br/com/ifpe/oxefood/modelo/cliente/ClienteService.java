package br.com.ifpe.oxefood.modelo.cliente;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifpe.oxefood.modelo.ClienteRepository;
@Service
public class ClienteService {

   @Autowired
   private ClienteRepository repository;

   @Transactional
   public Cliente save(Cliente cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       return repository.save(cliente);
   }

    
}
