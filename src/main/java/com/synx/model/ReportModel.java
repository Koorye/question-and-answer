package com.synx.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ReportModel {
  private int id;

  private String content;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String tags;

  private QuestionModel question;

  private UserModel user;
}
