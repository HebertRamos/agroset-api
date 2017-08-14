package br.com.app.agrosetapi.comum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Hramos
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerErrorException extends RuntimeException {

    public ServerErrorException(String msg){
        super(msg);
    }
}
