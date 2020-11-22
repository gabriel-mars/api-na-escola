package com.gabriel.martins.apinaescola.model.entity;

import com.gabriel.martins.apinaescola.model.enums.TIPO_AVISO;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "aviso")
public class AvisoEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_aviso_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_aviso_id')")
    private Long id;

    @Column(name = "titulo_aviso", nullable = false)
    private String tituloAviso;

    @Column(name = "ano_classe")
    private String anoClasse;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_classe_id", columnDefinition = "bigint", nullable = true)
    private ClasseEntity classe;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @Column(name = "data_aviso", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAviso;

    @Column(name = "tipo_aviso")
    @Enumerated(EnumType.STRING)
    @Expose
    private TIPO_AVISO tipoAviso;

    @Column(name = "conteudo_aviso", nullable = false, columnDefinition = "TEXT")
    private String conteudo;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_aluno_id", columnDefinition = "bigint", nullable = true)
    private AlunoEntity aluno;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloAviso() {
        return tituloAviso;
    }

    public void setTituloAviso(String tituloAviso) {
        this.tituloAviso = tituloAviso;
    }

    public String getAnoClasse() {
        return anoClasse;
    }

    public void setAnoClasse(String anoClasse) {
        this.anoClasse = anoClasse;
    }

    public ClasseEntity getClasse() {
        return classe;
    }

    public void setClasse(ClasseEntity classe) {
        this.classe = classe;
    }

    public EscolaEntity getEscola() {
        return escola;
    }

    public void setEscola(EscolaEntity escola) {
        this.escola = escola;
    }

    public Date getDataAviso() {
        return dataAviso;
    }

    public void setDataAviso(Date dataAviso) {
        this.dataAviso = dataAviso;
    }

    public TIPO_AVISO getTipoAviso() {
        return tipoAviso;
    }

    public void setTipoAviso(TIPO_AVISO tipoAviso) {
        this.tipoAviso = tipoAviso;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvisoEntity)) return false;

        AvisoEntity that = (AvisoEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTituloAviso() != null ? !getTituloAviso().equals(that.getTituloAviso()) : that.getTituloAviso() != null)
            return false;
        if (getAnoClasse() != null ? !getAnoClasse().equals(that.getAnoClasse()) : that.getAnoClasse() != null)
            return false;
        if (getClasse() != null ? !getClasse().equals(that.getClasse()) : that.getClasse() != null) return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        if (getDataAviso() != null ? !getDataAviso().equals(that.getDataAviso()) : that.getDataAviso() != null)
            return false;
        if (getTipoAviso() != that.getTipoAviso()) return false;
        if (getConteudo() != null ? !getConteudo().equals(that.getConteudo()) : that.getConteudo() != null)
            return false;
        return getAluno() != null ? getAluno().equals(that.getAluno()) : that.getAluno() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTituloAviso() != null ? getTituloAviso().hashCode() : 0);
        result = 31 * result + (getAnoClasse() != null ? getAnoClasse().hashCode() : 0);
        result = 31 * result + (getClasse() != null ? getClasse().hashCode() : 0);
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getDataAviso() != null ? getDataAviso().hashCode() : 0);
        result = 31 * result + (getTipoAviso() != null ? getTipoAviso().hashCode() : 0);
        result = 31 * result + (getConteudo() != null ? getConteudo().hashCode() : 0);
        result = 31 * result + (getAluno() != null ? getAluno().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
