package com.yang.controller;

import com.yang.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class Test {
  @GetMapping()
  public R<String> Test() {
    return R.success("Hello World!");
  }
}
