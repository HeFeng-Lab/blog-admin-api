package com.yang.common;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 *
 * @param <T>
 */
public class R<T> {

  private Integer code; // 编码：1成功，0和其它数字为失败

  private String msg; // 错误信息

  private T data; // 数据

  public static <T> R<T> success(T object) {
    R<T> r = new R<T>();
    r.code = 200;
    r.msg = "success";
    r.data = object;

    return r;
  }

  public static <T> R<T> error(String msg) {
    R r = new R();
    r.code = 0;
    r.msg = msg;

    return r;
  }
}
