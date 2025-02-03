package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;  // Corrigido para a importação correta de JsonFormat
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;



@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")//erro

@Builder//erro

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entregador extends EntidadeAuditavel {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
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
    private Double valorFrete;  // Corrigido para Double ou BigDecimal, dependendo do caso.

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

    @Column(nullable = false)
    private Boolean ativo;  // Assumindo que "ativo" é um campo obrigatório
}
