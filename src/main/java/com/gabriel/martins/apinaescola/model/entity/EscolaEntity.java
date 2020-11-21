package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "escola")
public class EscolaEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_escola_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_escola_id')")
    private Long id;

    @Column(name = "codigo_mec", nullable = false, unique = true)
    private Integer codigoMec;

    @Column(name = "escola_nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "senha", nullable = false, length = 50)
    private String senha;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "municipio", length = 50)
    private String municipio;

    @Column(name = "uf", length = 2)
    private String uf;

    @Column(name = "logo", length = 100)
    private String logo;

    @Column(name = "confirmacao", nullable = false, length = 50)
    private String confirmacao;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_user_id", columnDefinition = "bigint")
    private UserEntity diretor;

    // GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigoMec() {
        return codigoMec;
    }

    public void setCodigoMec(Integer codigoMec) {
        this.codigoMec = codigoMec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public UserEntity getDiretor() {
        return diretor;
    }

    public void setDiretor(UserEntity diretor) {
        this.diretor = diretor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(String confirmacao) {
        this.confirmacao = confirmacao;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EscolaEntity that = (EscolaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(codigoMec, that.codigoMec) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(senha, that.senha) &&
                Objects.equals(diretor, that.diretor) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(cep, that.cep) &&
                Objects.equals(endereco, that.endereco) &&
                Objects.equals(municipio, that.municipio) &&
                Objects.equals(uf, that.uf) &&
                Objects.equals(logo, that.logo) &&
                Objects.equals(confirmacao, that.confirmacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoMec, nome, email, senha, diretor, telefone, cep, endereco, municipio, uf, logo, confirmacao);
    }
    //END - HASH and EQUALS
}
