package com.heaven.demo.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志aspect
 *
 * @author zhangjian
 * @date 2020/08/19 18:44
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    private final ObjectMapper mapper;

    @Autowired
    public LogAspect(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Pointcut("execution(* com.heaven.demo.controller.*Controller.*(..))")
    public void log() {
        log.info("init LogAspect...");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinpoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("doBefore...joinpoint：{}，request：{}", joinpoint, request);
        log.info("url:[{}], methor:[{}], parameterMap:[{}], parameterNames:[{}]", request.getRequestURL(), request.getMethod(),
                request.getParameterMap().toString(), request.getParameterNames().toString());
        for (Object object : joinpoint.getArgs()) {
            if (object instanceof MultipartFile || object instanceof HttpServletRequest
                    || object instanceof HttpServletResponse) {
                continue;
            }
            try {
                if (log.isDebugEnabled()) {
                    log.debug(joinpoint.getTarget().getClass().getName() + "." + joinpoint.getSignature().getName()
                                    + " : request parameter : " + mapper.writeValueAsString(object)
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterReturning(returning = "response", pointcut = "log()")
    public void doAfterReturning(Object response) {
        log.info("doAfterReturning...{}", response);
        if (response != null) {
            try {
                log.info("response parameter : " + mapper.writeValueAsString(response));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

}
