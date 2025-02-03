
package br.com.ifpe.oxefood.modelo.ordemServico;

import java.util.List;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;

public interface OrdemServicoService {

    // Método para criar uma nova ordem de serviço
    void criar(OrdemServico ordemServico);

    // Método para listar todas as ordens de serviço
    List<OrdemServico> listarTodas();

    // Método para obter uma ordem de serviço por ID
    OrdemServico obterPorId(Long id);

    // Método para atualizar uma ordem de serviço existente
    void atualizar(Long id, OrdemServico ordemServico);

    // Método para remover uma ordem de serviço
    void remover(Long id);

    // Método para buscar ordens de serviço por cliente
    List<OrdemServico> buscarPorCliente(Cliente cliente);

    // Método para buscar ordens de serviço pelo status
    List<OrdemServico> buscarPorStatus(String status);
}
