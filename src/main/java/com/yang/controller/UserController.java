package com.yang.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yang.common.R;
import com.yang.dao.User;
import com.yang.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Utilities;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/login")
  public R<User> login(@RequestBody Map map) {
    String username = map.get("username").toString();
    String password = map.get("password").toString();

    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(User::getUsername, username);
    queryWrapper.eq(User::getPassword, password);

    User user = userService.getOne(queryWrapper);

    if (user != null) {
      return R.success(user);
    }

    return R.error("账号或者密码错误！");
  }
}
