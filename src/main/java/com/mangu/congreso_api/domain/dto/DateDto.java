package com.mangu.congreso_api.domain.dto;

import java.io.Serializable;
import java.util.Objects;
import lombok.Builder;

@Builder
public record DateDto(String date, String legislatura) {

}
