package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ja

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@NotNull // Válida se o campo está nulo.
@NotEmpty // Válida se o campo está vazio.
@Length // Válida o tamanho mínimo e máximo de um campo.



public class ClienteRequest {

   private String nome;
   
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   @NotBlank// Válida se o campo está nulo ou vazio.
   @CPF
   private String cpf;

   @Length // Válida o tamanho mínimo e máximo de um campo.
   private String foneCelular;
   


   public Cliente build() {

       return Cliente.builder()
           .nome(nome)
           .dataNascimento(dataNascimento)
           .cpf(cpf)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .build();
   }

}
