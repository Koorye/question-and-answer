package com.synx.controller.user;

import com.synx.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserInfoController {

  /**
   * 根据用户 ID 获取个人信息
   *
   * @param userId Header 用户 ID
   * @return 状态码、用户 ID、用户名、昵称、电子邮箱、手机号、生日
   */
  @GetMapping("/user")
  private ResponseEntity<UserModel> getInfoByUserId(@RequestHeader int userId) {
    UserModel userModel = new UserModel().setId(userId).setUsername("user1").setNickname("憨憨")
        .setPhone("158xxxxxxxx").setEmail("xxxx@xxx.com").setBirth(new Date());
    return new ResponseEntity<>(userModel, HttpStatus.OK);
  }

  /**
   * 修改个人信息
   *
   * @param userId   Header 用户 ID
   * @param nickname 昵称
   * @param email    电子邮箱
   * @param phone    手机号
   * @param birthday 生日
   * @return 状态码
   */
  @PutMapping("/user")
  private HttpStatus modifyInfoByUserId(@RequestHeader int userId, String nickname,
                                        String email, String phone, String birthday) {
    return HttpStatus.OK;
  }
}
