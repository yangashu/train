package com.trkj.train.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.FinancePay;
import com.trkj.train.entity.RecruitStudent;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.FinancePayMapper;
import com.trkj.train.mapper.RecruitStudentMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.IFinancePayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class FinancePayServiceImpl extends ServiceImpl<FinancePayMapper, FinancePay> implements IFinancePayService {
    @Autowired
    private FinancePayMapper mapper;
    @Autowired
    private SysStaffMapper sysStaffMapper;
    @Autowired
    private RecruitStudentMapper studentMapper;

    @Override
    public Result paging(Page<FinancePay> financePayPage, String search) {
        Page<FinancePay> financePays = mapper.selectPage(financePayPage, null);
        List<SysStaff> sysStaffs = sysStaffMapper.selectList(null);
        List<RecruitStudent> recruitStudents = studentMapper.selectList(null);
        for (FinancePay record : financePays.getRecords()) {
            for (SysStaff sysStaff : sysStaffs) {
                if (record.getStaffId()==sysStaff.getStaffId()){
                    record.setStaff(sysStaff);
                }
            }
            for (RecruitStudent recruitStudent : recruitStudents) {
                if (record.getStudentId()==recruitStudent.getStudentId()){
                    record.setStudent(recruitStudent);
                }
            }
        }

        if (!StringUtils.isEmpty(financePays.getRecords())){
            return Result.success("200",null,financePays);
        }
        return Result.error("-1","没有你想要的数据！");
    }

    @Override
    public Result export(HttpServletResponse response) throws Exception{
        List<FinancePay> financePays = mapper.selectList(null);
        List<SysStaff> sysStaffs = sysStaffMapper.selectList(null);
        List<RecruitStudent> recruitStudents = studentMapper.selectList(null);
        for (FinancePay record : financePays) {
            for (SysStaff sysStaff : sysStaffs) {
                if (record.getStaffId()==sysStaff.getStaffId()){
                    record.setStaff(sysStaff);
                }
            }
            for (RecruitStudent recruitStudent : recruitStudents) {
                if (record.getStudentId()==recruitStudent.getStudentId()){
                    record.setStudent(recruitStudent);
                }
            }
        }
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("报名缴费列表","报名缴费信息"),FinancePay.class,financePays);
//        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","UTF-8"));
//        D:/我的学习软件/Git-2.34.1-64-bit/project/train/src/main/resources/
        FileOutputStream outputStream=new FileOutputStream("D:/我的学习软件/Git-2.34.1-64-bit/project/train/src/main/resources/export/报名缴费列表.xls");
//        System.out.println(outputStream);
//        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return Result.success("200","导出成功了",null);
    }

    @Override
    public Result saveAll(MultipartFile excelFile) throws Exception {
        ImportParams importParams=new ImportParams();
        importParams.setTitleRows(1);//标题占几行
        importParams.setHeadRows(1);//header列占几行
        List<FinancePay> revenues = ExcelImportUtil.importExcel(excelFile.getInputStream(), FinancePay.class, importParams);
        System.out.println(revenues);
        return Result.success("200","导入成功！！！",null);
    }
}
