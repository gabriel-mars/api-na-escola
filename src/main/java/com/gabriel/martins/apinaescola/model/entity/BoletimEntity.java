package com.gabriel.martins.apinaescola.model.entity;

import com.gabriel.martins.apinaescola.model.enums.PERIODO_BOLETIM;
import com.gabriel.martins.apinaescola.model.enums.STATUS_BOLETIM;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "boletim")
public class BoletimEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_boletim_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_boletim_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_classe_id", columnDefinition = "bigint")
    private ClasseEntity classe;

    @Column(name = "bimestre")
    @Enumerated(EnumType.STRING)
    @Expose
    private PERIODO_BOLETIM bimestre;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "data_boletim", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataBoletim;

    @Column(name = "individual_gerado", nullable = false, columnDefinition = "boolean default false")
    private Boolean individualGerado;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EscolaEntity getEscola() {
        return escola;
    }

    public void setEscola(EscolaEntity escola) {
        this.escola = escola;
    }

    public ClasseEntity getClasse() {
        return classe;
    }

    public void setClasse(ClasseEntity classe) {
        this.classe = classe;
    }

    public PERIODO_BOLETIM getBimestre() {
        return bimestre;
    }

    public void setBimestre(PERIODO_BOLETIM bimestre) {
        this.bimestre = bimestre;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataBoletim() {
        return dataBoletim;
    }

    public void setDataBoletim(Date dataBoletim) {
        this.dataBoletim = dataBoletim;
    }

    public Boolean getIndividualGerado() {
        return individualGerado;
    }

    public void setIndividualGerado(Boolean individualGerado) {
        this.individualGerado = individualGerado;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoletimEntity)) return false;

        BoletimEntity that = (BoletimEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        if (getClasse() != null ? !getClasse().equals(that.getClasse()) : that.getClasse() != null) return false;
        if (getBimestre() != that.getBimestre()) return false;
        if (getObservacao() != null ? !getObservacao().equals(that.getObservacao()) : that.getObservacao() != null)
            return false;
        if (getDataBoletim() != null ? !getDataBoletim().equals(that.getDataBoletim()) : that.getDataBoletim() != null)
            return false;
        return getIndividualGerado() != null ? getIndividualGerado().equals(that.getIndividualGerado()) : that.getIndividualGerado() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getClasse() != null ? getClasse().hashCode() : 0);
        result = 31 * result + (getBimestre() != null ? getBimestre().hashCode() : 0);
        result = 31 * result + (getObservacao() != null ? getObservacao().hashCode() : 0);
        result = 31 * result + (getDataBoletim() != null ? getDataBoletim().hashCode() : 0);
        result = 31 * result + (getIndividualGerado() != null ? getIndividualGerado().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
