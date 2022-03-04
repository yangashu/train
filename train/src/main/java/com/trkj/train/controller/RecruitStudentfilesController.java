package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.ConsultationDo;
import com.trkj.train.TyVo.StudentfilesQudaoDo;
import com.trkj.train.entity.RecruitStudentfiles;
import com.trkj.train.service.IRecruitStudentfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/recruit-studentfiles")
public class RecruitStudentfilesController {
    @Autowired
    private IRecruitStudentfilesService iStudentfilesService;
    //    咨询登记表格分页查询
    @GetMapping("/selectpage")
    public IPage<ConsultationDo> selectpage(@RequestParam("currentPage") int page, @RequestParam("size") int size){
        IPage<ConsultationDo> selectpag=iStudentfilesService.paging(page,size);
        return selectpag;
    }
    //    渠道管理 查看学员表格分页查询
    @GetMapping("/selectstudentfiles")
    private IPage<StudentfilesQudaoDo> selectstudentfiles(@RequestParam("currentPage") int page, @RequestParam("size") int size, @RequestParam("channelid") int channelid){
        System.out.println("page"+page+"size"+size+"");
        IPage<StudentfilesQudaoDo> selectstudenmt=iStudentfilesService.pagfye(page,size,channelid);
        return selectstudenmt;
    }
    //    渠道管理  查看学员弹框模糊分页查询
    @GetMapping("/likeselectstudent")
    public IPage<StudentfilesQudaoDo> likeselectstudent(@RequestParam("currentPage") int page,@RequestParam("size") int size,@RequestParam("shoushuokuan") String studentfilesName,@RequestParam("channelid") int channelid){
        IPage<StudentfilesQudaoDo> studentfilesIPage=iStudentfilesService.likeselectstudent(page, size, studentfilesName,channelid);
        return studentfilesIPage;
    }

    //    咨询登记   模糊查询
//    @PostMapping("/likestudentfiles")
//    public IPage<ConsultationDO> likestudentfiles(@RequestBody tbss tbssw){
//        IPage<ConsultationDO> selectpag=iStudentfilesService.paging1(new Page(tbssw.getCurrentPage(),tbssw.getSize()),tbssw);
//        System.out.println("aaa"+tbssw);
//        for (ConsultationDO record : selectpag.getRecords()) {
//            System.out.println("record"+record);
//        }
//        return selectpag;
//    }

    //    咨询登记   模糊查询
    @GetMapping("/likeselectipton")
    public IPage<ConsultationDo> likeselectipton(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("downone") String downone,@RequestParam("dowtwo") String dowtwo,@RequestParam("dowthree") String dowthree,@RequestParam("input") String input,@RequestParam("value") String value,@RequestParam("deleted") int deleted){
        IPage<ConsultationDo> consultationDOIPage=iStudentfilesService.selectipton(page, size, downone, dowtwo, dowthree, input,value,deleted);
        return consultationDOIPage;
    }

    //    咨询登记  搜索框查询
    @GetMapping("/selectinput")
    public IPage<ConsultationDo> selectinput(){
        return null;
    }

//    咨询登记 添加
    @PostMapping("/insertzxdj")
    public int insertzxdj(@RequestBody RecruitStudentfiles recruitStudentfiles){
        return iStudentfilesService.insertzxdj(recruitStudentfiles);
    }

    //    咨询登记 修改状态为已流失
    @PostMapping("/updatestudentfiles")
    public int updatestudentfiles(@RequestBody RecruitStudentfiles recruitStudentfiles){
        return iStudentfilesService.updatestudentfiles(recruitStudentfiles);
    }

//    删除
    @PostMapping("/deletedstudentfiles")
    public int deletedstudentfiles(@RequestBody RecruitStudentfiles recruitStudentfiles){
        return iStudentfilesService.deletedstudentfiles(recruitStudentfiles);
    }
}
