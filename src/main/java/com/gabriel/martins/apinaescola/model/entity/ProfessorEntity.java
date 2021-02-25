package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "professor")
public class ProfessorEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_professor_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_professor_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_user_id", columnDefinition = "bigint")
    private UsuarioEntity usuario;

    @Column(name = "codigo_gerado_escola", nullable = false, length = 8)
    private String codigoGeradoEscola;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @Column(name = "senha_gerada", nullable = false)
    private String senhaGerada;

    public ProfessorEntity(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ProfessorEntity() {}

    // GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getCodigoGeradoEscola() {
        return codigoGeradoEscola;
    }

    public void setCodigoGeradoEscola(String codigoGeradoEscola) {
        this.codigoGeradoEscola = codigoGeradoEscola;
    }

    public EscolaEntity getEscola() {
        return escola;
    }

    public void setEscola(EscolaEntity escola) {
        this.escola = escola;
    }

    public String getSenhaGerada() {
        return senhaGerada;
    }

    public void setSenhaGerada(String senhaGerada) {
        this.senhaGerada = senhaGerada;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorEntity)) return false;

        ProfessorEntity that = (ProfessorEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getUsuario() != null ? !getUsuario().equals(that.getUsuario()) : that.getUsuario() != null) return false;
        if (getCodigoGeradoEscola() != null ? !getCodigoGeradoEscola().equals(that.getCodigoGeradoEscola()) : that.getCodigoGeradoEscola() != null)
            return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        return getSenhaGerada() != null ? getSenhaGerada().equals(that.getSenhaGerada()) : that.getSenhaGerada() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsuario() != null ? getUsuario().hashCode() : 0);
        result = 31 * result + (getCodigoGeradoEscola() != null ? getCodigoGeradoEscola().hashCode() : 0);
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getSenhaGerada() != null ? getSenhaGerada().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
