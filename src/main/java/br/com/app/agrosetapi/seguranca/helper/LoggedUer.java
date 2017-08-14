package br.com.app.agrosetapi.seguranca.helper;

import br.com.app.agrosetapi.seguranca.UsuarioRepository;
import br.com.app.agrosetapi.seguranca.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Hramos
 */
@Component
public class LoggedUer {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario getUsuarioLogado(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return usuarioRepository.findByEmail(auth.getName());
    }
}
