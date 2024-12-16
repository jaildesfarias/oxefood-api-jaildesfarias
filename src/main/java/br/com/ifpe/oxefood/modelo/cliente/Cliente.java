package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
@SQLRestriction("habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {
  // um para um
   @OneToOne
   @JoinColumn(nullable = false)
   private Usuario usuario;

     @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
         private List<EnderecoCliente> enderecos;

   @JsonIgnore
   @ManyToOne
   private Cliente cliente;

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
   private String rua;

   @Column
   private String numero;

   @Column
   private String cep;

   @Column
   private String cidade;

   @Column
   private String estado;

   @Column
   private String complemento;
  

}
