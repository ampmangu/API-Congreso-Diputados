package com.mangu.congreso_api.domain.dto;

import lombok.Builder;

@Builder
public record DateDto(String date, String legislatura) {

}
