package br.com.ifpe.oxefood.modelo.ordemServico;

import java.util.List;

public interface OrdemServico {

    void criar(OrdemServico ordemServico);  // Criar uma nova ordem de serviço

    List<OrdemServico> listarTodas();  // Listar todas as ordens de serviço

    OrdemServico obterPorId(Long id);  // Obter uma ordem de serviço por ID

    void atualizar(Long id, OrdemServico ordemServico);  // Atualizar uma ordem de serviço

    void remover(Long id);  // Remover uma ordem de serviço
}
