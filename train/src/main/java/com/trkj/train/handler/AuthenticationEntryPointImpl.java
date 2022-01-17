package com.trkj.train.handler;

import com.alibaba.fastjson.JSON;
import com.trkj.train.config.Result;
import com.trkj.train.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Result result=new Result(HttpStatus.UNAUTHORIZED.value()+"","身份过期，请重新登录");
        String json = JSON.toJSONString(result);
        //异常处理
        WebUtils.renderString(response,json);
    }
}
