package com.mangu.congreso_api.domain.dto;

import lombok.Builder;

@Builder
public record MemberDto(String nombre, String grupo, String legislaturas) {

}
