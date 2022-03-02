package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.RecruitChannel;
import com.trkj.train.entity.RecruitCourse;
import com.trkj.train.mapper.RecruitCourseMapper;
import com.trkj.train.service.IRecruitCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Transactional
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
        try {
            return courseMapper.updateById(recruitCourse);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public List<RecruitCourse> selectjckc() {
        return courseMapper.selectList(null);
    }

    @Override
    public IPage<RecruitCourse> selectkbcx(int page, int size) {
        IPage<RecruitCourse> recruitCourseIPage=courseMapper.selectPage(new Page<>(page,size),null);
        return recruitCourseIPage;
    }

    @Override
    public IPage<RecruitCourse> selectbmkb(int page, int size,String kcmc) {
        QueryWrapper<RecruitCourse> queryWrapper=new QueryWrapper<>();
        if (kcmc!=null && kcmc.length()!=0){
            queryWrapper.like("COURSE_NAME",kcmc);
        }
        IPage<RecruitCourse> page2=courseMapper.selectPage(new Page<>(page,size),queryWrapper);
        return page2;
    }

    @Override
    public int insertkccoure(RecruitCourse recruitCourse) {
        try {
            return courseMapper.insert(recruitCourse);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public IPage<RecruitCourse> selectfycoure(int page, int size) {
        Page page1=new Page(page,size);
        IPage<RecruitCourse> page2=courseMapper.selectPage(page1,null);
        return page2;
    }

}
