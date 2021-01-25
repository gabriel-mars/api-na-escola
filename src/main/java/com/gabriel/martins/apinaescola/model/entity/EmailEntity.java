package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "email")
public class EmailEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_email_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_email_id')")
    private Long id;

    @Column (name = "email_escola")
    private String emailEscola;

    @Column (name = "nome_escola")
    private String nomeEscola;

    @Column (name = "titulo_duvida")
    private String tituloDuvida;

    @Column (name = "descricao_duvida")
    private String descricaoDuvida;

    @Column (name = "email_professor")
    private String emailProfessor;

    @Column (name = "nome_professor")
    private String nomeProfessor;

    @Column (name = "codigo_professor")
    private String codigoProfessor;

    @Column (name = "senha_professor")
    private String senhaProfessor;

    @Column (name = "codigo_mec_escola")
    private Integer codigoMec;

    @Column(name = "enviado", nullable = false, columnDefinition = "boolean default false")
    private Boolean enviado;

    @Column (name = "senha_escola")
    private String senhaEscola;

    @Column(name = "caracteristica")
    private String caracteristica;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailEscola() {
        return emailEscola;
    }

    public void setEmailEscola(String emailEscola) {
        this.emailEscola = emailEscola;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getTituloDuvida() {
        return tituloDuvida;
    }

    public void setTituloDuvida(String tituloDuvida) {
        this.tituloDuvida = tituloDuvida;
    }

    public String getDescricaoDuvida() {
        return descricaoDuvida;
    }

    public void setDescricaoDuvida(String descricaoDuvida) {
        this.descricaoDuvida = descricaoDuvida;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(String codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public String getSenhaProfessor() {
        return senhaProfessor;
    }

    public void setSenhaProfessor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }

    public Integer getCodigoMec() {
        return codigoMec;
    }

    public void setCodigoMec(Integer codigoMec) {
        this.codigoMec = codigoMec;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public String getSenhaEscola() {
        return senhaEscola;
    }

    public void setSenhaEscola(String senhaEscola) {
        this.senhaEscola = senhaEscola;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailEntity)) return false;

        EmailEntity that = (EmailEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getEmailEscola() != null ? !getEmailEscola().equals(that.getEmailEscola()) : that.getEmailEscola() != null)
            return false;
        if (getNomeEscola() != null ? !getNomeEscola().equals(that.getNomeEscola()) : that.getNomeEscola() != null)
            return false;
        if (getTituloDuvida() != null ? !getTituloDuvida().equals(that.getTituloDuvida()) : that.getTituloDuvida() != null)
            return false;
        if (getDescricaoDuvida() != null ? !getDescricaoDuvida().equals(that.getDescricaoDuvida()) : that.getDescricaoDuvida() != null)
            return false;
        if (getEmailProfessor() != null ? !getEmailProfessor().equals(that.getEmailProfessor()) : that.getEmailProfessor() != null)
            return false;
        if (getNomeProfessor() != null ? !getNomeProfessor().equals(that.getNomeProfessor()) : that.getNomeProfessor() != null)
            return false;
        if (getCodigoProfessor() != null ? !getCodigoProfessor().equals(that.getCodigoProfessor()) : that.getCodigoProfessor() != null)
            return false;
        if (getSenhaProfessor() != null ? !getSenhaProfessor().equals(that.getSenhaProfessor()) : that.getSenhaProfessor() != null)
            return false;
        if (getCodigoMec() != null ? !getCodigoMec().equals(that.getCodigoMec()) : that.getCodigoMec() != null)
            return false;
        if (getEnviado() != null ? !getEnviado().equals(that.getEnviado()) : that.getEnviado() != null) return false;
        if (getSenhaEscola() != null ? !getSenhaEscola().equals(that.getSenhaEscola()) : that.getSenhaEscola() != null)
            return false;
        return getCaracteristica() != null ? getCaracteristica().equals(that.getCaracteristica()) : that.getCaracteristica() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEmailEscola() != null ? getEmailEscola().hashCode() : 0);
        result = 31 * result + (getNomeEscola() != null ? getNomeEscola().hashCode() : 0);
        result = 31 * result + (getTituloDuvida() != null ? getTituloDuvida().hashCode() : 0);
        result = 31 * result + (getDescricaoDuvida() != null ? getDescricaoDuvida().hashCode() : 0);
        result = 31 * result + (getEmailProfessor() != null ? getEmailProfessor().hashCode() : 0);
        result = 31 * result + (getNomeProfessor() != null ? getNomeProfessor().hashCode() : 0);
        result = 31 * result + (getCodigoProfessor() != null ? getCodigoProfessor().hashCode() : 0);
        result = 31 * result + (getSenhaProfessor() != null ? getSenhaProfessor().hashCode() : 0);
        result = 31 * result + (getCodigoMec() != null ? getCodigoMec().hashCode() : 0);
        result = 31 * result + (getEnviado() != null ? getEnviado().hashCode() : 0);
        result = 31 * result + (getSenhaEscola() != null ? getSenhaEscola().hashCode() : 0);
        result = 31 * result + (getCaracteristica() != null ? getCaracteristica().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
