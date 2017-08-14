package br.com.app.agrosetapi.estoque.entity;

import br.com.app.agrosetapi.estoque.enumeration.TipoSaidaItemEnum;
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
@Table(name = "TB_SAIDA_ITEM", schema = "public")
@SequenceGenerator(name = "SEQ_SAIDA_ITEM", sequenceName = "public.SEQ_SAIDA_ITEM")
public class SaidaItem {

    @Id
    @Column(name = "SI_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SAIDA_ITEM")
    private Long id;

    @Column(name = "SI_DATA" ,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "SI_QUANTIDADE" ,nullable = false)
    private BigDecimal quantidade;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "SI_TIPO", nullable = false)
    private TipoSaidaItemEnum tipo;

    @Column(name = "SI_JUSTIFICATIVA" ,nullable = true)
    private String justificativa;

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

    public TipoSaidaItemEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoSaidaItemEnum tipo) {
        this.tipo = tipo;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
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
