package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

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

    private String nome;
    private String cpf;
    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy") // Formata a data no padrão brasileiro durante serialização/deserialização.
    private LocalDate dataNascimento;

    private String foneCelular;
    private String foneFixo;
    private Integer qtdEntregasRealizadas;
    private Double valorFrete;

    private String enderecoRua;
    private String enderecoCompleto;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoUf;

    private Boolean ativo;
   
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
