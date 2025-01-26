package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

public class ProdutoRequest {

    @NotNull(message = "O ID da categoria é obrigatório.")
    private Long idCategoria;

    @NotNull(message = "O código do produto é obrigatório.")
    @Size(min = 3, max = 50, message = "O código do produto deve ter entre 3 e 50 caracteres.")
    private String codigo;

    @NotNull(message = "O título do produto é obrigatório.")
    @Size(min = 3, max = 100, message = "O título do produto deve ter entre 3 e 100 caracteres.")
    private String titulo;

    @NotNull(message = "A descrição do produto é obrigatória.")
    @Size(min = 5, max = 255, message = "A descrição do produto deve ter entre 5 e 255 caracteres.")
    private String descricao;

    @NotNull(message = "O valor unitário é obrigatório.")
    @Min(value = 0, message = "O valor unitário deve ser maior ou igual a 0.")
    private Double valorUnitario;

    @NotNull(message = "O tempo de entrega mínimo é obrigatório.")
    @Min(value = 0, message = "O tempo de entrega mínimo deve ser maior ou igual a 0.")
    private Integer tempoEntregaMinimo;

    @NotNull(message = "O tempo de entrega máximo é obrigatório.")
    @Min(value = 0, message = "O tempo de entrega máximo deve ser maior ou igual a 0.")
    private Integer tempoEntregaMaximo;

    // Getters and Setters
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getTempoEntregaMinimo() {
        return tempoEntregaMinimo;
    }

    public void setTempoEntregaMinimo(Integer tempoEntregaMinimo) {
        this.tempoEntregaMinimo = tempoEntregaMinimo;
    }

    public Integer getTempoEntregaMaximo() {
        return tempoEntregaMaximo;
    }

    public void setTempoEntregaMaximo(Integer tempoEntregaMaximo) {
        this.tempoEntregaMaximo = tempoEntregaMaximo;
    }
  
    public Produto build() { // Método para construir um objeto Produto a partir de ProdutoRequest
        Produto produto = new Produto();
        produto.setIdCategoria(this.idCategoria);  // Caso o Produto possua este campo
        produto.setCodigo(this.codigo);
        produto.setTitulo(this.titulo);
        produto.setDescricao(this.descricao);
        produto.setValorUnitario(this.valorUnitario);
        produto.setTempoEntregaMinimo(this.tempoEntregaMinimo);
        produto.setTempoEntregaMaximo(this.tempoEntregaMaximo);

        return produto;
    }
   
    public boolean validar() {  // Método para validação simples dos campos
        // Validação de campos obrigatórios
        return idCategoria != null && codigo != null && titulo != null &&
               descricao != null && valorUnitario != null && tempoEntregaMinimo != null && tempoEntregaMaximo != null;
    }
}
