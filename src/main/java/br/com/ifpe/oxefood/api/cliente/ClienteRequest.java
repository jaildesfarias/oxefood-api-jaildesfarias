
package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.ifpe.oxefood.modelo.acesso.Perfil;
import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String password;

    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "CPF não pode ser vazio")
    @CPF(message = "CPF inválido")
    private String cpf;

    @Length(min = 10, max = 15, message = "Número de telefone celular deve ter entre 10 e 15 caracteres")
    private String foneCelular;

    private String foneFixo; // Opcional

    /**
     * Constrói o objeto Usuario a partir dos dados de ClienteRequest.
     */
    public Usuario buildUsuario() {
        return Usuario.builder()
                .username(email)
                .password(password)
                .roles(Arrays.asList(new Perfil(Perfil.ROLE_CLIENTE)))
                .build();
    }

    /**
     * Constrói o objeto Cliente a partir dos dados de ClienteRequest.
     */
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
