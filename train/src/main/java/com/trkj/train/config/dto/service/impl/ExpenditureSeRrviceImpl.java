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
import com.trkj.train.config.dto.mapper.ExpenditureMapper;
import com.trkj.train.config.dto.service.IExpenditureAndRefundAndPurchaseAndStaffService;
import com.trkj.train.config.dto.service.IExpenditureService;
import com.trkj.train.config.dto.vo.Expenditure;
import com.trkj.train.config.dto.vo.ExpenditureAndRefundAndPurchaseAndStaffVo;
import com.trkj.train.entity.EctRefund;
import com.trkj.train.entity.FinancePurchase;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.EctRefundMapper;
import com.trkj.train.mapper.FinancePurchaseMapper;
import com.trkj.train.mapper.SysPersonalMapper;
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
public class ExpenditureSeRrviceImpl extends ServiceImpl<ExpenditureMapper, Expenditure> implements IExpenditureService {
    @Autowired
    private ExpenditureAndRefundAndPurchaseAndStaffMapper expenditureAndRefundAndPurchaseAndStaffMapper;
    @Autowired
    private ExpenditureMapper mapper;
    @Autowired
    private FinancePurchaseMapper purchaseMapper;
    @Autowired
    private EctRefundMapper refundMapper;
    @Autowired
    private SysStaffMapper staffMapper;
    @Autowired
    private SysPersonalMapper personalMapper;

    @Override
    public Result paging(Map<String, Object> map) {
        Paging paging = JSON.parseObject(JSON.toJSONString(map.get("Paging")), Paging.class);
        String state = JSON.parseObject(JSON.toJSONString(map.get("state")), String.class);
        Date data =JSON.parseObject(JSON.toJSONString(map.get("data")), Date.class);
        Date data1 =JSON.parseObject(JSON.toJSONString(map.get("data1")), Date.class);

        List<SysStaff> sysStaffs = staffMapper.selectList(null);
        List<FinancePurchase> financePurchases = purchaseMapper.selectList(null);
        List<EctRefund> ectRefunds = refundMapper.selectList(null);
        List<SysPersonal> personals = personalMapper.selectList(null);
        QueryWrapper<Expenditure> wrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(state)){
            if(!StringUtils.isEmpty(data) && !StringUtils.isEmpty(data1)){
                wrapper.eq("e.payApproval_state",state).and(i->i.like("s.staff_name",paging.getSearch())
                        .between("e.expenditure_date",data,data1));
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

        IPage<Expenditure> paging1 = mapper.paging(new Page(paging.getCurrentPage(),paging.getPageSize()), wrapper);
        System.out.println("paging1.getRecords().size()："+paging1.getRecords().size());
        paging1.getRecords().forEach(e->{
            sysStaffs.forEach(item->{
                if(e.getStaffId()==item.getStaffId()){
                    e.setStaff(item);
                }
            });
        });
        paging1.getRecords().forEach(e->{
            sysStaffs.forEach(item->{
                if(e.getDrawing()==item.getStaffId()){
                    e.setDrawingrepeat(item);
                }
            });
        });
        paging1.getRecords().forEach(e->{
            financePurchases.forEach(item->{
                if(e.getPurchaseId()==item.getPurchaseId()){
                    e.setFinancePurchase(item);
                }
            });
        });
        paging1.getRecords().forEach(e->{
            ectRefunds.forEach(item->{
                if(e.getRefundId()==item.getRefundId()){
                    e.setEctRefund(item);
                }
            });
        });
        paging1.getRecords().forEach(e->{
            personals.forEach(item->{
                if(e.getStaff().getPersonalId()==item.getPersonalId()){
                    e.setPersonal(item);
                }
                System.err.println("======================名字==================="+item.getPersonalName());
                System.err.println("======================编号==================="+item.getPersonalId());
                System.err.println("======================集合大小==================="+personals.size());
            });
        });
        if (!StringUtils.isEmpty(paging1.getRecords())){
            return Result.success("200",null,paging1);
        }
        return Result.error("-1","没有查到你想要的数据");
    }

    @Override
    public Result export(HttpServletResponse response, Paging paging) throws Exception{
        QueryWrapper<ExpenditureAndRefundAndPurchaseAndStaffVo> wrapper=new QueryWrapper<>();
        wrapper.like("s.staff_name",paging.getSearch());
        IPage<ExpenditureAndRefundAndPurchaseAndStaffVo> iPage1 = expenditureAndRefundAndPurchaseAndStaffMapper.paging(new Page(paging.getCurrentPage(),paging.getPageSize()),wrapper);
        UUID uuid = UUID.randomUUID();
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("校务支出列表","校务支出信息"), ExpenditureAndRefundAndPurchaseAndStaffVo.class,iPage1.getRecords());
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
