package br.com.app.agrosetapi.estoque.repository;

import br.com.app.agrosetapi.estoque.entity.EntradaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Hramos
 */
public interface EntradaItemRepository extends JpaRepository<EntradaItem, Long> {


    @Query("SELECT ei FROM EntradaItem ei JOIN FETCH ei.usuario us JOIN FETCH ei.fornecedor fo JOIN FETCH ei.itemCompra ic WHERE ic.id = :idItemCompra ")
    public List<EntradaItem> buscarTodosPorItemCompra(@Param("idItemCompra") Long idItemCompra);
}
