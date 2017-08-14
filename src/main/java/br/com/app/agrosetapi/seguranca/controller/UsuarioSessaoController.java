package br.com.app.agrosetapi.seguranca.controller;

import br.com.app.agrosetapi.seguranca.UsuarioRepository;
import br.com.app.agrosetapi.seguranca.helper.LoggedUer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Hramos
 */
@RestController
@RequestMapping(path = "/auth")
public class UsuarioSessaoController {

    @Autowired
    LoggedUer loggedUer;

    @RequestMapping(path = "/isLogged", method = RequestMethod.GET)
    public void getSession() {


    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public Object getUser(){
        return loggedUer.getUsuarioLogado();
    }
}
