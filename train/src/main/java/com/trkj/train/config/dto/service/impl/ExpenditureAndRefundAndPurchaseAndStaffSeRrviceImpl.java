package com.trkj.train.config.dto.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.mapper.ExpenditureAndRefundAndPurchaseAndStaffMapper;
import com.trkj.train.config.dto.service.IExpenditureAndRefundAndPurchaseAndStaffService;
import com.trkj.train.config.dto.vo.ExpenditureAndRefundAndPurchaseAndStaffVo;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.SysStaffMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ExpenditureAndRefundAndPurchaseAndStaffSeRrviceImpl extends ServiceImpl<ExpenditureAndRefundAndPurchaseAndStaffMapper, ExpenditureAndRefundAndPurchaseAndStaffVo> implements IExpenditureAndRefundAndPurchaseAndStaffService {
    @Autowired
    private ExpenditureAndRefundAndPurchaseAndStaffMapper mapper;
    @Autowired
    private SysStaffMapper staffMapper;

    @Override
    public Result paging(Map<String, Object> map) {
        Paging paging = JSON.parseObject(JSON.toJSONString(map.get("Paging")), Paging.class);
        String state = JSON.parseObject(JSON.toJSONString(map.get("state")), String.class);
        Date data =JSON.parseObject(JSON.toJSONString(map.get("data")), Date.class);
        Date data1 =JSON.parseObject(JSON.toJSONString(map.get("data1")), Date.class);

        List<SysStaff> sysStaffs = staffMapper.selectList(null);
        QueryWrapper<ExpenditureAndRefundAndPurchaseAndStaffVo> wrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(state)){
            if(!StringUtils.isEmpty(data) && !StringUtils.isEmpty(data1)){
                wrapper.eq("e.payApproval_state",state).and(i->i.like("s.staff_name",paging.getSearch())
                        .between("p.paymoney_date",data,data1));
            }else{
                wrapper.eq("e.payApproval_state",state).and(i->i.like("s.staff_name",paging.getSearch()));
            }
        }else if(!StringUtils.isEmpty(data) && !StringUtils.isEmpty(data1)){
            if(!StringUtils.isEmpty(state)){
                wrapper.between("e.expenditure_date",data,data1).and(i->i.like("s.staff_name",paging.getSearch())
                        .eq("e.payApproval_state",state));
            }else{
                wrapper.between("e.expenditure_date",data,data1).and(i->i.like("s.staff_name",paging.getSearch()));
            }

        }else{
            wrapper.like("s.staff_name",paging.getSearch());
        }

        IPage<ExpenditureAndRefundAndPurchaseAndStaffVo> paging1 = mapper.paging(new Page(paging.getCurrentPage(),paging.getPageSize()), wrapper);
        for (ExpenditureAndRefundAndPurchaseAndStaffVo record : paging1.getRecords()) {
            for (SysStaff sysStaff : sysStaffs) {
                if (sysStaff.getStaffId()==record.getDrawing()){
                    record.setDrawingName(sysStaff.getStaffName());
                }
            }

        }
        if (!StringUtils.isEmpty(paging1.getRecords())){
            return Result.success("200",null,paging1);
        }
        return Result.error("-1","没有查到你想要的数据");
    }

    @Override
    public Result export(HttpServletResponse response, Paging paging) throws Exception{
        QueryWrapper<ExpenditureAndRefundAndPurchaseAndStaffVo> wrapper=new QueryWrapper<>();
        wrapper.like("s.staff_name",paging.getSearch());
        IPage<ExpenditureAndRefundAndPurchaseAndStaffVo> iPage1 = mapper.paging(new Page(paging.getCurrentPage(),paging.getPageSize()),wrapper);
        UUID uuid = UUID.randomUUID();
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("校务支出列表","校务支出信息"),ExpenditureAndRefundAndPurchaseAndStaffVo.class,iPage1.getRecords());
//        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","UTF-8"));
//        D:/我的学习软件/Git-2.34.1-64-bit/project/train/src/main/resources/
        FileOutputStream outputStream=new FileOutputStream("F:/projectIdea/train/src/main/resources/export/校务支出列表.xls");
//        System.out.println(outputStream);
//        ServletOutputStream outputStream= response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return Result.success("200","导出成功了",null);
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
}
