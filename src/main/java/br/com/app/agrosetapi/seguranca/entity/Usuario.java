package br.com.app.agrosetapi.seguranca.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Hramos
 */
@Entity
@Table(name = "tb_usuario", schema = "public")
@SequenceGenerator(name = "seq_usuario", sequenceName = "public.seq_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_usuario")
    @Column(name = "us_id", nullable = false)
    private Long id;

    @Column(name = "us_email")
    private String email;

    @Column(name = "us_senha")
    @Transient
    private String senha;

    @Column(name = "us_nome")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


