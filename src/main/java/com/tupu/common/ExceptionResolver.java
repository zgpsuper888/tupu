package com.tupu.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tupu.result.JsonResult;

@ResponseBody
@ControllerAdvice
public class ExceptionResolver {
    private Logger log = LoggerFactory.getLogger(ExceptionResolver.class);

    @ExceptionHandler(value = Exception.class)
    public JsonResult resolveException(HttpServletRequest httpServletRequest, Exception e) {
        log.error("系统错误,uri:{}.", httpServletRequest.getRequestURI(), e);

        return JsonResult.fail(ErrorCodeEnum.SYSTEM_ERROR);
    }
}
