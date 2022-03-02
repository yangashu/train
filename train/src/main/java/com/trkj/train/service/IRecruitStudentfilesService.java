package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.ConsultationDo;
import com.trkj.train.TyVo.StudentfilesQudaoDo;
import com.trkj.train.entity.RecruitStudentfiles;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IRecruitStudentfilesService extends IService<RecruitStudentfiles> {
    //    咨询登记表格分页查询
    IPage<ConsultationDo> paging(int page, int size);
    //渠道管理  查看学员表格分页查询
    IPage<StudentfilesQudaoDo> pagfye(int page, int size, int channelid);
    //    渠道管理  查看学员弹框模糊分页查询
    IPage<StudentfilesQudaoDo> likeselectstudent(int page, int size, String studentfilesName, int channelid);
//    咨询登记  下拉框快捷查询
//    IPage<Studentfiles> likeselectstudentfile(int page, int size, tbss);

//    IPage<ConsultationDO> paging1(Page page, tbss tbss);
    //    咨询登记  下拉框快捷查询
    IPage<ConsultationDo> selectipton(int page, int size, String downone, String dowtwo, String dowthree, String input, String value,int deleted);
    //    咨询登记  搜索框查询
    IPage<ConsultationDo> selectinput(int page,int size,String value,String input,int deleted);

//    咨询登记 新增
    int insertzxdj(RecruitStudentfiles recruitStudentfiles);

//    咨询登记 修改状态为已流失
    int updatestudentfiles(RecruitStudentfiles recruitStudentfiles);

//    删除
    int deletedstudentfiles(RecruitStudentfiles recruitStudentfiles);
}
