package com.mangu.congreso_api.domain;

import javax.persistence.*;
import java.util.List;


@Entity(name = "sesion")
@Table(name = "sesion", schema = "public")
public class Sesion {

    @Id
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column
    private Long sesionNumber;

    @OneToMany(mappedBy = "sesion", fetch = FetchType.EAGER)
    //TODO: If you ever find a way to filter the entire object if this property is empty, COOL.
    private List<Votacion> votaciones;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Long getSesionNumber() {
        return sesionNumber;
    }

    public void setSesionNumber(final Long sesionNumber) {
        this.sesionNumber = sesionNumber;
    }

    public List<Votacion> getVotaciones() {
        return votaciones;
    }

    public void setVotaciones(final List<Votacion> votaciones) {
        this.votaciones = votaciones;
    }

}
