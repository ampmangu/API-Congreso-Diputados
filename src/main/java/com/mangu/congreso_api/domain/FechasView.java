package com.mangu.congreso_api.domain;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity(name = "fechas_view")
@Immutable
@Table(name = "fechas_view", schema = "public")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class FechasView {

  @Id
  private String id;

  private LocalDate fecha;

  private String legislatura;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
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
    FechasView that = (FechasView) o;
    return Objects.equals(id, that.id) && Objects.equals(fecha, that.fecha) && Objects.equals(
        legislatura, that.legislatura);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fecha, legislatura);
  }

  @Override
  public String toString() {
    return "FechasView{" +
        "id='" + id + '\'' +
        ", fecha=" + fecha +
        ", legislatura='" + legislatura + '\'' +
        '}';
  }
}
