package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "evento")
public class EventoEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_evento_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_evento_id')")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @Column(name = "nome_evento", nullable = false, length = 50)
    private String nomeEvento;

    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicioEvento;

    @Column(name = "data_fim", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFimEvento;

    @Column(name = "horario_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicioEvento;

    @Column(name = "descricao_evento", nullable = false)
    private String descricaoEvento;

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

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataInicioEvento() {
        return dataInicioEvento;
    }

    public void setDataInicioEvento(Date dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    public Date getDataFimEvento() {
        return dataFimEvento;
    }

    public void setDataFimEvento(Date dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

    public Date getHoraInicioEvento() {
        return horaInicioEvento;
    }

    public void setHoraInicioEvento(Date horaInicioEvento) {
        this.horaInicioEvento = horaInicioEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventoEntity)) return false;

        EventoEntity that = (EventoEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        if (getNomeEvento() != null ? !getNomeEvento().equals(that.getNomeEvento()) : that.getNomeEvento() != null)
            return false;
        if (getDataInicioEvento() != null ? !getDataInicioEvento().equals(that.getDataInicioEvento()) : that.getDataInicioEvento() != null)
            return false;
        if (getDataFimEvento() != null ? !getDataFimEvento().equals(that.getDataFimEvento()) : that.getDataFimEvento() != null)
            return false;
        if (getHoraInicioEvento() != null ? !getHoraInicioEvento().equals(that.getHoraInicioEvento()) : that.getHoraInicioEvento() != null)
            return false;
        return getDescricaoEvento() != null ? getDescricaoEvento().equals(that.getDescricaoEvento()) : that.getDescricaoEvento() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getNomeEvento() != null ? getNomeEvento().hashCode() : 0);
        result = 31 * result + (getDataInicioEvento() != null ? getDataInicioEvento().hashCode() : 0);
        result = 31 * result + (getDataFimEvento() != null ? getDataFimEvento().hashCode() : 0);
        result = 31 * result + (getHoraInicioEvento() != null ? getHoraInicioEvento().hashCode() : 0);
        result = 31 * result + (getDescricaoEvento() != null ? getDescricaoEvento().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
