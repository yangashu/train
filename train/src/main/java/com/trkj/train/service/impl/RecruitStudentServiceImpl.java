package com.trkj.train.service.impl;

import com.trkj.train.entity.RecruitStudent;
import com.trkj.train.mapper.RecruitStudentMapper;
import com.trkj.train.service.IRecruitStudentService;
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
public class RecruitStudentServiceImpl extends ServiceImpl<RecruitStudentMapper, RecruitStudent> implements IRecruitStudentService {

    @Autowired
    private RecruitStudentMapper mapper;

    @Override
    public List<RecruitStudent> one() {
        return mapper.selectList(null);
    }
}
