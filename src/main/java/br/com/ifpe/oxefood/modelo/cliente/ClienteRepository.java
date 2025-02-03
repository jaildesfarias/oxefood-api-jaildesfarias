
package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {  // Alterado para Cliente, não ClienteRepository
    
    List<Cliente> findByNome(String nome);  // Buscar cliente pelo nome

    Cliente findByCpf(String cpf);  // Buscar cliente pelo CPF
    
}
