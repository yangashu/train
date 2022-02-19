package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.RecruitChannel;
import com.trkj.train.entity.RecruitCourse;
import com.trkj.train.mapper.RecruitCourseMapper;
import com.trkj.train.service.IRecruitCourseService;
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
public class RecruitCourseServiceImpl extends ServiceImpl<RecruitCourseMapper, RecruitCourse> implements IRecruitCourseService {
    @Autowired
    private RecruitCourseMapper courseMapper;
    //    查询所有课程
    @Override
    public List<RecruitCourse> selectkec() {
        return courseMapper.selectList(null);
    }

    @Override
    public int editbjkc(RecruitCourse recruitCourse) {
        return courseMapper.updateById(recruitCourse);
    }

}
