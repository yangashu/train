package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.mapper.SysPersonalMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.ISysPersonalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class SysPersonalServiceImpl extends ServiceImpl<SysPersonalMapper, SysPersonal> implements ISysPersonalService {

    @Autowired
    private SysPersonalMapper sysPersonalMapper;

    @Override
    public int xiugai(SysPersonal sysPersonal) {

        return sysPersonalMapper.updateById(sysPersonal);
    }
}
