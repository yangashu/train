package com.trkj.train.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPosition;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.entity.SysStaffPosition;
import com.trkj.train.mapper.SysPositionMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.mapper.SysStaffPositionMapper;
import com.trkj.train.service.ISysStaffPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class SysStaffPositionServiceImpl extends ServiceImpl<SysStaffPositionMapper, SysStaffPosition> implements ISysStaffPositionService {
    @Autowired
    private SysPositionMapper positionMapper;
    @Autowired
    private SysStaffMapper sysStaffMapper;
    @Autowired
    private SysStaffPositionMapper mapper;
    @Override
    public Result<?> position(int id) {

        return Result.success("200",null,mapper.selectBystaffid(id));
    }

    @Override
    public Result perm(int userId, int[] roleIds) {
        List<SysStaffPosition> userRoles = new ArrayList<>();
        Arrays.stream(roleIds).forEach(roleId -> {
            SysStaffPosition userRole = new SysStaffPosition();
            userRole.setPositionId(roleId);
            userRole.setStaffId(userId);
            userRoles.add(userRole);
        });
        try{
            mapper.delete(new QueryWrapper<SysStaffPosition>().eq("staff_id", userId));
            userRoles.forEach(e->{
                mapper.insert(e);
            });
            return Result.success("200","分配成功！！！",null);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("-1","分配失败！！！");
        }

        // 清除权限信息
//        SysStaff staff = sysStaffMapper.selectById(userId);
//        sysStaffMapper.clearUserAuthorityInfo(sysUser.getUsername());

    }
}
