
package br.com.ifpe.oxefood.modelo.Entregador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadoRepository extends JpaRepository<.Entregado, Long> {
        
    public List<Entregado> findByNome(String nome);//  buscar Entregado pelo nome

    public Entregado findByCpf(String cpf);//buscar .Entregado pelo CPF
  
}
