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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_ITEM_COMPRA", schema = "public")
@SequenceGenerator(name = "SEQ_ITEM_COMPRA", sequenceName = "public.SEQ_ITEM_COMPRA")
public class ItemCompra {

    @Id
    @Column(name = "ic_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITEM_COMPRA")
    private Long id;

    @Column(name = "ic_nome", nullable = false)
    private String nome;

    @Column(name = "ic_codigo", nullable = false)
    private String codigo;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ic_unidade_medida", nullable = false)
    private UnidadeMedidaEnum unidadeMedida;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ic_situacao", nullable = false)
    private AtivoInativoEnum situacao;

    @Column(name = "ic_estoque_minimo", nullable = false)
    private Integer estoqueMinimo;

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

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
}
