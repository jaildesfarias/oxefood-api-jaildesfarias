package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteRepository, Long> {
    
    List<Cliente> findByNome(String nome);

    Cliente findByCpf(String cpf);// Buscar cliente pelo CPF
}
