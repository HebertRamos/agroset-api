package br.com.app.agrosetapi.estoque.entity;

import br.com.app.agrosetapi.estoque.enumeration.AtivoInativoEnum;
import br.com.app.agrosetapi.estoque.enumeration.UnidadeMedidaEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Hramos
 */
@Entity
@Table(name = "VI_ESTOQUE_ITEM_COMPRA", schema = "public")
public class EstoqueItemCompraView {

    @Id
    @Column(name = "ic_id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "ic_nome", insertable = false, updatable = false)
    private String nome;

    @Column(name = "ic_codigo", insertable = false, updatable = false)
    private String codigo;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ic_unidade_medida", insertable = false, updatable = false)
    private UnidadeMedidaEnum unidadeMedida;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ic_situacao", insertable = false, updatable = false)
    private AtivoInativoEnum situacao;

    @Column(name = "ic_estoque", insertable = false, updatable = false)
    private BigDecimal estoque;

    @Column(name = "ic_estoque_reservado", insertable = false, updatable = false)
    private BigDecimal estoqueReservado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UnidadeMedidaEnum getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedidaEnum unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public AtivoInativoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(AtivoInativoEnum situacao) {
        this.situacao = situacao;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getEstoqueReservado() {
        return estoqueReservado;
    }

    public void setEstoqueReservado(BigDecimal estoqueReservado) {
        this.estoqueReservado = estoqueReservado;
    }
}
