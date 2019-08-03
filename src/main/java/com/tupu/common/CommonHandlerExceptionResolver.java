package com.tupu.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tupu.result.JsonResult;

@Configuration
@ControllerAdvice
public class CommonHandlerExceptionResolver {
    private Logger log = LoggerFactory.getLogger(CommonHandlerExceptionResolver.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView resolveException(HttpServletRequest request, Exception e) {

        log.error("系统错误,uri:{}.", request.getRequestURI(), e);

        JsonResult failJsonResult = JsonResult.fail(ErrorCodeEnum.SYSTEM_ERROR);
        return new ModelAndView("", "jsonResult", failJsonResult);
    }
}
