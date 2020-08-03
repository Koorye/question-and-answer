package com.synx.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class QuestionModel {
  private int id;

  private String title;

  private String content;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String tags;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private UserModel user;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<AnswerModel> answerList;
}
