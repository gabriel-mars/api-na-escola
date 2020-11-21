package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;

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
    private String bimestre;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "data_boletim", nullable = false)
    @Temporal(TemporalType.DATE)
    private String dataBoletim;

    @Column(name = "individual_gerado", nullable = false, columnDefinition = "boolean default false")
    private Boolean individualGerado;
}
