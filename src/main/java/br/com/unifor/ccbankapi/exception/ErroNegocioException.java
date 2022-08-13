/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.unifor.ccbankapi.exception;

import br.com.unifor.ccbankapi.domain.ErroResponse;
import java.time.LocalDateTime;
import javax.ws.rs.core.Response;

/**
 *
 * @author wander
 */
public class ErroNegocioException extends Exception {
    
    private final ErroResponse erro;
    
    public ErroNegocioException(String mensagem) {
        this(mensagem, Response.Status.BAD_REQUEST);
    }
        
    public ErroNegocioException(String mensagem, Throwable e) {
        this(mensagem, e, Response.Status.BAD_REQUEST);
    }
    
    public ErroNegocioException(String mensagem, Response.Status status) {                    
        this(mensagem, new ErroResponse(mensagem, status.getStatusCode(), LocalDateTime.now()));
    }
    
    public ErroNegocioException(String mensagem, Throwable e, Response.Status status) {        
        this(mensagem, e, new ErroResponse(mensagem, status.getStatusCode(), LocalDateTime.now()));
    }
    
    public ErroNegocioException(String mensagem, ErroResponse erro) {
        super(mensagem);
        this.erro = erro;
    }
    public ErroNegocioException(String mensagem, Throwable e, ErroResponse erro) {
        super(mensagem, e);
        this.erro = erro;
    }
    
    public ErroResponse getErroResponse() {
        return this.erro;
    }
}
