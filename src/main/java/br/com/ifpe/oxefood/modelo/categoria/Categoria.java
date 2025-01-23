package br.com.ifpe.oxefood.modelo.categoria;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Categoria")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends EntidadeAuditavel {

    @Column(nullable = false, length = 100) // Nome da categoria é obrigatório
    private String nome;

    @Column(length = 255) // Descrição da categoria (opcional)
    private String descricao;
}
