package com.trkj.train.config.dto.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.service.IPayAndStaffAndstudentService;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/PayAndStaffAndstudent")
public class PayAndStaffAndstudentController implements Serializable {
    @Autowired
    private IPayAndStaffAndstudentService service;

    @PreAuthorize("hasAnyAuthority('finance:payment:list','sys:manage')")
    @PostMapping("/paging")
    public Result paging(@RequestBody Map<String,Object> map){
        return service.paging(map);
    }

    //    导入
    @PreAuthorize("hasAnyAuthority('finance:payment:Import','sys:manage')")
    @PostMapping("/import")
    private Result importExcel(@RequestParam("file") MultipartFile excelFile) throws Exception{
        return service.saveAll(excelFile);
    }

    //    导出
    @PreAuthorize("hasAnyAuthority('finance:payment:export','sys:manage')")
    @RequestMapping("/export")
    public Result export(HttpServletResponse response,@RequestBody Paging paging) throws Exception{
        return service.export(response,paging);
    }

    //    根据id导出
    @PreAuthorize("hasAnyAuthority('finance:payment:print','sys:manage')")
    @RequestMapping("/exportByid")
    public Result exportByid(HttpServletResponse response,@RequestBody int id) throws Exception{
        return service.exportByid(response,id);
    }

    //审核通过
    @PreAuthorize("hasAnyAuthority('finance:payment:examine','sys:manage')")
    @PutMapping("/update")
    public Result update(@RequestBody List<Integer> ids){
        return service.updateBatchbyid(ids);
    }
}
