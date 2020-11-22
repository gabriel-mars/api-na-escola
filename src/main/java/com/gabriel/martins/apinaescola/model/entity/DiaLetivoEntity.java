package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dia_letivo")
public class DiaLetivoEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_dia_letivo_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_dia_letivo_id')")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @Column(name = "dia")
    private String diaLetivo;

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

    public String getDiaLetivo() {
        return diaLetivo;
    }

    public void setDiaLetivo(String diaLetivo) {
        this.diaLetivo = diaLetivo;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiaLetivoEntity)) return false;

        DiaLetivoEntity that = (DiaLetivoEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        return getDiaLetivo() != null ? getDiaLetivo().equals(that.getDiaLetivo()) : that.getDiaLetivo() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getDiaLetivo() != null ? getDiaLetivo().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
