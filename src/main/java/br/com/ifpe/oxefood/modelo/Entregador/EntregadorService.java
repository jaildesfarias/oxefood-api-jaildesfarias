package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;

@Getter
@Setter
@Entity
public class Entregador extends EntidadeNegocio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String rg;

    @Column(nullable = false)
    private LocalDate dataNascimento;  // Alterado para LocalDate

    private String foneCelular;
    private String foneFixo;

    @Column(nullable = true)
    private Integer qtdEntregasRealizadas;

    @Column(nullable = false)
    private Double valorFrete;  // Alterado para Double

    private String enderecoRua;
    private String enderecoCompleto;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoUf;

    @Column(nullable = false)
    private Boolean habilitado = true;  // Valor padrão "true"
}
