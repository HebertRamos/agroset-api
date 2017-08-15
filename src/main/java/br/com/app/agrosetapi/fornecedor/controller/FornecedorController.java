package br.com.app.agrosetapi.fornecedor.controller;

import br.com.app.agrosetapi.fornecedor.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hramos
 */
@RestController
@RequestMapping(path = "/agrosetApi/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(){
        return fornecedorRepository.findAll();
    }
}
