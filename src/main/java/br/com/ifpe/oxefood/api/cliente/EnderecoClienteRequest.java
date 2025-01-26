package br.com.ifpe.oxefood.api.cliente;

import org.hibernate.annotations.FetchMode;

public class EnderecoClienteRequest {
   
        private String rua;
     
        private String numero;
     
        private String bairro;
     
        private String cep;
     
        private String cidade;
     
        private String estado;
     
        private String complemento;
     
        public EnderecoCliente build() {
     
            return EnderecoCliente.builder()
                    .rua(rua)
                    .numero(numero)
                    .bairro(bairro)
                    .cep(cep)
                    .cidade(cidade)
                    .estado(estado)
                    .complemento(complemento)
                    .build();
        }
     }
     
    
}
