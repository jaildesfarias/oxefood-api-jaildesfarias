package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel  {

   @Column
   private String nome;
   
   @Column
   private String cpf;

   @Column
   private String rg;

  
   

   @Column
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

   @Column
   private Integer qtEntregasRealizadas;

   @Column
   private String valorFrete;

   @Column
   private String enderecoRua;

   @Column
   private String enderecoCompleto;

   @Column
   private String enderecoNumero;

   @Column
   private String enderecoBairro;

   @Column
   private String enderecoCidade;

   @Column
   private String enderecoCep;

   @Column
   private String enderecoUf;

   @Column
   private Boolean ativo;

}
