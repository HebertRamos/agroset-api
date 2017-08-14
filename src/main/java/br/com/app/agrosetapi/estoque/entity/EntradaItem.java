package br.com.app.agrosetapi.estoque.entity;

import br.com.app.agrosetapi.estoque.enumeration.AtivoInativoEnum;
import br.com.app.agrosetapi.estoque.enumeration.UnidadeMedidaEnum;
import br.com.app.agrosetapi.seguranca.entity.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_ENTRADA_ITEM", schema = "public")
@SequenceGenerator(name = "SEQ_ENTRADA_ITEM", sequenceName = "public.SEQ_ENTRADA_ITEM")
public class EntradaItem {

    @Id
    @Column(name = "EI_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ENTRADA_ITEM")
    private Long id;

    @Column(name = "EI_DATA" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "EI_QUANTIDADE" ,nullable = false)
    private BigDecimal quantidade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "US_ID")
    private Usuario usuario;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IC_ID")
    private ItemCompra itemCompra;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }
}
