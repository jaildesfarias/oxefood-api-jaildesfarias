package br.com.ifpe.oxefood.modelo.venda;
    
    import java.time.LocalDate;
    
    
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    
    import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
    
    @Entity
    @Table(name = "venda")
    @SQLRestriction("incluir = true")
    
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Venda extends EntidadeAuditavel  {
       
     @Entity
    @Table(name = "incluir")
    public class Incluir {
    
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
    
        @Column
        private String cliente;
    
       @Column
       private String produto;
       
       @Column
       private String statusVenda;
    
        @Column
       private LocalDate dataVenda; 
    
       @Column
       private Double valorUnitario;  
    
       @Column
       private Boolean observacao; 
    
      
    
    }
    
    
}

