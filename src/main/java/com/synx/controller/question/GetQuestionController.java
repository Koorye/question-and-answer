package com.synx.controller.question;

import com.synx.model.AnswerModel;
import com.synx.model.QuestionModel;
import com.synx.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetQuestionController {

  /**
   * 根据问题 ID 返回一个问题
   *
   * @param questionId 问题 ID
   * @param withAnswer 可选 是否返回回答列表
   * @return 状态码、消息体、问题内容、回答列表
   */
  @GetMapping("/question/{questionId}")
  public ResponseEntity<QuestionModel> getQuestionByQuestionId(@PathVariable int questionId,
                                                               boolean withAnswer) {
    QuestionModel questionModel = new QuestionModel().setId(1).setTitle("微积分")
        .setTags("高数,学习").setContent("微积分怎么学？")
        .setUser(new UserModel().setId(10001).setUsername("user1").setNickname("憨憨1"));

    if (withAnswer) {
      List<AnswerModel> list = new ArrayList<>();
      list.add(new AnswerModel().setId(1).setContent("你个憨憨")
          .setUser(new UserModel().setId(10001).setUsername("user1").setNickname("憨憨1")));
      list.add(new AnswerModel().setId(2).setContent("你个憨憨")
          .setUser(new UserModel().setId(10002).setUsername("user2").setNickname("憨憨2")));
      list.add(new AnswerModel().setId(3).setContent("你个憨憨")
          .setUser(new UserModel().setId(10003).setUsername("user3").setNickname("憨憨3")));
      questionModel.setAnswerList(list);
    }

    return new ResponseEntity<>(questionModel, HttpStatus.OK);
  }

  /**
   * 根据页码返回问题列表
   *
   * @param tags 标签
   * @param key  搜索关键词
   * @param page 页码
   * @return 状态码、消息体、问题列表
   */
  @GetMapping("/question/page/{page}")
  public ResponseEntity<List<QuestionModel>> getQuestionByPage(@PathVariable int page,
                                                               String tags, String key) {
    List<QuestionModel> list = new ArrayList<>();

    list.add(new QuestionModel().setId(1).setTitle("微积分")
        .setTags("高数,学习").setContent("微积分怎么学？")
        .setUser(new UserModel().setId(10001).setUsername("user1").setNickname("憨憨1")));

    list.add(new QuestionModel().setId(2).setTitle("大物")
        .setTags("物理,学习").setContent("大物怎么学？")
        .setUser(new UserModel().setId(10002).setUsername("user2").setNickname("憨憨2")));

    list.add(new QuestionModel().setId(3).setTitle("离散")
        .setTags("高数,学习").setContent("离散怎么学？")
        .setUser(new UserModel().setId(10003).setUsername("user3").setNickname("憨憨3")));

    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  /**
   * 根据用户 ID 和页码返回问题列表
   *
   * @param userId 用户 ID
   * @param page   页码
   * @return 状态码、消息体、问题内容
   */
  @GetMapping("/api/question/{userId}/{page}")
  public ResponseEntity<List<QuestionModel>> getQuestionByUserIdAndPage(@PathVariable int userId,
                                                                        @PathVariable String page) {
    List<QuestionModel> list = new ArrayList<>();

    list.add(new QuestionModel().setId(1).setTitle("微积分")
        .setTags("高数,学习").setContent("微积分怎么学？"));

    list.add(new QuestionModel().setId(2).setTitle("大物")
        .setTags("物理,学习").setContent("大物怎么学？"));

    list.add(new QuestionModel().setId(3).setTitle("离散")
        .setTags("高数,学习").setContent("离散怎么学？"));

    return new ResponseEntity<>(list, HttpStatus.OK);
  }
}
