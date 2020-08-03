package com.synx.controller.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostQuestionController {

  /**
   * 提交问题
   *
   * @param title   标题
   * @param content 内容
   * @param tags    标签
   * @param userId  Header 用户 ID
   * @return 状态码、消息体
   */
  @PostMapping("/question")
  public HttpStatus submitQuestion(@RequestParam String title, @RequestParam String content,
                                   @RequestParam String tags, @RequestHeader String userId) {
    return HttpStatus.OK;
  }

  /**
   * 举报问题
   *
   * @param questionId 问题 ID
   * @param userId     Header 用户 ID
   * @return 状态码、消息体
   */
  @PostMapping("/question/report/{questionId}")
  public HttpStatus reportQuestion(@PathVariable String questionId, @RequestHeader String userId) {
    return HttpStatus.OK;
  }

  /**
   * 收藏问题
   *
   * @param questionId 问题 ID
   * @param userId     Header 用户 ID
   * @return 状态码、消息体
   */
  @PostMapping("/question/star/{questionId}")
  public HttpStatus starQuestion(@PathVariable String questionId, @RequestHeader String userId) {
    return HttpStatus.OK;
  }
}
