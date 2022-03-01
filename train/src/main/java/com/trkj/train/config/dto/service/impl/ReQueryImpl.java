package com.trkj.train.config.dto.service.impl;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.LoginUser;
import com.trkj.train.config.dto.service.ReQuerySerivce;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.service.ISysPersonalService;
import com.trkj.train.utils.JwtUtil;
import com.trkj.train.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ReQueryImpl implements ReQuerySerivce {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysPersonalService ipersonalService;

    @Autowired
    private PasswordEncoder bcryptPasswordEncoder;
    @Override
    public Result requery(int pass,SysStaff staff) {
        boolean a=bcryptPasswordEncoder.matches("123456",staff.getStaffPass());
        System.out.println("staff.getStaffPass()："+a);
        //AuthenticationManager authenticationManager进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(staff.getStaffName(),pass );
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //如果认真通过了，使用staffid生成一个jwt，jtw存入Result返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        int staffId = loginUser.getStaff().getStaffId();
        String jwt = JwtUtil.createJWT(staffId + "");
        loginUser.getStaff().setToken(jwt);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);


        loginUser.getStaff().setPersonal(ipersonalService.getById(staffId));
        //把完整的用户信息存入redis，staffid作为key
        redisCache.setCacheobject("login:" + staffId, loginUser);
        
        return Result.success("200", null, loginUser);
    }
}
