package com.synx.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserModel {
  private int id;

  private String username;

  private String nickname;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String phone;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String email;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birth;
}
