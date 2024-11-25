package br.com.ifpe.oxefood.util.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.Column;

import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAuditavel extends EntidadeNegocio {
  
   @JsonIgnore
   @Version
   private Long versao;

   @JsonIgnore
   @CreatedDate
   private LocalDate dataCriacao;

   @JsonIgnore
   @LastModifiedDate
   private LocalDate dataUltimaModificacao;

   @JsonIgnore
   @Column
   private Long criadoPor; // Id do usuário que o criou

   @JsonIgnore
   @Column
   private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração

}

 
