package com.trkj.train.config.dto.controller;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.mapper.ExpenditureAndRefundAndPurchaseAndStaffMapper;
import com.trkj.train.config.dto.service.IExpenditureAndRefundAndPurchaseAndStaffService;
import com.trkj.train.config.dto.service.IExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Expenditure")
public class ExpenditureControlle implements Serializable {
    @Autowired
    private IExpenditureService service;
    @Autowired
    private ExpenditureAndRefundAndPurchaseAndStaffMapper mapper;

    @PostMapping("/paging")
    public Result paging(@RequestBody Map<String,Object> map){
        return service.paging(map);
    }

    //    导出
    @RequestMapping("/export")
//    @PreAuthorize("hasAnyAuthority('administration:manage')")
    public Result export(HttpServletResponse response, @RequestBody Paging paging) throws Exception{
        return service.export(response,paging);
    }
    //审核通过
    @PutMapping("/update")
    public Result update(@RequestBody List<Integer> ids){
        return service.updateBatchbyid(ids);
    }

    @GetMapping("/buy/{id}")
    public Result<?> buy(@PathVariable int id,@RequestParam("staffId") int staffId,@RequestParam("remarks") String remarks) {
        String payUrl = "http://localhost:9090/alipay/pay?traceNo=" + id + "&staffId=" +staffId + "&remarks=" + remarks;

        // 新建订单，扣减库存
        return Result.success(payUrl);
    }
}
