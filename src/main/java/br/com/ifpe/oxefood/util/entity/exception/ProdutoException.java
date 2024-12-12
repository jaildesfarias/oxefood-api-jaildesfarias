package br.com.ifpe.oxefood.util.entity.exception;

import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.annotation.ResponseStatus; 

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR) // Define o status HTTP da exceção
public class ProdutoException extends RuntimeException {

    public static final String MSG_VALOR_MINIMO_PRODUTO = 
        "Não é permitido inserir produtos com valores inferiores a R$ 10.";

    // Construtor da exceção
    public ProdutoException(String msg) {
        super(msg); // Usa a mensagem passada como parâmetro
    }
}
