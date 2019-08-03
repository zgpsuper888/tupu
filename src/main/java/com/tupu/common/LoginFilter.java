package com.tupu.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.tupu.domain.User;
import com.tupu.result.JsonResult;
import com.tupu.service.UserService;
import com.tupu.utils.JsonUtils;

/**
 * 登陆过滤器
 */
//@Configuration
public class LoginFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Resource
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (!(request instanceof HttpServletRequest)) {
            doErrorResponse((HttpServletResponse) response, "非法请求");
            return;
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String requestURI = httpServletRequest.getRequestURI();
        if (requestURI.endsWith("/api/user/login")) {
            chain.doFilter(request, response);
            return;
        }

        String authorization = httpServletRequest.getHeader("authorization");
        if (StringUtils.isEmpty(authorization)) {
            doErrorResponse((HttpServletResponse) response, "无登陆参数");
            return;
        }

        String[] userTokens = authorization.split("|");
        if (userTokens == null || userTokens.length != 2) {
            doErrorResponse((HttpServletResponse) response, "无登陆参数");
            return;
        }

        String userId = userTokens[0];
        String inputToken = userTokens[1];
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(inputToken)) {
            doErrorResponse((HttpServletResponse) response, "无登陆参数");
            return;
        }

        User user = userService.findUserById(Long.valueOf(userId));
        if (user == null) {
            doErrorResponse((HttpServletResponse) response, "用户不存在");
            return;
        }

        String realToken = user.getToken();
        boolean verifyToken = UserToken.verifyToken(inputToken, realToken);
        if (!verifyToken) {
            doErrorResponse((HttpServletResponse) response, "非法Token");
            return;
        }

        chain.doFilter(request, response);
    }

    private void doErrorResponse(HttpServletResponse response, String errorMsg) {
        String output = JsonUtils.object2Json(JsonResult.fail(ErrorCodeEnum.TOKEN_ERROR.getCode(), errorMsg));
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(output);
        } catch (IOException ex) {
            log.error("token failed!", ex);
        }
    }

    @Override
    public void destroy() {

    }
}