package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ConsultationDo;
import com.trkj.train.TyVo.StudentfilesQudaoDo;
import com.trkj.train.entity.RecruitStudentfiles;
import com.trkj.train.mapper.RecruitStudentfilesMapper;
import com.trkj.train.service.IRecruitStudentfilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
@Transactional
@Service
public class RecruitStudentfilesServiceImpl extends ServiceImpl<RecruitStudentfilesMapper, RecruitStudentfiles> implements IRecruitStudentfilesService {
    @Autowired
    private RecruitStudentfilesMapper studentfilesMapper;
    //咨询登记表格分页查询
    @Override
    public IPage<ConsultationDo> paging(int page, int size) {
        IPage<ConsultationDo> pagess=studentfilesMapper.paging(new Page<>(page,size));
        return pagess;
    }

    @Override
    public IPage<StudentfilesQudaoDo> pagfye(int page, int size, int channelid) {
        IPage<StudentfilesQudaoDo> pagefye=studentfilesMapper.pagfye(new Page<>(page,size),channelid);
        System.out.println("////////"+pagefye.getRecords().size());
        return pagefye;
    }

    @Override
    public IPage<StudentfilesQudaoDo> likeselectstudent(int page, int size, String studentfilesName, int channelid) {
        Page<StudentfilesQudaoDo> pagesss=new Page<>(page,size);
//        QueryWrapper<Studentfiles> wrapper=new QueryWrapper<>();
//        wrapper.like("STUDENTFILES_NAME",studentfilesName);
        studentfilesName="%"+studentfilesName+"%";
        IPage<StudentfilesQudaoDo> studentpage=studentfilesMapper.pagfyetwo(pagesss,channelid,studentfilesName);
        return studentpage;
    }

//    @Override
//    public IPage<ConsultationDO> paging1(Page page,tbss tbss) {
//
//        QueryWrapper<ConsultationDO> wrapper = new QueryWrapper<ConsultationDO>();
//        wrapper.like("s.studentFiles_state",tbss.getStudentFiles_state()).or()
//                .like("a.staff_id",tbss.getStaff_id()).or()
//                .like("c.course_id",tbss.getCourse_id());
//
//        return studentfilesMapper.paging1(page,wrapper);
//    }


    //    咨询登记  下拉框快捷查询
    @Override
    public IPage<ConsultationDo> selectipton(int page, int size, String downone, String dowtwo, String dowthree,String input,String value,int deleted) {
        Page<ConsultationDo> consultationDOPage=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        List<ConsultationDo> consultationDOS=new ArrayList<>();
        if(deleted==0){
            queryWrapper.like("s.deleted",deleted);

        if(downone!=null&&downone.length()!=0){
            queryWrapper.like("s.studentFiles_state",downone);
        }else {
            System.out.println("downone为空");
        }
        if (value.equals("姓名")){
            System.out.println("aaaaaaaa");
            if (input!=null&&input.length()!=0){
                queryWrapper.like("s.STUDENTFILES_NAME",input);
            }
        }else if(value.equals("毕业学校")){
            if (input!=null&&input.length()!=0) {
                queryWrapper.like("s.studentFiles_school", input);
            }
        }
        else {
            System.out.println("input为空");
        }
        if (dowtwo!=null&&dowtwo.length()!=0){
            queryWrapper.like("a.staff_id",dowtwo);
        }else {
            System.out.println("dowtwo为空");
        }
        if (dowthree!=null&&dowthree.length()!=0){
            queryWrapper.like("c.course_id",dowthree);
        }else {
            System.out.println("dowthree为空");
        }
        }
        IPage<ConsultationDo> page1=studentfilesMapper.selectipotion(consultationDOPage,queryWrapper);
        System.out.println(page1.getRecords().toString());
        return page1;
    }
    //    咨询登记  搜索框查询
    @Override
    public IPage<ConsultationDo> selectinput(int page, int size, String value, String input,int deleted) {
        Page<ConsultationDo> consultationDOPage=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        List<ConsultationDo> consultationDOS=new ArrayList<>();
        if(deleted==0){
            queryWrapper.like("s.deleted",deleted);

        if (value=="姓名"){
            if (input!=null&&input.length()!=0){
                queryWrapper.like("s.STUDENTFILES_NAME",input);
            }
        }else if(value=="毕业学校"){
            if (input!=null&&input.length()!=0) {
                queryWrapper.like("s.studentFiles_school", input);
            }
        }
        else {
            System.out.println("input为空");
        }
        }
        IPage<ConsultationDo> pageqq=studentfilesMapper.selectipotion(consultationDOPage,queryWrapper);
        return pageqq;
    }

    @Override
    public int insertzxdj(RecruitStudentfiles recruitStudentfiles) {
        try {
            return studentfilesMapper.insert(recruitStudentfiles);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int updatestudentfiles(RecruitStudentfiles recruitStudentfiles) {
        try {
            return studentfilesMapper.updateById(recruitStudentfiles);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int deletedstudentfiles(RecruitStudentfiles recruitStudentfiles) {
        try {
            return studentfilesMapper.deleteById(recruitStudentfiles);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}
