package com.trkj.train.config.dto.service.impl;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.LoginUser;
import com.trkj.train.config.dto.service.LoginService;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.service.ISysPersonalService;
import com.trkj.train.utils.JwtUtil;
import com.trkj.train.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysPersonalService ipersonalService;

    @Override
    public Result login(SysStaff staff){
        //AuthenticationManager authenticationManager进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(staff.getStaffName(),staff.getStaffPass());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //如果认真没通过，给出对应的提示
        if(Objects.isNull(authenticate)){
            return Result.error("-1","用户名或密码错误！！！");
//            throw new RuntimeException("用户名或密码错误！！！");
        }
        //如果认真通过了，使用staffid生成一个jwt，jtw存入Result返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        int staffId = loginUser.getStaff().getStaffId();
        String jwt = JwtUtil.createJWT(staffId+"");
        loginUser.getStaff().setToken(jwt);
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);

        loginUser.getStaff().setPersonal(ipersonalService.getById(staffId));

        //把完整的用户信息存入redis，staffid作为key
        redisCache.setCacheobject("login:"+staffId,loginUser);
        return Result.success("200","登录成功",loginUser);
    }

//    退出登录
    @Override
    public Result logout() {
        //获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        int staffId = loginUser.getStaff().getStaffId();
        //删除redis中的值
        redisCache.deleteobject("login:"+staffId);
        return new Result("200","注销成功",null);
    }
}
