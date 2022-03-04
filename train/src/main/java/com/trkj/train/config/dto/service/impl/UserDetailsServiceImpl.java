package com.trkj.train.config.dto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.LoginUser;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.SysMenuMapper;
import com.trkj.train.mapper.SysStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysStaffMapper staffMapper;
    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<SysStaff> wrapper=new LambdaQueryWrapper<SysStaff>();
        wrapper.eq(SysStaff::getStaffName,username);
        SysStaff staff=staffMapper.selectOne(wrapper);
        //如果没有查询到用户就抛出异常
        if(Objects.isNull(staff)){
//            return Result.error("-1","用户名或密码错误");
            throw new RuntimeException("用户名或密码错误");
        }
        //TODO 查询权限信息
        List<String> list = menuMapper.selectPermsByStaffId(staff.getStaffId());
        //把数据封装UserDetails返回
        return new LoginUser(staff,list);
    }
}
