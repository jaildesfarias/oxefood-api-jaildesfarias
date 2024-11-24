package br.com.ifpe.oxefood.api.Entregador;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera automaticamente getters, setters, toString(), equals() e hashCode().
@Builder// Permite criar objetos usando o padrão Builder.
@NoArgsConstructor//Geram os construtores padrão
@AllArgsConstructor
public class EntregadorRequest {

   private String nome;
   private String cpf;
   private String rg;
   @JsonFormat(pattern = "dd/MM/yyyy")
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
              .dataNascimento(dataNascimento)
              .cpf(cpf)
              .rg(rg)
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
