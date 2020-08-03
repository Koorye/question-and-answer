package com.synx.controller.manage;

import com.synx.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ManageUserController {

  /**
   * @param page 页码
   * @param key  可选 搜索关键词
   * @return 状态码、消息体、用户列表
   */
  @GetMapping("/admin/user/{page}")
  public ResponseEntity<List<UserModel>> getUserByPage(@PathVariable String page, String key) {
    List<UserModel> list = new ArrayList<>();

    list.add(new UserModel().setId(10001).setUsername("user1").setNickname("憨憨1"));
    list.add(new UserModel().setId(10002).setUsername("user2").setNickname("憨憨2"));
    list.add(new UserModel().setId(10003).setUsername("user3").setNickname("憨憨3"));

    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  /**
   * 封禁用户
   *
   * @param userId      用户 ID
   * @param prohibitDay 封禁天数
   * @return 状态码、消息体
   */
  @PostMapping("/admin/user/{userId}")
  public HttpStatus prohibitUser(@PathVariable int userId, @RequestParam int prohibitDay) {
    return HttpStatus.OK;
  }
}
