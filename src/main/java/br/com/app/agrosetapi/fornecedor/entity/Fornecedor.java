package br.com.app.agrosetapi.fornecedor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Hramos
 */
@Entity
@Table(name = "TB_FORNECEDOR", schema = "public")
@SequenceGenerator(name = "SEQ_FORNECEDOR", sequenceName = "public.SEQ_FORNECEDOR")
public class Fornecedor {

    @Id
    @Column(name = "fo_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_FORNECEDOR")
    private Long id;

    @Column(name = "fo_nome", nullable = false)
    private String nome;

    @Column(name = "fo_documento", nullable = false)
    private String documento;

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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
