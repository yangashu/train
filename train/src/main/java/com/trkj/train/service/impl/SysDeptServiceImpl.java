package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.entity.SysDept;
import com.trkj.train.mapper.SysDeptMapper;
import com.trkj.train.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Autowired
    private SysDeptMapper mapper;

    @Override
    public List<SysDept> selectDeptList() {
        return mapper.selectList(new QueryWrapper<SysDept>().orderByAsc("dept_id"));
    }
}
