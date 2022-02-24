package com.trkj.train.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.FinancePay;
import com.trkj.train.service.IFinancePayService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/finance-pay")
public class FinancePayController {
    @Autowired
    private IFinancePayService service;
    @GetMapping("/paging")
    public Result paging(@RequestParam(defaultValue = "1") int current,
                         @RequestParam(defaultValue = "1") int pagesize,
                         @RequestParam(defaultValue = "") String search){
        return service.paging(new Page<FinancePay>(current,pagesize),search);
    }

    //    导入
    @PostMapping("/import")
    private Result importExcel(@RequestParam("file") MultipartFile excelFile) throws Exception{
        return service.saveAll(excelFile);
    }

    //    导出
    @RequestMapping("/export")
    public Result export(HttpServletResponse response) throws Exception{
        return service.export(response);
    }
}
