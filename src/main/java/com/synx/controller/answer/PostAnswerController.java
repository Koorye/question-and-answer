package com.synx.controller.answer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostAnswerController {

  /**
   * 根据问题 ID 提交回答
   *
   * @param questionId 问题 ID
   * @param content    回答内容
   * @param username   Header 用户名
   * @return 状态码、消息体
   */
  @PostMapping("/answer/{questionId}")
  public HttpStatus submitAnswerByQuestionId(@PathVariable String questionId,
                                             @RequestParam String content,
                                             @RequestHeader String username) {
    return HttpStatus.OK;
  }
}
