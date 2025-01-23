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


public class Produto extends EntidadeAuditavel  {
    
    @NoArgsConstructor
    @ManyToOne
   private CategoriaProduto categoria;
   
 @Entity
@Table(name = "CategoriaProduto")
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String chaveEmpresa;

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

}
//corrigir @GeneratedValue(strategy = GenerationType.SEQUENCE)

