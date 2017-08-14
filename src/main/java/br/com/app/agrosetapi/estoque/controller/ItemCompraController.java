package br.com.app.agrosetapi.estoque.controller;

import br.com.app.agrosetapi.estoque.entity.ItemCompra;
import br.com.app.agrosetapi.estoque.exception.ItemCompraNullException;
import br.com.app.agrosetapi.estoque.repository.EstoqueItemCompraViewRepository;
import br.com.app.agrosetapi.estoque.repository.ItemCompraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hramos
 */
@RestController
@RequestMapping(path = "/agrosetApi/itensCompra")
public class ItemCompraController {

    @Autowired
    ItemCompraRepository itemCompraRepository;

    @Autowired
    EstoqueItemCompraViewRepository estoqueItemCompraViewRepository;


    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(){

        return estoqueItemCompraViewRepository.findAll();

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Object findById(@PathVariable("id") Long idItemCompra){

        return itemCompraRepository.findOne(idItemCompra);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody ItemCompra itemCompra){
            return itemCompraRepository.save(itemCompra);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Object update(@PathVariable("id") Long idItemCompra, @RequestBody ItemCompra itemCompra){

        ItemCompra itemCompraExistente = itemCompraRepository.findOne(idItemCompra);

        if(itemCompraExistente == null){
            throw  new ItemCompraNullException();
        }

        BeanUtils.copyProperties(itemCompra, itemCompraExistente);
        itemCompraExistente.setId(idItemCompra);

        return itemCompraRepository.save(itemCompraExistente);
    }



}
