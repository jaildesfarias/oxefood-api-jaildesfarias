package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {

    @Id
    private Long id;

    private String nome;
    private String cpf;
    private Boolean habilitado;
    private String foneCelular;
    private String foneFixo;

    // Outros atributos e métodos, se necessário
}

