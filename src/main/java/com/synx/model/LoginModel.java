package com.synx.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class LoginModel {
  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  private int userId;

  private String accessToken;

  private String refreshToken;
}
