package com.trkj.train.config.dto.controller;

import cn.hutool.core.util.IdUtil;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.mapper.RefundAndLeaveSchoolAndStudentAndStaffMapper;
import com.trkj.train.config.dto.service.IRefundAndLeaveSchoolAndStudentAndStaffService;
import com.trkj.train.entity.EctRefund;
import com.trkj.train.mapper.EctRefundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/RefundAndLeaveSchoolAndStudentAndStaff")
public class RefundAndLeaveSchoolAndStudentAndStaffControlle implements Serializable {
    @Autowired
    private IRefundAndLeaveSchoolAndStudentAndStaffService service;

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
