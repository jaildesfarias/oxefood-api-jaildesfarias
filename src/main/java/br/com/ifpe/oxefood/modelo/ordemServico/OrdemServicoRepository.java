package br.com.ifpe.oxefood.modelo.ordemServico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.oxefood.modelo.ordemServico.OrdemServico;

public class OrdemServicoRepository extends JpaRepository<OrdemServicoRepository, Long> {
    
    OrdemServico findByDataServico(String dataServico);
    
    
     List<OrdemServico> findByCliente(String cliente);

     
    
}
