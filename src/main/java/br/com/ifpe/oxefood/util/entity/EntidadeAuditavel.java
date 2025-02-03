package br.com.ifpe.oxefood.util.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAuditavel extends EntidadeNegocio implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY) // Evita carregamento desnecessário
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
    @Column(nullable = false, updatable = false)
    private Long criadoPor; // Id do usuário que criou a entidade

    @JsonIgnore
    @Column(nullable = false)
    private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração
}
