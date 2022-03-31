package com.mangu.congreso_api.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDto extends ResultDto {
    private String grupo;

    public GroupDto(String legislatura, String grupo) {
        super(null, legislatura, null, null, null);
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GroupDto groupDto = (GroupDto) o;
        return Objects.equals(grupo, groupDto.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grupo);
    }

    @Override
    public String toString() {
        return "GroupDto{" +
                "grupo='" + grupo + '\'' +
                ", legislatura='" + getLegislatura() + '\'' +
                '}';
    }

    public static class Builder {
        protected String legislatura;

        protected String grupo;

        public Builder legislatura(String legislatura) {
            this.legislatura = legislatura;
            return this;
        }

        public Builder grupo(String grupo) {
            this.grupo = grupo;
            return this;
        }

        public GroupDto build() {
            return new GroupDto(legislatura, grupo);
        }
    }
}
