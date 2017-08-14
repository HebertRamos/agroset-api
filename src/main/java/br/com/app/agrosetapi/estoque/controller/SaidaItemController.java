package br.com.app.agrosetapi.estoque.controller;

import br.com.app.agrosetapi.estoque.entity.EntradaItem;
import br.com.app.agrosetapi.estoque.entity.SaidaItem;
import br.com.app.agrosetapi.estoque.enumeration.TipoSaidaItemEnum;
import br.com.app.agrosetapi.estoque.repository.EntradaItemRepository;
import br.com.app.agrosetapi.estoque.repository.SaidaItemRepository;
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
@RequestMapping(path = "/agrosetApi/itensCompra/{idItem}/saidas")
public class SaidaItemController {

    @Autowired
    SaidaItemRepository saidaItemRepository;

    @Autowired
    LoggedUer loggedUer;


    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(@PathVariable("idItem") Long idItemCompra) {

        return saidaItemRepository.buscarTodosPorItemCompra(idItemCompra);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Object createSaida(@PathVariable("idItem") Long idItemCompra, @RequestBody SaidaItem saidaItem) {

        Usuario usuario = loggedUer.getUsuarioLogado();
        Date dataAtual = new Date();

        saidaItem.getItemCompra().setId(idItemCompra);
        saidaItem.setData(dataAtual);
        saidaItem.setUsuario(usuario);

        return saidaItemRepository.save(saidaItem);
    }
}
