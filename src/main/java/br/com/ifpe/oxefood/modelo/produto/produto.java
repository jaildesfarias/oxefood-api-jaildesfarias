package br.com.ifpe.oxefood.modelo.produto;

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
@Table(name = "produto")
@SQLRestriction("habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel  {
   


   @Column
   private String codigo;
   
   @Column
   private String titulo;

    @Column
   private String descricao; 

   @Column
   private Double valorUnitario; 

   @Column
   private Integer TempoEntregaMinimo; 

   @Column
   private Integer TempoEntregaMaximo; 

  

}

