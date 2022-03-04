package com.trkj.train.config.dto.controller;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.mapper.ExpenditureAndRefundAndPurchaseAndStaffMapper;
import com.trkj.train.config.dto.service.IExpenditureAndRefundAndPurchaseAndStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ExpenditureAndRefundAndPurchaseAndStaff")
public class ExpenditureAndRefundAndPurchaseAndStaffControlle implements Serializable {
    @Autowired
    private IExpenditureAndRefundAndPurchaseAndStaffService service;
    @Autowired
    private ExpenditureAndRefundAndPurchaseAndStaffMapper mapper;

    @PreAuthorize("hasAnyAuthority('finance:school','finance:school:lsit','sys:manage','sing')")
    @PostMapping("/paging")
    public Result paging(@RequestBody Map<String,Object> map){
        return service.paging(map);
    }

    //    导出
    @PreAuthorize("hasAnyAuthority('finance:school','finance:school:export','sys:manage')")
    @RequestMapping("/export")
    public Result export(HttpServletResponse response, @RequestBody Paging paging) throws Exception{
        return service.export(response,paging);
    }
    //审核通过
    @PutMapping("/update")
    public Result update(@RequestBody List<Integer> ids){
        return service.updateBatchbyid(ids);
    }

    @PreAuthorize("hasAnyAuthority('finance:school','finance:school:refund','sys:manage')")
    @GetMapping("/buy")
    public Result<?> buy(@RequestParam("id") int id,@RequestParam("staffId") int staffId,@RequestParam("remarks") String remarks) {
        String payUrl = "http://localhost:9090/alipay/pay?traceNo=" + id + "&staffId=" +staffId + "&remarks=" + remarks;

        // 新建订单，扣减库存
        return Result.success(payUrl);
    }
}
