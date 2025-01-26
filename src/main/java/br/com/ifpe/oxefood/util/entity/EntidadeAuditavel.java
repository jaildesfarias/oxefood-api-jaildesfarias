package br.com.ifpe.oxefood.util.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import org.hibernate.annotations.DialectOverride.SQLRestriction;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAuditavel extends EntidadeNegocio {

    
     @OneToOne
   @JoinColumn(nullable = false)
   private Usuario usuario;


    @JsonIgnore
    @Version
    private Long versao;

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate dataCriacao;

    @JsonIgnore
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDate dataUltimaModificacao;

    @JsonIgnore
    @Column
    private Long criadoPor; // Id do usuário que o criou

    @JsonIgnore
    @Column
    private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração
    
    @JsonIgnore
    @Column
    private Long  incluir;

    @Entity
    @Table(name ="CategoriaProduto")
    @SQLRestriction("habilitado =true")
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class CategoriaProduto extends EntidadeAuditavel {
     @Column
     private String descricao;
        
    }

}
