package com.trkj.train.handler;

import com.alibaba.fastjson.JSON;
import com.trkj.train.config.Result;
import com.trkj.train.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        Result result=new Result(HttpStatus.FORBIDDEN.value()+"","权限不足");
        String json = JSON.toJSONString(result);
        //异常处理
        WebUtils.renderString(response,json);
    }
}
