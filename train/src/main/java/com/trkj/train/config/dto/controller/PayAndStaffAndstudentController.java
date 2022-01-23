package com.trkj.train.config.dto.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.service.IPayAndStaffAndstudentService;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Map;

@RestController
@RequestMapping("/PayAndStaffAndstudent")
public class PayAndStaffAndstudentController implements Serializable {
    @Autowired
    private IPayAndStaffAndstudentService service;

    @GetMapping("/paging")
    public Result paging(@RequestParam(defaultValue = "1") int current,
                         @RequestParam(defaultValue = "1") int pagesize,
                         @RequestParam(defaultValue = "") String search){
        return service.paging(new Page(current,pagesize),search);
    }
    //    导入
    @PostMapping("/import")
    private Result importExcel(@RequestParam("file") MultipartFile excelFile) throws Exception{
        return service.saveAll(excelFile);
    }

    //    导出
    @RequestMapping("/export")
    public Result export(HttpServletResponse response,@RequestBody Paging paging) throws Exception{
        return service.export(response,paging);
    }
}
