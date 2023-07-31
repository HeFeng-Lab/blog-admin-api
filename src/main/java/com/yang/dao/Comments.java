package com.yang.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class Comments implements Serializable {
  private Long id;
  private Long user_id;
  private Long article_id;
  private String content;
  private String createdTime;

  // 是否删除
  private Integer isDeleted;
}
