package br.com.app.agrosetapi.estoque.repository;

import br.com.app.agrosetapi.estoque.entity.SaidaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Hramos
 */
public interface SaidaItemRepository extends JpaRepository<SaidaItem, Long> {

    @Query("SELECT si FROM SaidaItem si JOIN FETCH si.usuario us JOIN FETCH si.itemCompra ic WHERE ic.id = :idItemCompra ")
    public List<SaidaItem> buscarTodosPorItemCompra(@Param("idItemCompra") Long idItemCompra);
}
