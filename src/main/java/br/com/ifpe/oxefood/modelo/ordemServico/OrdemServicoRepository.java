package br.com.ifpe.oxefood.modelo.ordemServico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.oxefood.modelo.cliente.Cliente; // Para o relacionamento com Cliente

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> { // Alterado para OrdemServico, Long
    
    // Busca por data de serviço (caso esse campo exista na sua entidade)
    OrdemServico findByDescricao(String descricao);  // Substituindo por um campo existente

    // Busca pela relação com Cliente
    List<OrdemServico> findByCliente(Cliente cliente);  // Alterado para usar Cliente ao invés de String

}
