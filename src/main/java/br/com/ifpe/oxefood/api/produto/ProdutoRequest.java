package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produtor.Produto;

public class ProdutoRequest {
    private Long idCategoria;
    private String codigo;
    private String titulo;
    private String descricao;
    private Double valorUnitario;
    private Integer tempoEntregaMinimo;
    private Integer tempoEntregaMaximo;

    // Getters e Setters para cada campo
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

    // Método para construir um objeto Produto a partir de ProdutoRequest
    public Produto build() {
        Produto produto = new Produto();
        produto.setIdCategoria(this.idCategoria); // Caso o Produto possua este campo
        produto.setCodigo(this.codigo);
        produto.setTitulo(this.titulo);
        produto.setDescricao(this.descricao);
        produto.setValorUnitario(this.valorUnitario);
        produto.setTempoEntregaMinimo(this.tempoEntregaMinimo);
        produto.setTempoEntregaMaximo(this.tempoEntregaMaximo);

        return produto;
    }

    // Método para validação simples dos campos
    public boolean validar() {
        return idCategoria != null && codigo != null && titulo != null &&
                valorUnitario != null && tempoEntregaMinimo != null && tempoEntregaMaximo != null;
    }
}
