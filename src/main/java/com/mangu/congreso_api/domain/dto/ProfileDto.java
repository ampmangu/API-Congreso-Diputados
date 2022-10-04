package com.mangu.congreso_api.domain.dto;

import java.util.List;
import java.util.Objects;

public class ProfileDto {

  private String id;

  private String nameAndSurname;

  private List<String> groups;

  private List<String> legislaturas;

  public ProfileDto(String nameAndSurname, List<String> group, List<String> legislatura) {
    this.nameAndSurname = nameAndSurname;
    this.groups = group;
    this.legislaturas = legislatura;
  }

  public String getNameAndSurname() {
    return nameAndSurname;
  }

  public void setNameAndSurname(String nameAndSurname) {
    this.nameAndSurname = nameAndSurname;
  }

  public List<String> getGroups() {
    return groups;
  }

  public void setGroups(List<String> groups) {
    this.groups = groups;
  }

  public List<String> getLegislaturas() {
    return legislaturas;
  }

  public void setLegislaturas(List<String> legislaturas) {
    this.legislaturas = legislaturas;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfileDto that = (ProfileDto) o;
    return Objects.equals(nameAndSurname, that.nameAndSurname) && Objects.equals(groups,
        that.groups) && Objects.equals(legislaturas, that.legislaturas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameAndSurname, groups, legislaturas);
  }

  @Override
  public String toString() {
    return "ProfileDto{" +
        "nameAndSurname='" + nameAndSurname + '\'' +
        ", group=" + groups +
        ", legislatura=" + legislaturas +
        '}';
  }

  public static class Builder {

    protected String nameAndSurname;
    protected List<String> groups;
    protected List<String> legislaturas;

    public Builder name(String name) {
      this.nameAndSurname = name;
      return this;
    }

    public Builder withGroup(String group) {
      this.groups = List.of(group);
      return this;
    }

    public Builder withGroups(List<String> groups) {
      this.groups = groups;
      return this;
    }

    public Builder withLegislatura(String legislatura) {
      this.legislaturas = List.of(legislatura);
      return this;
    }

    public Builder withLegislaturas(List<String> legislaturas) {
      this.legislaturas = legislaturas;
      return this;
    }

    public ProfileDto build() {
      ProfileDto profileDto = new ProfileDto(nameAndSurname, groups, legislaturas);
      int id = profileDto.hashCode();
      profileDto.setId(Integer.toString(id));
      return profileDto;
    }
  }
}
