package com.gabriel.martins.apinaescola.model.entity;

import com.gabriel.martins.apinaescola.model.enums.TIPO_USUARIO;
import com.google.gson.annotations.Expose;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
    
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_usuario_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_usuario_id')")
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
    
    @Column(name = "hash", length = 150)
    private String hash;
    
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    @Expose
    private TIPO_USUARIO tipo;

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

    public TIPO_USUARIO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO_USUARIO tipo) {
        this.tipo = tipo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEntity)) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCpf() != null ? !getCpf().equals(that.getCpf()) : that.getCpf() != null) return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getSenha() != null ? !getSenha().equals(that.getSenha()) : that.getSenha() != null) return false;
        if (getTelefone() != null ? !getTelefone().equals(that.getTelefone()) : that.getTelefone() != null)
            return false;
        if (getEndereco() != null ? !getEndereco().equals(that.getEndereco()) : that.getEndereco() != null)
            return false;
        if (getMunicipio() != null ? !getMunicipio().equals(that.getMunicipio()) : that.getMunicipio() != null)
            return false;
        if (getUf() != null ? !getUf().equals(that.getUf()) : that.getUf() != null) return false;
        return getCep() != null ? getCep().equals(that.getCep()) : that.getCep() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCpf() != null ? getCpf().hashCode() : 0);
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
        result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        result = 31 * result + (getMunicipio() != null ? getMunicipio().hashCode() : 0);
        result = 31 * result + (getUf() != null ? getUf().hashCode() : 0);
        result = 31 * result + (getCep() != null ? getCep().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
