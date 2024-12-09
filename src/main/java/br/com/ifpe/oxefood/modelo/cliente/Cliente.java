package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;
import java.util.List;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

@OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER) 
   private List<EnderecoCliente> enderecos;

    @Column(nullable = false,length = 100)  // Garantindo que o nome do cliente não seja nulo
    private String nome;

    @Column(nullable = false)  // Garantindo que a data de nascimento não seja nula
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

   @Column(unique = true)
    private String cpf;
   
    @Column
    private String foneCelular;

    @Column
    private String foneFixo;
}
