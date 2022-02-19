package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.StudentDo;
import com.trkj.train.entity.RecruitChannel;
import com.trkj.train.entity.RecruitStudent;
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
public interface IRecruitStudentService extends IService<RecruitStudent> {
    public List<RecruitStudent> one();

    //    学员中心   分页查询
    public IPage<StudentDo> selectpage(int page, int size);
    //    学员中心 搜索直接查询
     IPage<StudentDo> selectipton(int page,int size,String value,String input,String downOne,boolean checked,int deleted);

//    学员中心  在读学员  修改
     int updatestudent(RecruitStudent student);

//     学员中心  在读学员 删除
     int delectstudent(RecruitStudent student);

//     班级管理   本班学员弹框内容查询
    IPage<RecruitStudent> selectcx(int page,int size,int classid);

//    班级管理  本班学员弹框  搜索
    IPage<RecruitStudent> selectbb(int page, int size,int classid,String studentname);
}
