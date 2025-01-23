package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntregadorRepository extends JpaRepository<EntregadorRepository, Long> {

    public List<Entregador> findByNome(String nome); // Buscar Entregadores pelo nome

    public Entregador findByCpf(String cpf); // Buscar Entregador pelo CPF
}
//esta branco