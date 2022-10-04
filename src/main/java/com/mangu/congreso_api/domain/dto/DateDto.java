package com.mangu.congreso_api.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class DateDto implements Serializable {

  private String date;

  private String legislatura;

  public DateDto(String date, String legislatura) {
    this.date = date;
    this.legislatura = legislatura;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
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
    DateDto dateDto = (DateDto) o;
    return Objects.equals(date, dateDto.date) && Objects.equals(legislatura, dateDto.legislatura);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, legislatura);
  }

  @Override
  public String toString() {
    return "DateDto{" +
        "date='" + date + '\'' +
        ", legislatura='" + legislatura + '\'' +
        '}';
  }

  public static class Builder {

    protected String date;

    protected String legislatura;

    public Builder date(String date) {
      this.date = date;
      return this;
    }

    public Builder legislatura(String legislatura) {
      this.legislatura = legislatura;
      return this;
    }

    public DateDto build() {
      return new DateDto(date, legislatura);
    }
  }
}
