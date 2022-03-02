package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.RecruitCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IRecruitCourseService extends IService<RecruitCourse> {
    List<RecruitCourse> selectkec();

//    课程管理 编辑
    int editbjkc(RecruitCourse recruitCourse);

//    教程入库  新增教程 课程下拉框查询
    List<RecruitCourse> selectjckc();

//    报名 课表查询
    IPage<RecruitCourse> selectkbcx(int page,int size);
//    报名 课表查询搜索
    IPage<RecruitCourse> selectbmkb(int page,int size,String kcmc);

//    课程管理 添加课程
    int insertkccoure(RecruitCourse recruitCourse);

//    分页课程查询
    IPage<RecruitCourse> selectfycoure(int page,int size);
}
