package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "boletim_componente")
public class BoletimComponenteEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_boletim_componente_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_boletim_componente_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_boletim_id", columnDefinition = "bigint")
    private BoletimEntity boletim;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_componente_id", columnDefinition = "bigint")
    private ComponenteCurricularEntity componente;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoletimEntity getBoletim() {
        return boletim;
    }

    public void setBoletim(BoletimEntity boletim) {
        this.boletim = boletim;
    }

    public ComponenteCurricularEntity getComponente() {
        return componente;
    }

    public void setComponente(ComponenteCurricularEntity componente) {
        this.componente = componente;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoletimComponenteEntity)) return false;

        BoletimComponenteEntity that = (BoletimComponenteEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getBoletim() != null ? !getBoletim().equals(that.getBoletim()) : that.getBoletim() != null) return false;
        return getComponente() != null ? getComponente().equals(that.getComponente()) : that.getComponente() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getBoletim() != null ? getBoletim().hashCode() : 0);
        result = 31 * result + (getComponente() != null ? getComponente().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
