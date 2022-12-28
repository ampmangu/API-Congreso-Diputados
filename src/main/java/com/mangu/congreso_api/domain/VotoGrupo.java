package com.mangu.congreso_api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity(name = "voto_grupo_view")
@Immutable
@Table(name = "voto_grupo_view", schema = "public")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class VotoGrupo {

  @Id
  private Long id;

  private String grupo;

  private String aFavor;

  private String enContra;

  private String abstencion;

  private String nsnc;

  private Long vid;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;

  private String titulo;

  private String titulosubgrupo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGrupo() {
    return grupo;
  }

  public void setGrupo(String grupo) {
    this.grupo = grupo;
  }

  public String getaFavor() {
    return aFavor;
  }

  public void setaFavor(String aFavor) {
    this.aFavor = aFavor;
  }

  public String getEnContra() {
    return enContra;
  }

  public void setEnContra(String enContra) {
    this.enContra = enContra;
  }

  public String getAbstencion() {
    return abstencion;
  }

  public void setAbstencion(String abstencion) {
    this.abstencion = abstencion;
  }

  public String getNsnc() {
    return nsnc;
  }

  public void setNsnc(String nsnc) {
    this.nsnc = nsnc;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTitulosubgrupo() {
    return titulosubgrupo;
  }

  public void setTitulosubgrupo(String titulosubgrupo) {
    this.titulosubgrupo = titulosubgrupo;
  }

  public Long getVid() {
    return vid;
  }

  public void setVid(Long vid) {
    this.vid = vid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VotoGrupo votoGrupo = (VotoGrupo) o;
    return Objects.equals(id, votoGrupo.id) && Objects.equals(grupo, votoGrupo.grupo)
        && Objects.equals(aFavor, votoGrupo.aFavor) && Objects.equals(enContra, votoGrupo.enContra)
        && Objects.equals(abstencion, votoGrupo.abstencion) && Objects.equals(nsnc, votoGrupo.nsnc)
        && Objects.equals(vid, votoGrupo.vid) && Objects.equals(fecha, votoGrupo.fecha)
        && Objects.equals(titulo, votoGrupo.titulo) && Objects.equals(titulosubgrupo,
        votoGrupo.titulosubgrupo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, grupo, aFavor, enContra, abstencion, nsnc, vid, fecha, titulo,
        titulosubgrupo);
  }

  @Override
  public String toString() {
    return "VotoGrupo{" +
        "id=" + id +
        ", grupo='" + grupo + '\'' +
        ", aFavor='" + aFavor + '\'' +
        ", enContra='" + enContra + '\'' +
        ", abstencion='" + abstencion + '\'' +
        ", nsnc='" + nsnc + '\'' +
        ", vid=" + vid +
        ", fecha=" + fecha +
        ", titulo='" + titulo + '\'' +
        ", titulosubgrupo='" + titulosubgrupo + '\'' +
        '}';
  }
}
