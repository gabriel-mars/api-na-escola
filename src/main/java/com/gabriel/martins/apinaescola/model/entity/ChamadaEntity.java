package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "chamada")
public class ChamadaEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_chamada_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_chamada_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_classe_id", columnDefinition = "bigint")
    private ClasseEntity classe;

    @Column(name = "data_chamada", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataChamada;

    @Column(name = "chamada_finalizada", nullable = false, columnDefinition = "boolean default false")
    private Boolean chamadaFinalizada;

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

    public Date getDataChamada() {
        return dataChamada;
    }

    public void setDataChamada(Date dataChamada) {
        this.dataChamada = dataChamada;
    }

    public Boolean getChamadaFinalizada() {
        return chamadaFinalizada;
    }

    public void setChamadaFinalizada(Boolean chamadaFinalizada) {
        this.chamadaFinalizada = chamadaFinalizada;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChamadaEntity)) return false;

        ChamadaEntity that = (ChamadaEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        if (getClasse() != null ? !getClasse().equals(that.getClasse()) : that.getClasse() != null) return false;
        if (getDataChamada() != null ? !getDataChamada().equals(that.getDataChamada()) : that.getDataChamada() != null)
            return false;
        return getChamadaFinalizada() != null ? getChamadaFinalizada().equals(that.getChamadaFinalizada()) : that.getChamadaFinalizada() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getClasse() != null ? getClasse().hashCode() : 0);
        result = 31 * result + (getDataChamada() != null ? getDataChamada().hashCode() : 0);
        result = 31 * result + (getChamadaFinalizada() != null ? getChamadaFinalizada().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
