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

public class ClienteRequest {
   
   @NotNull(message = "O Nome é de preenchimento obrigatório") // Válida se o campo está nulo.
   @NotEmpty(message = "O Nome é de preenchimento obrigatório") // Válida se o campo está vazio.
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")// Válida o tamanho mínimo e máximo de um campo.

   private String nome;
   
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

  @NotBlank(message = "O CPF é de preenchimento obrigatório")
  @CPF
  private String cpf;

  @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
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
