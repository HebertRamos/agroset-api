package br.com.app.agrosetapi.estoque.controller;

import br.com.app.agrosetapi.estoque.entity.EntradaItem;
import br.com.app.agrosetapi.estoque.repository.EntradaItemRepository;
import br.com.app.agrosetapi.seguranca.entity.Usuario;
import br.com.app.agrosetapi.seguranca.helper.LoggedUer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Hramos
 */
@RestController
@RequestMapping(path = "/agrosetApi/itensCompra/{idItem}/entradas")
public class EntradaItemController {

    @Autowired
    EntradaItemRepository entradaItemRepository;

    @Autowired
    LoggedUer loggedUer;


    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(@PathVariable("idItem") Long idItemCompra){

        return entradaItemRepository.buscarTodosPorItemCompra(idItemCompra);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Object create(@PathVariable("idItem") Long idItemCompra, @RequestBody EntradaItem entradaItem){

        Usuario usuario = loggedUer.getUsuarioLogado();
        Date dataAtual = new Date();

        entradaItem.getItemCompra().setId(idItemCompra);
        entradaItem.setData(dataAtual);
        entradaItem.setUsuario(usuario);

        return entradaItemRepository.save(entradaItem);
    }
}
