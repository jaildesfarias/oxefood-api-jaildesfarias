package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera automaticamente getters, setters, toString(), equals() e hashCode().
@Builder // Permite criar objetos usando o padrão Builder.
@NoArgsConstructor // Gera o construtor padrão sem argumentos.
@AllArgsConstructor // Gera o construtor com todos os argumentos.
public class EntregadorRequest {

    @NotBlank(message = "O nome é obrigatório.")
    @Length(max = 100, message = "O nome deve ter no máximo {max} caracteres.")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
    private String cpf;

    @NotBlank(message = "O RG é obrigatório.")
    private String rg;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @JsonFormat(pattern = "dd/MM/yyyy") // Formata a data no padrão brasileiro durante serialização/deserialização.
    private LocalDate dataNascimento;

    @NotBlank(message = "O telefone celular é obrigatório.")
    @Length(min = 10, max = 15, message = "O telefone celular deve ter entre {min} e {max} caracteres.")
    private String foneCelular;

    private String foneFixo; // Opcional

    private Integer qtdEntregasRealizadas;

    private Double valorFrete;

    @NotBlank(message = "A rua do endereço é obrigatória.")
    @Length(max = 150, message = "A rua deve ter no máximo {max} caracteres.")
    private String enderecoRua;

    private String enderecoCompleto;

    @NotBlank(message = "O número do endereço é obrigatório.")
    private String enderecoNumero;

    @NotBlank(message = "O bairro do endereço é obrigatório.")
    private String enderecoBairro;

    @NotBlank(message = "A cidade do endereço é obrigatória.")
    private String enderecoCidade;

    @NotBlank(message = "O CEP do endereço é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 dígitos numéricos.")
    private String enderecoCep;

    @NotBlank(message = "O estado do endereço é obrigatório.")
    @Length(min = 2, max = 2, message = "O estado deve conter exatamente {max} caracteres (sigla).")
    private String enderecoUf;

    private Boolean ativo;

    /**
     * Método para construir um objeto Entregador com base nos dados fornecidos na requisição.
     */
    public Entregador build() {
        return Entregador.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .qtdEntregasRealizadas(qtdEntregasRealizadas)
                .valorFrete(valorFrete)
                .enderecoRua(enderecoRua)
                .enderecoCompleto(enderecoCompleto)
                .enderecoNumero(enderecoNumero)
                .enderecoBairro(enderecoBairro)
                .enderecoCidade(enderecoCidade)
                .enderecoCep(enderecoCep)
                .enderecoUf(enderecoUf)
                .ativo(ativo)
                .build();
    }
}
