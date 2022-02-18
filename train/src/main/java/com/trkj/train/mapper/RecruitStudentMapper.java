package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.StudentDo;
import com.trkj.train.entity.RecruitStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface RecruitStudentMapper extends BaseMapper<RecruitStudent> {
    //    学员中心  分页查询
    IPage<StudentDo> selectpage(Page<StudentDo> page);
    //    学员中心   搜索直接查询
    IPage<StudentDo> selectipton(Page page,@Param(Constants.WRAPPER) QueryWrapper<StudentDo> consultationDOQueryWrapper);

//    班级管理   本班学员弹框内容查询
    @Select("select * from recruit_student WHERE classes_id=#{classid}")
    IPage<RecruitStudent> selectcx(Page page,@Param("classid") int classid);

//    班级管理  本班学员弹框 搜索
    @Select("select * from recruit_student  WHERE classes_id=#{classid} and student_name like #{studentname}")
    IPage<RecruitStudent> selectiptionbenban(Page page,@Param("classid") int classid,@Param("studentname") String studentname);
}
