package com.trkj.train.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baidu.aip.util.Base64Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import com.trkj.train.entity.*;
import com.trkj.train.entity.vo.staffAndPersonal;
import com.trkj.train.mapper.*;
import com.trkj.train.service.ISysStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.train.utils.Face;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
@Transactional
@Service
public class SysStaffServiceImpl extends ServiceImpl<SysStaffMapper, SysStaff> implements ISysStaffService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysStaffMapper mapper;

    @Autowired
    private CantonSatffsignMapper signMapper;

    @Autowired
    private CantonAttendanceMapper attendanceMapper;

    @Autowired
    private SysStaffPositionMapper staffPositionMapper;

    @Autowired
    private SysPersonalMapper personalMapper;

    @Autowired
    private Face face;



    @Override
    public IPage<SysStaff> paging(Page<SysStaff> page,String search){
        IPage<SysStaff> iPage= mapper.selectPage(page,new QueryWrapper<SysStaff>().like("staff_name",search));
        List<SysPersonal> personals = personalMapper.selectList(null);
        for (int i=0;i<iPage.getRecords().size();i++){
            List<SysPosition> position = staffPositionMapper.selectBystaffid(iPage.getRecords().get(i).getStaffId());
            for (SysPersonal personal : personals) {
                if(iPage.getRecords().get(i).getPersonalId()==personal.getPersonalId()){
                    iPage.getRecords().get(i).setPersonal(personal);
                }
            }
            iPage.getRecords().get(i).setPositions(position);
        }



        return iPage;
    }

    @Override
    public Result insert(Map<String,Object> map) {


        List<Integer> ids = JSON.parseObject(JSON.toJSONString(map.get("ids")), List.class);
        SysStaff staff = JSON.parseObject(JSON.toJSONString(map.get("staff")), SysStaff.class);
        List<SysStaffPosition> staffPositions = new ArrayList<>();
        //密码加密
        String pass = passwordEncoder.encode(staff.getStaffPass());
        staff.setStaffPass(pass);
        int i = mapper.updateById(staff);
        int i1 = personalMapper.updateById(staff.getPersonal());
        if (i>0 && i1>0) {
            if (ids.size()>0 || !ids.isEmpty()) {
                for (Integer id : ids) {
                    SysStaffPosition staffPosition=new SysStaffPosition();
                    staffPosition.setStaffId(staff.getStaffId());
                    staffPosition.setPositionId(id);
                    staffPositions.add(staffPosition);
                }
                if(staff.getPositions().size()>0){
                    System.out.println(1);
                    if (staffPositionMapper.deleteByStaffId(staff.getStaffId())) {

                        if (staffPositionMapper.insertBatch(staffPositions)) {
                            return Result.success("200", "操作成功！！！", null);
                        }
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return Result.error("-1", "操作有误！！！");
                    }
                }else{
                    if (staffPositionMapper.insertBatch(staffPositions)) {
                        return Result.success("200", "操作成功！！！", null);
                    }
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return Result.error("-1", "操作有误！！！");
                }

                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error("-1", "操作有误！！！");
            }else if (staffPositionMapper.deleteByStaffId(staff.getStaffId())){

                return Result.success("200", "操作成功！！！", null);
            }
            return Result.success("200", "操作成功！！！", null);
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return Result.error("-1", "操作有误！！！");
    }

    @Override
    public Result findByid(int id) {
        SysStaff staff = mapper.findByid(id);
        staff.setPersonal(personalMapper.selectById(staff.getPersonalId()));
        staff.setPositions(staffPositionMapper.selectBystaffid(staff.getStaffId()));
        if (StringUtils.isEmpty(staff)){
            return Result.error("-1","该数据不存在或已被移除！！！");
        }
        return Result.success("200",null,staff);
    }

    @Override
    public Result<?> deleteBatchIds(List<Integer> ids) {
        if(mapper.deleteBatchIds(ids)>0){
            return Result.success("200","操作成功！！！",null);
        }
        return Result.error("-1","操作失败！！！");
    }

    @Override
    public Result<?> deleteById(int id) {
        if (mapper.deleteById(id)>0){
            return Result.success("200","操作成功！！！",null);
        }
        return Result.error("-1","操作失败,该数据可能已被移除！！！");
    }

    @Override
    public IPage<staffAndPersonal> two(int page, int size) {
        QueryWrapper<SysStaff> wrapper=new QueryWrapper();
        wrapper.orderByAsc("staff_id");
        IPage<SysStaff> iPage0=mapper.selectPage(new Page(page,size),wrapper);
        List<staffAndPersonal> list=new ArrayList<>();
        IPage<staffAndPersonal> iPage1=new Page<>();
        for (int i=0;i<iPage0.getRecords().size();i++){
            SysStaff s=iPage0.getRecords().get(i);
            SysPersonal p=personalMapper.selectOne(new QueryWrapper<SysPersonal>().eq("personal_id",s.getPersonalId()));
            staffAndPersonal sap=new staffAndPersonal();
            sap.setStaffId(s.getStaffId());
            sap.setStaffName(s.getStaffName());
            sap.setStaffPass(s.getStaffPass());
            sap.setStaffState(s.getStaffState());
            sap.setPersonalId(p.getPersonalId());
            sap.setPersonalName(p.getPersonalName());
            sap.setPersonalSex(p.getPersonalSex());
            sap.setPersonalAge(p.getPersonalAge());
            sap.setPersonalBirthday(p.getPersonalBirthday());
            sap.setPersonalIdcard(p.getPersonalIdcard());
            sap.setPersonalPhone(p.getPersonalPhone());
            sap.setPersonalMail(p.getPersonalMail());
            sap.setPersonalEducation(p.getPersonalEducation());
            sap.setPersonalNfamily(p.getPersonalNfamily());
            sap.setPersonalGraduation(p.getPersonalGraduation());
            sap.setPersonalExperience(p.getPersonalExperience());
            sap.setPersonalAddress(p.getPersonalAddress());
            sap.setPersonalPosition(p.getPersonalPosition());
            sap.setPersonalInterview(p.getPersonalInterview());
            sap.setEntryTime(p.getEntryTime());
            list.add(sap);
        }
        iPage1.setRecords(list);
        iPage1.setPages(iPage0.getPages());
        iPage1.setTotal(iPage0.getTotal());
        iPage1.setCurrent(iPage0.getCurrent());
        iPage1.setSize(iPage0.getSize());
        return iPage1;
    }


    @Override
    public IPage<staffAndPersonal> selectFace(int page,int size) {
        QueryWrapper<SysStaff> wrapper=new QueryWrapper();
        wrapper.orderByAsc("staff_id");
        IPage<SysStaff> iPage0=mapper.selectPage(new Page(page,size),wrapper);
        List<staffAndPersonal> list=new ArrayList<>();
        IPage<staffAndPersonal> iPage1=new Page<>();
        for (int i=0;i<iPage0.getRecords().size();i++){
            SysStaff s=iPage0.getRecords().get(i);
            SysPersonal p=personalMapper.selectOne(new QueryWrapper<SysPersonal>().eq("personal_id",s.getPersonalId()));
            staffAndPersonal sap=new staffAndPersonal();
            sap.setStaffId(s.getStaffId());
            sap.setStaffName(s.getStaffName());
            sap.setStaffPass(s.getStaffPass());
            sap.setStaffState(s.getStaffState());
            sap.setPersonalId(p.getPersonalId());
            sap.setPersonalName(p.getPersonalName());
            sap.setPersonalSex(p.getPersonalSex());
            sap.setPersonalAge(p.getPersonalAge());
            sap.setPersonalBirthday(p.getPersonalBirthday());
            sap.setPersonalIdcard(p.getPersonalIdcard());
            sap.setPersonalPhone(p.getPersonalPhone());
            sap.setPersonalMail(p.getPersonalMail());
            sap.setPersonalEducation(p.getPersonalEducation());
            sap.setPersonalNfamily(p.getPersonalNfamily());
            sap.setPersonalGraduation(p.getPersonalGraduation());
            sap.setPersonalExperience(p.getPersonalExperience());
            sap.setPersonalAddress(p.getPersonalAddress());
            sap.setPersonalPosition(p.getPersonalPosition());
            sap.setPersonalInterview(p.getPersonalInterview());
            sap.setEntryTime(p.getEntryTime());
            list.add(sap);
        }
        iPage1.setRecords(list);
        iPage1.setPages(iPage0.getPages());
        iPage1.setTotal(iPage0.getTotal());
        iPage1.setCurrent(iPage0.getCurrent());
        iPage1.setSize(iPage0.getSize());
        return iPage1;
    }

    //人脸更新
    @Override
    public Result updateFace(int userId,String url){
        return face.four(userId,url);
    }

    //分页模糊查询
    @Override
    public IPage<staffAndPersonal> five(Page page, String like) {
        QueryWrapper<SysPersonal> queryWrapper=new QueryWrapper();
        queryWrapper.like("personal_name",like);
        queryWrapper.eq("personal_type",0);
        IPage<SysPersonal> iPage0=personalMapper.selectPage(page,queryWrapper);
        List<staffAndPersonal> list=new ArrayList<>();
        IPage<staffAndPersonal> iPage1=new Page<>();
        for (int i=0;i<iPage0.getRecords().size();i++){
            SysPersonal p=iPage0.getRecords().get(i);
            SysStaff s=mapper.selectOne(new QueryWrapper<SysStaff>().eq("personal_id",p.getPersonalId()));
            staffAndPersonal sap=new staffAndPersonal();
            sap.setStaffId(s.getStaffId());
            sap.setStaffName(s.getStaffName());
            sap.setStaffPass(s.getStaffPass());
            sap.setStaffState(s.getStaffState());
            sap.setPersonalId(p.getPersonalId());
            sap.setPersonalName(p.getPersonalName());
            sap.setPersonalSex(p.getPersonalSex());
            sap.setPersonalAge(p.getPersonalAge());
            sap.setPersonalBirthday(p.getPersonalBirthday());
            sap.setPersonalIdcard(p.getPersonalIdcard());
            sap.setPersonalPhone(p.getPersonalPhone());
            sap.setPersonalMail(p.getPersonalMail());
            sap.setPersonalEducation(p.getPersonalEducation());
            sap.setPersonalNfamily(p.getPersonalNfamily());
            sap.setPersonalGraduation(p.getPersonalGraduation());
            sap.setPersonalExperience(p.getPersonalExperience());
            sap.setPersonalAddress(p.getPersonalAddress());
            sap.setPersonalPosition(p.getPersonalPosition());
            sap.setPersonalInterview(p.getPersonalInterview());
            sap.setEntryTime(p.getEntryTime());
            list.add(sap);
        }
        iPage1.setRecords(list);
        iPage1.setPages(iPage0.getPages());
        iPage1.setTotal(iPage0.getTotal());
        iPage1.setCurrent(iPage0.getCurrent());
        iPage1.setSize(iPage0.getSize());
        return iPage1;
    }

    //辞退员工
    @Override
    public int three(int staffId) {
        SysStaff s=mapper.selectById(staffId);
        s.setStaffState(1);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("personal_id",s.getPersonalId());
        SysPersonal p=personalMapper.selectOne(queryWrapper);
        p.setPersonalType(2);
        int i=personalMapper.updateById(p);
        return mapper.updateById(s);
    }

    //修改员工
    @Override
    public int six(staffAndPersonal sap) {
        SysPersonal p=new SysPersonal();
        p.setPersonalId(sap.getPersonalId());
        p.setPersonalName(sap.getPersonalName());
        p.setPersonalAddress(sap.getPersonalAddress());
        p.setPersonalPhone(sap.getPersonalPhone());
        p.setPersonalAge(sap.getPersonalAge());
        p.setPersonalBirthday(sap.getPersonalBirthday());
        p.setPersonalAvatar(sap.getPersonalAvatar());
        p.setPersonalExperience(sap.getPersonalExperience());
        p.setPersonalIdcard(sap.getPersonalIdcard());
        p.setPersonalGraduation(sap.getPersonalGraduation());
        p.setPersonalMail(sap.getPersonalMail());
        p.setPersonalSex(sap.getPersonalSex());
        p.setPersonalInterview(sap.getPersonalInterview());
        p.setPersonalEducation(sap.getPersonalEducation());
        p.setPersonalNfamily(sap.getPersonalNfamily());
        int i=personalMapper.updateById(p);
        return i;
    }

    //恢复员工
    @Override
    public int four(int staffId) {
        SysStaff s=mapper.selectById(staffId);
        s.setStaffState(0);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("personal_id",s.getPersonalId());
        SysPersonal p=personalMapper.selectOne(queryWrapper);
        p.setPersonalType(1);
        int i=personalMapper.updateById(p);
        return mapper.updateById(s);
    }

    //获取员工账号
    @Override
    public String selectStaffName() {
        String maxStaffName=mapper.selectNameMax();
        int a=Integer.parseInt(maxStaffName.substring(5))+1;
        if(a<10){
            maxStaffName="train00"+a;
        }else if(a>10 && a<100){
            maxStaffName="train0"+a;
        }else{
            maxStaffName="train"+a;
        }
        return maxStaffName;
    }

    //修改密码
    @Override
    public Result updatePass(int staffId, String oldPass, String newPass) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("staff_id",staffId);
        SysStaff staff=mapper.selectOne(wrapper);
        System.out.println(passwordEncoder.matches(oldPass,staff.getStaffPass()));
        if(passwordEncoder.matches(oldPass,staff.getStaffPass())){
            newPass=passwordEncoder.encode(newPass);
            staff.setStaffPass(newPass);
            try {
                int i=mapper.updateById(staff);
                return Result.success("1","修改密码成功",i);
            }catch (Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Result.error("0","操作失败");
            }
        }else{
            return Result.error("0","原密码错误");
        }
    }

    //员工入职
    @Override
    public Result addStaff(SysStaff staff) {
        try {
            staff.setStaffState(0);
            staff.setDeleted(0);
            staff.setStaffPass(passwordEncoder.encode(staff.getStaffPass()));
            int i=mapper.insert(staff);
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("personal_id",staff.getPersonalId());
            SysPersonal personal=personalMapper.selectOne(wrapper);
            personal.setPersonalType(0);
            int j=personalMapper.updateById(personal);
            return Result.success("0","入职成功",i);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("1","出错误了，请等待维修");
        }
    }

    //注册人脸
    @Override
    public Result addUser(String url) throws Exception {
        Result result=face.two(url);
        if(result.getCode().equals("-1")){
            return result;
        }else{
        int staffId=mapper.selectIdMax();
        CantonSatffsign sign=new CantonSatffsign();
        sign.setSignState(0);
        sign.setSignDate(new Date());
        sign.setStaffId(staffId);
        sign.setDeleted(0);
        CantonAttendance attendance=new CantonAttendance();
        attendance.setAttendanceDate(new Date());
        attendance.setStaffId(staffId);
        attendance.setDeleted(0);
        try{
            int i=signMapper.insert(sign);
            int j=attendanceMapper.insert(attendance);
            if(i>0){
                return face.one(staffId,url);
            }else{
                return Result.error("1","出错了！！！");
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("1","出错误了，请等待维修");
        }
        }
    }




    //查询是班主任职位的员工
    @Override
    public List<SysStaff> insertstaff() {
        return mapper.selectstaff();
    }

    @Override
    public List<SysStaff> selectgjr() {
        return mapper.selectgjr();
    }

    @Override
    public List<SysStaff> selectclassteacher() {
        return mapper.selectclassteacher();
    }
}
