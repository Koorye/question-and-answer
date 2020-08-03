package com.synx.controller.user;

import com.synx.model.LoginModel;
import com.synx.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

  /**
   * 登录
   *
   * @param username 用户名
   * @param password 密码
   * @return 状态码、access token、refresh token、user ID
   */
  @PostMapping("/login")
  public ResponseEntity<LoginModel> login(@RequestParam String username, @RequestParam String password) {
    LoginModel loginModel = new LoginModel().setUserId(10001)
        .setAccessToken(JwtUtil.getToken(10001, 1800))
        .setRefreshToken(JwtUtil.getToken(10001, 3600 * 24 * 3));
    return new ResponseEntity<>(loginModel, HttpStatus.OK);
  }

  /**
   * 注册
   *
   * @param username 用户名
   * @param password 密码
   * @return 状态码
   */
  @PostMapping("/register")
  public HttpStatus register(@RequestParam String username, @RequestParam String password) {
    return HttpStatus.OK;
  }

  /**
   * 获取新 token
   *
   * @param userId       Header 用户 ID
   * @param refreshToken 刷新 token
   * @return 状态码、access token、refresh token
   */
  @PostMapping("/refresh-token")
  public ResponseEntity<LoginModel> refreshToken(@RequestHeader int userId,
                                                 @RequestHeader String refreshToken) {
    LoginModel loginModel = new LoginModel()
        .setAccessToken(JwtUtil.getToken(userId, 1800))
        .setRefreshToken(JwtUtil.getToken(userId, 3600 * 24 * 3));
    return new ResponseEntity<>(loginModel, HttpStatus.OK);
  }
}
