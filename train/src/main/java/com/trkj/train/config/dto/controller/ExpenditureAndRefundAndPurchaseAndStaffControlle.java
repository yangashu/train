package com.trkj.train.config.dto.controller;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
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
}
