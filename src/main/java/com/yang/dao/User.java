package com.yang.dao;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
  private Long id;
  private String username;
  private String email;
  private String password;
  private LocalDateTime createdTime;

  // 是否删除
  // private Integer isDeleted;
}
