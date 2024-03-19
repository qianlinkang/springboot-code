package org.sboot.ssmp.exception;

import lombok.extern.slf4j.Slf4j;
import org.sboot.ssmp.enums.ResultCodeEnum;
import org.sboot.ssmp.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局系统异常处理器
 * <p>
 * 调整异常处理的HTTP状态码，丰富异常处理类型
 *
 * @author Gadfly
 * @since 2020-02-25 13:54
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public <T> Result<T> doException(Exception ex) {
        ex.printStackTrace();
        return Result.fail(null, ResultCodeEnum.SERVICE_ERROR);
    }

}
