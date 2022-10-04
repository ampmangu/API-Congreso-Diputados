package com.mangu.congreso_api.domain.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MemberDto {

  private String nombre;

  private String grupo;

  private Set<String> legislaturas;

  public MemberDto(String nombre, String grupo, Set<String> legislaturas) {
    this.nombre = nombre;
    this.grupo = grupo;
    this.legislaturas = legislaturas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getGrupo() {
    return grupo;
  }

  public void setGrupo(String grupo) {
    this.grupo = grupo;
  }

  public Set<String> getLegislaturas() {
    return legislaturas;
  }

  public void setLegislaturas(Set<String> legislaturas) {
    this.legislaturas = legislaturas;
  }

  public void addToGrupo(String legislatura) {
    if (legislaturas == null) {
      legislaturas = new HashSet<>();
    }
    legislaturas.add(legislatura);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberDto memberDto = (MemberDto) o;
    return Objects.equals(nombre, memberDto.nombre) && Objects.equals(grupo, memberDto.grupo)
        && Objects.equals(legislaturas, memberDto.legislaturas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, grupo, legislaturas);
  }

  @Override
  public String toString() {
    return "MemberDto{" +
        "nombre='" + nombre + '\'' +
        ", grupo='" + grupo + '\'' +
        ", legislatura=" + legislaturas +
        '}';
  }

  public static class Builder {

    protected String nombre;

    protected String grupo;

    protected Set<String> legislaturas;

    public Builder nombre(String nombre) {
      this.nombre = nombre;
      return this;
    }

    public Builder grupo(String grupo) {
      this.grupo = grupo;
      return this;
    }

    public Builder legislaturas(Set<String> legislaturas) {
      this.legislaturas = legislaturas;
      return this;
    }

    public MemberDto build() {
      return new MemberDto(nombre, grupo, legislaturas);
    }
  }
}
