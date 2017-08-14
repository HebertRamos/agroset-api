package br.com.app.agrosetapi.estoque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_ITEM_VENDA", schema = "public")
@SequenceGenerator(name = "SEQ_ITEM_VENDA", sequenceName = "public.SEQ_ITEM_VENDA")
public class ItemVenda {

    @Id
    @Column(name = "IVD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITEM_VENDA")
    private Long id;

    @Column(name = "IVD_QUANTIDADE" ,nullable = false)
    private BigDecimal quantidade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "VD_ID")
    private Venda venda;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IC_ID")
    private ItemCompra itemCompra;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }
}
