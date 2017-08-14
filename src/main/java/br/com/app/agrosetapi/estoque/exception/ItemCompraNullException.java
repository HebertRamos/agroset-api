package br.com.app.agrosetapi.estoque.exception;

import br.com.app.agrosetapi.comum.exception.ServerErrorException;

/**
 * @author Hramos
 */
public class ItemCompraNullException extends ServerErrorException {

    public ItemCompraNullException(){
        super("Item Compra não existe");
    }
}
