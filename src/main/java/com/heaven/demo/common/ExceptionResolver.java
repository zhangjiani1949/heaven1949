package com.heaven.demo.common;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author zhangjian
 * @date 2020/08/19 16:41
 */
@Slf4j
@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(ApiException.class)
    public R apiExceptionHandler(HttpServletRequest request, ApiException e) {
        log.info("ApiException异常：", e.getMessage());
        return R.failed(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R exceptionHandler(HttpServletRequest request, Exception e) {
        log.info("Exception异常：", e.getMessage());
        return R.failed(e.getMessage());
    }

}
