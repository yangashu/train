package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.StudentDo;
import com.trkj.train.entity.RecruitStudent;
import com.trkj.train.mapper.RecruitStudentMapper;
import com.trkj.train.service.IRecruitStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    //    学员中心   分页查询
    @Override
    public IPage<StudentDo> selectpage(int page, int size) {
        IPage<StudentDo> pages= mapper.selectpage(new Page<>(page,size));
        System.out.println("sdssdfse"+pages.getRecords().toString());
        return pages;
    }
    //    学员中心 搜索直接查询
    @Override
    public IPage<StudentDo> selectipton(int page, int size, String value, String input, String downOne, boolean checked,int deleted) {
        System.out.println("input"+input);
        Page<StudentDo> pagess=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        List<StudentDo> studentDoList=new ArrayList<>();
        if(deleted==0) {
            queryWrapper.eq("s.deleted", deleted);
            if (downOne != null && downOne.length() != 0) {
                queryWrapper.eq("c.classes_id", downOne);
            } else {
                System.out.println("");
            }
            if (checked == true) {
                queryWrapper.isNull("c.classes_id");
            } else {
                System.out.println("qetw4re");
            }
            if (value.equals("学生姓名")) {
                if (input != null && input.length() != 0) {
                    queryWrapper.like("s.student_name", input);
                }
            } else if (value.equals("学生地址")) {
                if (input != null && input.length() != 0) {
                    queryWrapper.like("s.student_loc", input);
                }

            }
        }
        IPage<StudentDo> pagesa=mapper.selectipton(pagess,queryWrapper);
        return pagesa;
    }

    @Override
    public int updatestudent(RecruitStudent student) {
        return mapper.updateById(student);
    }

    @Override
    public int delectstudent(RecruitStudent student) {
        return mapper.deleteById(student);
    }

    @Override
    public IPage<RecruitStudent> selectcx(int page, int size, int classid) {
        IPage<RecruitStudent> pages= mapper.selectcx(new Page<>(page,size),classid);
        return pages;
    }

    @Override
    public IPage<RecruitStudent> selectbb(int page, int size, int classid, String studentname) {
        Page<RecruitStudent> pagess=new Page<>(page,size);
        studentname="%"+studentname+"%";
        IPage<RecruitStudent> studentIPage=mapper.selectiptionbenban(pagess,classid,studentname);
        return studentIPage;
    }
}
