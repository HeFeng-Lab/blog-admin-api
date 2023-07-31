package com.yang.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
  private Long id;
  private String name;

  // 是否删除
  private Integer isDeleted;
}
