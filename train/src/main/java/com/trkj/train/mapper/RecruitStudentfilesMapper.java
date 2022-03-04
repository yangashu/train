package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ConsultationDo;
import com.trkj.train.TyVo.StudentfilesQudaoDo;
import com.trkj.train.entity.RecruitStudentfiles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Mapper
public interface RecruitStudentfilesMapper extends BaseMapper<RecruitStudentfiles> {
    //咨询登记表格分页查询
    IPage<ConsultationDo> paging(Page<ConsultationDo> page);
    //渠道管理  查看学员表格分页查询
//    @Select("SELECT * FROM recruit_studentFiles s LEFT JOIN sys_staff a ON s.STAFF_ID = a.STAFF_ID WHERE channel_id=#{id}")
    IPage<StudentfilesQudaoDo> pagfye(Page<StudentfilesQudaoDo> page,@Param("id") int channelid);
    //渠道管理  查看学员表格分页查询    模糊分页查询
//    @Select("SELECT * FROM recruit_studentFiles s LEFT JOIN sys_staff a ON s.STAFF_ID = a.STAFF_ID WHERE channel_id=#{id} and STUDENTFILES_NAME like #{name}")
    IPage<StudentfilesQudaoDo> pagfyetwo(Page<StudentfilesQudaoDo> page, @Param("id") int courseId, @Param("name") String studentfilesName);

    IPage<ConsultationDo> paging1(Page<ConsultationDo> page, @Param(Constants.WRAPPER) QueryWrapper<ConsultationDo> consultationDOQueryWrapper);

//        咨询登记   搜索框查询

    IPage<ConsultationDo> selectipotion(Page page,@Param(Constants.WRAPPER) QueryWrapper<ConsultationDo> consultationDOQueryWrapper);
}
