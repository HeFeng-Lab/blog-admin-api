package com.yang.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yang.common.R;
import com.yang.dao.User;
import com.yang.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Utilities;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/register")
  public R<User> register(@RequestBody User user) {
    log.info("用户注册", user);

    user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

    userService.save(user);

    return R.success(user);
  }

  @PostMapping("/login")
  public R<User> login(@RequestBody User user) {

    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(User::getUsername, user.getUsername());
    queryWrapper.eq(User::getPassword, DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

    User u = userService.getOne(queryWrapper);

    if (u != null) {
      return R.success(u);
    }

    return R.error("账号或者密码错误！");
  }
}
