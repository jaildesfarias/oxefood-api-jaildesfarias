package br.com.ifpe.oxefood.util.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção personalizada para a venda, com código de status 500 (INTERNAL_SERVER_ERROR).
 * Esta exceção é lançada quando há erros na venda, como um produto com valor inferior ao mínimo permitido.
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class VendaException extends RuntimeException {

    // Mensagem de erro constante para quando o valor do produto for inferior a R$ 10.
    public static final String MSG_VALOR_MINIMO_PRODUTO = "Não é permitido inserir produtos com valores inferiores a R$ 10.";

    // Construtor que recebe uma mensagem personalizada para a exceção.
    public VendaException(String msg) {
        super(msg); // Passa a mensagem para o construtor da classe pai (RuntimeException)
    }

    // Construtor sem parâmetros, útil para quando a exceção precisa ser lançada sem uma mensagem personalizada.
    public VendaException() {
        super(MSG_VALOR_MINIMO_PRODUTO); // Utiliza a mensagem constante padrão
    }
}

