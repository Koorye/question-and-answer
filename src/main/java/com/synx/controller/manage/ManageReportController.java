package com.synx.controller.manage;

import com.synx.model.QuestionModel;
import com.synx.model.ReportModel;
import com.synx.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ManageReportController {

  /**
   * 根据页码获取举报列表
   *
   * @param page 页码
   * @param key  可选 搜索关键词
   * @param tags 可选 标签，以逗号分割
   * @return 状态码、消息体、举报信息
   */
  @GetMapping("/admin/report/{page}")
  public ResponseEntity<List<ReportModel>> getReportByPage(@PathVariable String page,
                                                           String key, String tags) {
    List<ReportModel> list = new ArrayList<>();

    list.add(new ReportModel().setId(1).setContent("太色了").setTags("色情")
        .setQuestion(new QuestionModel().setId(1).setTitle("微积分").setContent("性感荷官")
            .setUser(new UserModel().setId(10001).setUsername("user1").setNickname("憨憨1")))
        .setUser(new UserModel().setId(10000).setUsername("koorye").setNickname("憨憨")));

    list.add(new ReportModel().setId(2).setContent("太色了").setTags("色情")
        .setQuestion(new QuestionModel().setId(2).setTitle("离散").setContent("性感荷官")
            .setUser(new UserModel().setId(10002).setUsername("user2").setNickname("憨憨2")))
        .setUser(new UserModel().setId(10000).setUsername("koorye").setNickname("憨憨")));

    list.add(new ReportModel().setId(3).setContent("太色了").setTags("色情")
        .setQuestion(new QuestionModel().setId(3).setTitle("大物").setContent("性感荷官")
            .setUser(new UserModel().setId(10001).setUsername("user2").setNickname("憨憨3")))
        .setUser(new UserModel().setId(10000).setUsername("koorye").setNickname("憨憨")));

    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  /**
   * 通过举报
   *
   * @param reportId 举报 ID
   * @return 状态码、消息体
   */
  @PostMapping("/admin/report")
  public HttpStatus accessReport(@RequestParam String reportId) {
    return HttpStatus.OK;
  }

  /**
   * 驳回举报
   *
   * @param reportId 举报 ID
   * @return 状态码、消息体
   */
  @DeleteMapping("/admin/report")
  public HttpStatus denyReport(@RequestParam String reportId) {
    return HttpStatus.OK;
  }
}
