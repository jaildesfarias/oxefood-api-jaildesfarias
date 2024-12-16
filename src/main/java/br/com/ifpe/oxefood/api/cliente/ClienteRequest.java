package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.acesso.Perfil;
import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Arrays;
im

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class ClienteRequest {
    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String password;

   
   @NotNull(message = "O Nome é de preenchimento obrigatório") // Válida se o campo está nulo.
   @NotEmpty(message = "O Nome é de preenchimento obrigatório") // Válida se o campo está vazio.
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")// Válida o tamanho mínimo e máximo de um campo.

    @NotBlank(message = "Nome não pode ser vazio.")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "CPF não pode ser vazio.")
    @CPF(message = "CPF inválido.")
    private String cpf;

    @Length(min = 10, max = 15, message = "Número de telefone celular deve ter entre 10 e 15 caracteres.")
    private String foneCelular;

    private String foneFixo; // Opcional

  @NotBlank(message = "O CPF é de preenchimento obrigatório")
  @CPF
  private String cpf;

  @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
   private String foneCelular;
   
   public Usuario buildUsuario() {
    return Usuario.builder()
        .username(email)
        .password(password)
        .roles(Arrays.asList(new Perfil(Perfil.ROLE_CLIENTE)))
        .build();
}

   public Cliente build() {
    
       return Cliente.builder()
           .usuario(buildUsuario())
           .nome(nome)
           .dataNascimento(dataNascimento)
           .cpf(cpf)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .build();
   }


    
    }

