package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "responsavel")
public class ResponsavelEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_responsavel_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_responsavel_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_user_id", columnDefinition = "bigint")
    private UserEntity usuario;

    @Column(name = "foto", nullable = true, columnDefinition = "TEXT")
    private String foto;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponsavelEntity)) return false;

        ResponsavelEntity that = (ResponsavelEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getUsuario() != null ? !getUsuario().equals(that.getUsuario()) : that.getUsuario() != null) return false;
        return getFoto() != null ? getFoto().equals(that.getFoto()) : that.getFoto() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsuario() != null ? getUsuario().hashCode() : 0);
        result = 31 * result + (getFoto() != null ? getFoto().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
