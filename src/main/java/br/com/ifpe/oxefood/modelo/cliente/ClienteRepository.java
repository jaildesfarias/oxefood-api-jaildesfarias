package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
        
    public ListProduto<Cliente> findByNome(String nome);//  buscar clientes pelo nome

    public Cliente findByCpf(String cpf);//buscar cliente pelo CPF
  
}

