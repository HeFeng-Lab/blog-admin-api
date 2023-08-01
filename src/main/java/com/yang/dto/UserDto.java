package com.yang.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yang.dao.User;

public class UserDto extends User {
  @JsonIgnore
  private String password;
}
