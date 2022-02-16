package com.trkj.train.config.dto.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.mapper.PayAndStaffAndstudentVoMapper;
import com.trkj.train.config.dto.service.IPayAndStaffAndstudentService;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import com.trkj.train.entity.FinancePay;
import com.trkj.train.entity.RecruitStudent;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.FinancePayMapper;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PayAndStaffAndstudentServiceImpl extends ServiceImpl<PayAndStaffAndstudentVoMapper, PayAndStaffAndstudentVo> implements IPayAndStaffAndstudentService {
    @Autowired
    private PayAndStaffAndstudentVoMapper mapper;
    @Autowired
    private FinancePayMapper payMapper;
    @Override
    public Result paging(Map<String,Object> map) {
        Paging paging = JSON.parseObject(JSON.toJSONString(map.get("Paging")), Paging.class);
        String state = JSON.parseObject(JSON.toJSONString(map.get("state")), String.class);
        Date data =JSON.parseObject(JSON.toJSONString(map.get("data")), Date.class);
        Date data1 =JSON.parseObject(JSON.toJSONString(map.get("data1")), Date.class);
        QueryWrapper<PayAndStaffAndstudentVo> wrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(state)){
            if(!StringUtils.isEmpty(data) && !StringUtils.isEmpty(data1)){
                wrapper.eq("p.income_state",state).and(i->i.like("stu.student_name",paging.getSearch())
                .between("p.paymoney_date",data,data1));
            }else{
                wrapper.eq("p.income_state",state).and(i->i.like("stu.student_name",paging.getSearch()));
            }
        }else if(!StringUtils.isEmpty(data) && !StringUtils.isEmpty(data1)){
            if(!StringUtils.isEmpty(state)){
                wrapper.between("p.paymoney_date",data,data1).and(i->i.like("stu.student_name",paging.getSearch())
                        .eq("p.income_state",state));
            }else{
                wrapper.between("p.paymoney_date",data,data1).and(i->i.like("stu.student_name",paging.getSearch()));
            }

        }else{
            wrapper.like("s.staff_name",paging.getSearch()).or()
                    .like("stu.student_name",paging.getSearch()).or()
                    .like("p.payMoney_date",paging.getSearch()).or()
                    .like("p.payMoney_mode",paging.getSearch()).or();
        }

        IPage<PayAndStaffAndstudentVo> paging1 = mapper.paging(new Page(paging.getCurrentPage(),paging.getPageSize()), wrapper);
        if (!StringUtils.isEmpty(paging1.getRecords())){
            return Result.success("200",null,paging1);
        }
        return Result.error("-1","没有查到你想要的数据");
    }

    //导出
    @Override
    public Result export(HttpServletResponse response, Paging paging) throws Exception {
        QueryWrapper<PayAndStaffAndstudentVo> wrapper=new QueryWrapper<>();
        wrapper.like("s.staff_name",paging.getSearch()).or()
                .like("stu.student_name",paging.getSearch()).or()
                .like("p.payMoney_date",paging.getSearch()).or()
                .like("p.payMoney_mode",paging.getSearch()).or();
        IPage<PayAndStaffAndstudentVo> iPage1 = mapper.paging(new Page(paging.getCurrentPage(),paging.getPageSize()),wrapper);
        UUID uuid = UUID.randomUUID();
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("报名缴费列表","报名缴费信息"),PayAndStaffAndstudentVo.class,iPage1.getRecords());
//        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","UTF-8"));
//        D:/我的学习软件/Git-2.34.1-64-bit/project/train/src/main/resources/
            FileOutputStream outputStream=new FileOutputStream("F:/projectIdea/train/src/main/resources/export/报名缴费列表.xls");
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
            ImportParams importParams=new ImportParams();
            importParams.setTitleRows(1);//标题占几行
            importParams.setHeadRows(1);//header列占几行
            List<FinancePay> revenues = ExcelImportUtil.importExcel(excelFile.getInputStream(), FinancePay.class, importParams);
        List<FinancePay> financePays = payMapper.selectList(null);
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //格式化当前系统日期
        revenues.forEach(item->{
            financePays.forEach(e->{
                if (dateFm.format(item.getPaymoneyDate()).equals(dateFm.format(e.getPaymoneyDate()))){
                    item.setStaffId(e.getStaffId());
                    if (StringUtils.isEmpty(e.getCourseId())){
                        item.setCourseId(null);
                    }else{
                        item.setCourseId(e.getCourseId());
                    }

                    item.setStudentId(e.getStudentId());
                    item.setDeleted((e.getDeleted()));

                }
            });
            payMapper.saveAll(item);
            });

            return Result.success("200","导入成功！！！",null);
    }

    //审核通过
    @Transactional
    @Override
    public Result updateBatchbyid(List<Integer> ids) {

        int i=0;
        for (Integer id : ids) {
           int x = mapper.updatebyid(id);
            if(x>0){
                i++;
            }
        }
        if (ids.size()==i){
            return Result.success("200","操作成功！！！",null);
        }else{
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error("-1","操作有误！！！");
        }
    }

    // 根据id导出
    @Override
    public Result exportByid(HttpServletResponse response, int id) throws Exception {
        List<PayAndStaffAndstudentVo> selectbyid = mapper.selectbyid(id);
        UUID uuid = UUID.randomUUID();
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("个人报名缴费",selectbyid.get(0).getStudentName()+"报名缴费信息")
                ,PayAndStaffAndstudentVo.class,selectbyid);
//        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","UTF-8"));
//        D:/我的学习软件/Git-2.34.1-64-bit/project/train/src/main/resources/
       String stuname=workbook.getSheetName(0);
        FileOutputStream outputStream=new FileOutputStream("D:/我的学习软件/Git-2.34.1-64-bit/project/train/src/main/resources/export/"+stuname+".xls");
//        System.out.println(outputStream);
//        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return Result.success("200","导出成功了",null);
    }


}
