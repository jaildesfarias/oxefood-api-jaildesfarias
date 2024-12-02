package br.com.ifpe.oxefood.api;

public class VendaResquest {
    
    package br.com.ifpe.oxefood.api.venda;

    import java.time.LocalDate;
    
    import com.fasterxml.jackson.annotation.JsonFormat;
    
    import br.com.ifpe.oxefood.modelo.cliente.Cliente;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class VendaRequest {
    
       private String  cliente;
       private String produto;
       
       @JsonFormat(pattern = "dd/MM/yyyy")
       private LocalDate dataVenda;
    
       private String statusVenda;
    
       private Double valorTotal;
    
       private String observacao;
       private String retiradaEmLoja;
    
       public Venda build() {
    
           return Venda.builder()
               .cliente(cliente)
               .produto(produto)
               .dataVenda(dataVenda)
               .valorTotal(valorTotal)
               .observacao(observacao)
               .retiradaEmLoja(retiradaEmLoja)
               .build();
       }
    
    }
    

}
