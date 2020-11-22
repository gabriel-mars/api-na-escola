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
        if (!(o instanceof EscolaEntity)) return false;

        EscolaEntity that = (EscolaEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCodigoMec() != null ? !getCodigoMec().equals(that.getCodigoMec()) : that.getCodigoMec() != null)
            return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getSenha() != null ? !getSenha().equals(that.getSenha()) : that.getSenha() != null) return false;
        if (getTelefone() != null ? !getTelefone().equals(that.getTelefone()) : that.getTelefone() != null)
            return false;
        if (getCep() != null ? !getCep().equals(that.getCep()) : that.getCep() != null) return false;
        if (getEndereco() != null ? !getEndereco().equals(that.getEndereco()) : that.getEndereco() != null)
            return false;
        if (getMunicipio() != null ? !getMunicipio().equals(that.getMunicipio()) : that.getMunicipio() != null)
            return false;
        if (getUf() != null ? !getUf().equals(that.getUf()) : that.getUf() != null) return false;
        if (getLogo() != null ? !getLogo().equals(that.getLogo()) : that.getLogo() != null) return false;
        if (getConfirmacao() != null ? !getConfirmacao().equals(that.getConfirmacao()) : that.getConfirmacao() != null)
            return false;
        return getDiretor() != null ? getDiretor().equals(that.getDiretor()) : that.getDiretor() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCodigoMec() != null ? getCodigoMec().hashCode() : 0);
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
        result = 31 * result + (getCep() != null ? getCep().hashCode() : 0);
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        result = 31 * result + (getMunicipio() != null ? getMunicipio().hashCode() : 0);
        result = 31 * result + (getUf() != null ? getUf().hashCode() : 0);
        result = 31 * result + (getLogo() != null ? getLogo().hashCode() : 0);
        result = 31 * result + (getConfirmacao() != null ? getConfirmacao().hashCode() : 0);
        result = 31 * result + (getDiretor() != null ? getDiretor().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
