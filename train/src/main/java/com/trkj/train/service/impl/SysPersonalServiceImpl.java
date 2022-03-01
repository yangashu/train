package com.trkj.train.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import com.trkj.train.entity.CantonSatffsign;
import com.trkj.train.entity.FinancePay;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.entity.vo.staffAndSign;
import com.trkj.train.mapper.SysPersonalMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.ICantonSatffsignService;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.ISysPersonalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.datatransfer.DataFlavor;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class SysPersonalServiceImpl extends ServiceImpl<SysPersonalMapper, SysPersonal> implements ISysPersonalService {

    @Autowired
    private SysPersonalMapper sysPersonalMapper;

    @Autowired
    private SysPersonalMapper mapper;

    @Autowired
    private ICantonSatffsignService service;

    @Autowired
    private SysStaffMapper staffMapper;

    //员工打卡分页查询用到的方法
    @Override
    public SysPersonal one(int personalId) {
//        System.out.println(staffId);
        QueryWrapper<SysPersonal> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("personal_id",personalId);
        SysPersonal personal=mapper.selectOne(queryWrapper);
        return personal;
    }

    //员工打卡模糊查询分页用的方法
    @Override
    public IPage<staffAndSign> two(String information, String mode, int page, int size) {
        QueryWrapper<SysPersonal> queryWrapper = new QueryWrapper<>();
        if(mode.equals("员工姓名")){
            queryWrapper.like("PERSONAL_NAME",information);
        }else if(mode.equals("联系电话")){
            queryWrapper.like("PERSONAL_PHONE",information);
        }
        queryWrapper.eq("personal_type",0);
        queryWrapper.orderByAsc("personal_id");
        IPage<SysPersonal> iPage0=mapper.selectPage(new Page(page,size),queryWrapper);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        IPage<staffAndSign> iPage=new Page<>();
        List<staffAndSign> list=new ArrayList<>();
        for(int i=0;i<iPage0.getRecords().size();i++){
            QueryWrapper q=new QueryWrapper();
            q.eq("personal_id",iPage0.getRecords().get(i).getPersonalId());
            SysStaff staff=staffMapper.selectOne(q);
            System.out.println("id："+iPage0.getRecords().get(i).getPersonalId());
            System.out.println("实体类"+staff.toString());
            CantonSatffsign s=service.three(staff.getStaffId());
            staffAndSign ss=new staffAndSign();
            ss.setSignId(s.getSignId());
            ss.setStaffId(staff.getStaffId());
            ss.setPersonalName(iPage0.getRecords().get(i).getPersonalName());
            ss.setPersonalPhone(iPage0.getRecords().get(i).getPersonalPhone());
            ss.setSignDate(s.getSignDate());
            String newDate=format.format(new Date());
            String oldDate= format.format(s.getSignDate());;
            if(newDate.equals(oldDate) && s.getSignState()==0){
                ss.setSignState(2);
            }else if(newDate.equals(oldDate) && s.getSignState()==1){
                ss.setSignState(1);
            }else{
                ss.setSignState(0);
            }
            list.add(ss);
        }
        iPage.setCurrent(iPage0.getCurrent());
        iPage.setPages(iPage0.getPages());
        iPage.setTotal(iPage0.getTotal());
        iPage.setSize(iPage0.getSize());
        iPage.setRecords(list);
        return iPage;
    }

    @Override
    public int xiugai(SysPersonal sysPersonal) {
    @Override
    public IPage<SysPersonal> selectPer(int page,int size) {
        QueryWrapper<SysPersonal> wrapper=new QueryWrapper();
        wrapper.eq("personal_type",1);
        return mapper.selectPage(new Page(page,size),wrapper);
    }

        return sysPersonalMapper.updateById(sysPersonal);
    }
    //导出
    @Override
    public Result export(HttpServletResponse response, Paging paging)throws Exception {
        QueryWrapper<SysPersonal> wrapper=new QueryWrapper<>();
        wrapper.eq("personal_type",1);
//        IPage<SysPersonal> iPage1 = mapper.selectPage(new Page(paging.getCurrentPage(),paging.getPageSize()),wrapper);
        List<SysPersonal> list=mapper.selectList(wrapper);
//        UUID uuid = UUID.randomUUID();
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("员工档案","员工档案"),SysPersonal.class,list);
//        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","UTF-8"));
//        D:/我的学习软件/Git-2.34.1-64-bit/project/train/src/main/resources/
        FileOutputStream outputStream=new FileOutputStream("F:/projectIdea/train/src/main/resources/export/员工简历.xls");
//        System.out.println(outputStream);
//        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return Result.success("200","导出成功了",null);
    }
    //导入
    @Override
    public Result saveAll(MultipartFile excelFile) throws Exception {
        System.out.println(excelFile.getName());
        ImportParams importParams=new ImportParams();
        importParams.setTitleRows(1);//标题占几行
        importParams.setHeadRows(1);//header列占几行
        List<SysPersonal> revenues = ExcelImportUtil.importExcel(excelFile.getInputStream(), SysPersonal.class, importParams);
        revenues.forEach(item->{
            if(StringUtils.isEmpty(item.getPersonalAvatar())){
               item.setPersonalAvatar("");
            }
            if(StringUtils.isEmpty(item.getPersonalExperience())){
                item.setPersonalExperience("");
            }
            item.setDeleted(0);
            mapper.saveAll(item);
        });

        return Result.success("200","导入成功！！！",null);
    }

    //分页模糊查询方法
    @Override
    public IPage<SysPersonal> likePersonal(Page page, String like) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("personal_type",1);
        wrapper.like("personal_name",like);
        return mapper.selectPage(page,wrapper);
    }
}
