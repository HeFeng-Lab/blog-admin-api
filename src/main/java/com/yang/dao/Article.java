package com.yang.dao;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Article implements Serializable {
  private Long id;
  private Long userId;
  private Long categoryId;
  private Long tagId;
  private String title;
  private String content;
  private Integer status;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

  // 是否删除
  private Integer isDeleted;
}
