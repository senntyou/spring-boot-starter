package senntyou.sbs.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import senntyou.sbs.common.CommonResult;

// 全局异常处理
// 注：把这个文件复制到每项目的主包名下，才能生效
@ControllerAdvice
public class GlobalExceptionHandler {
  @ResponseBody
  @ExceptionHandler(value = ApiException.class)
  public CommonResult handle(ApiException e) {
    if (e.getErrorCode() != null) {
      return CommonResult.failed(e.getErrorCode());
    }
    return CommonResult.failed(e.getMessage());
  }
}
