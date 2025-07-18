package com.playblog.userservice.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponseDto {
  private String accessToken;
  private String refreshToken;
}
