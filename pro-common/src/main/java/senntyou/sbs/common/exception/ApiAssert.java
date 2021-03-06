package senntyou.sbs.common.exception;

import senntyou.sbs.common.IErrorCode;

// 断言处理类，用于抛出各种API异常
public class ApiAssert {
  public static void fail(String message) {
    throw new ApiException(message);
  }

  public static void fail(IErrorCode errorCode) {
    throw new ApiException(errorCode);
  }
}
