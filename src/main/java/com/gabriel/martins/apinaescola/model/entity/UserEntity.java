package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_user_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_user_id')")
    private Long id;

    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "senha", length = 50)
    private String senha;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "municipio", length = 50)
    private String municipio;

    @Column(name = "uf", length = 2)
    private String uf;

    @Column(name = "cep", length = 10)
    private String cep;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCpf(), that.getCpf()) &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getSenha(), that.getSenha()) &&
                Objects.equals(getTelefone(), that.getTelefone()) &&
                Objects.equals(getEndereco(), that.getEndereco()) &&
                Objects.equals(getMunicipio(), that.getMunicipio()) &&
                Objects.equals(getUf(), that.getUf()) &&
                Objects.equals(getCep(), that.getCep());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf(), getNome(), getEmail(), getSenha(), getTelefone(), getEndereco(), getMunicipio(), getUf(), getCep());
    }
    //END - HASH and EQUALS
}
