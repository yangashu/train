package com.trkj.train.config.dto.controller;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.service.IPayAndStaffAndstudentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/paging")
    public Result paging(@RequestBody Map<String,Object> map){
        return service.paging(map);
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

    //    根据id导出
    @RequestMapping("/exportByid")
    public Result exportByid(HttpServletResponse response,@RequestBody int id) throws Exception{
        return service.exportByid(response,id);
    }

    //审核通过
    @PutMapping("/update")
    public Result update(@RequestBody List<Integer> ids){
        return service.updateBatchbyid(ids);
    }
}
