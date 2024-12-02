package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;

public class ProdRequest {

   private String codigo;
   private String titulo;
   private String descricao;
   private Double valorUnitario;
   private Integer tempoEntregaMinimo;
   private Integer tempoEntregaMaximo;

   // Getters e Setters para cada campo
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
    return  descricao;
}
public void setTitulo(String titulo) {
    this.titulo = titulo;
}
public String getvalorUnitario() {
    return  valorUnitario;

public void setValorUnitario(String valorUnitario) {
    this. valorUnitario =  valorUnitario;

   public String getTempoEntregaMinimo() {
       return TempoEntregaMinimo;
   }

   public void setTempoEntregaMinimo(String TempoEntregaMinimo) {
       this.t TempoEntregaMinimoe =  tempoEntregaMinimoe;
   }

   public String getTempoEntregaMaximo() {
       return TempoEntregaMaximo;
   }

   public void setTempoEntregaMaximo(Integer TempoEntregaMaximo) {
       this.TempoEntregaMaximo = TempoEntregaMaximo;
   }

 
   public Produto build() {
       Produto produto = new Produto();
       produto.setCodigo(this.codigo);
       produto.setTitulo(this.titulo);
       produto.setDescricao(this.descricao);
       produto.setValorUnitario(this.valorUnitario);
       produto.setETempoEntregaMinimo(this.TempoEntregaMinimo);
       produto.setTempoEntregaMaximo(this.TempoEntregaMaximo);

       return  produto;

   }
}

