package com.mangu.congreso_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity(name = "sesion")
@Table(name = "sesion", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sesionNumber", "legislatura"})
})
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Sesion {

  @Id
  @Column(nullable = false, updatable = false)
  private Integer id;

  @Column
  private Long sesionNumber;

  @Column
  private String legislatura;

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

  public String getLegislatura() {
    return legislatura;
  }

  public void setLegislatura(String legislatura) {
    this.legislatura = legislatura;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sesion sesion = (Sesion) o;
    return Objects.equals(id, sesion.id) && Objects.equals(sesionNumber, sesion.sesionNumber)
        && Objects.equals(legislatura, sesion.legislatura) && Objects.equals(votaciones,
        sesion.votaciones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sesionNumber, legislatura, votaciones);
  }


}
