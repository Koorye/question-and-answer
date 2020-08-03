package com.synx.controller.answer;

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
public class GetAnswerController {

  /**
   * 根据问题 ID 得到回答列表
   *
   * @param questionId 问题 ID
   * @return 状态码、消息体、回答列表
   */
  @GetMapping("/answer/{questionId}")
  public ResponseEntity<List<AnswerModel>> getAnswerByQuestionId(@PathVariable int questionId) {
    List<AnswerModel> answerList = new ArrayList<>();

    answerList.add(new AnswerModel().setId(1).setContent("你个憨憨")
        .setUser(new UserModel().setId(10001).setUsername("user1").setNickname("憨憨1")));

    answerList.add(new AnswerModel().setId(2).setContent("你个憨憨")
        .setUser(new UserModel().setId(10002).setUsername("user2").setNickname("憨憨2")));

    answerList.add(new AnswerModel().setId(3).setContent("你个憨憨")
        .setUser(new UserModel().setId(10003).setUsername("user3").setNickname("憨憨3")));

    return new ResponseEntity<>(answerList, HttpStatus.OK);
  }

  /**
   * 根据用户 ID 和页码得到回答列表
   *
   * @param userId 用户 ID
   * @param page   页码
   * @return 状态码、消息体、回答列表
   */
  @GetMapping("/answer/{userId}/{page}")
  public ResponseEntity<List<AnswerModel>> getAnswerByUserIdAndPage(@PathVariable int userId,
                                                                    @PathVariable String page) {
    List<AnswerModel> answerList = new ArrayList<>();

    answerList.add(new AnswerModel().setId(1).setContent("你个憨憨")
        .setQuestion(new QuestionModel().setId(1).setTitle("微积分").setContent("微积分怎么学?")));

    answerList.add(new AnswerModel().setId(2).setContent("你个憨憨")
        .setQuestion(new QuestionModel().setId(1).setTitle("大物").setContent("大物怎么学?")));

    answerList.add(new AnswerModel().setId(3).setContent("你个憨憨")
        .setQuestion(new QuestionModel().setId(1).setTitle("离散").setContent("离散怎么学?")));

    return new ResponseEntity<>(answerList, HttpStatus.OK);
  }
}
