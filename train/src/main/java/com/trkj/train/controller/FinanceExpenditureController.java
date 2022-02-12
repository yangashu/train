package com.trkj.train.controller;


import com.trkj.train.config.Result;
import com.trkj.train.service.IFinanceExpenditureService;
import com.trkj.train.service.IFinancePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/finance-expenditure")
public class FinanceExpenditureController {

    @Autowired
    private IFinanceExpenditureService iFinanceExpenditureService;

    @PostMapping("/paging")
    public Result list(@RequestBody Map<String,Object> map){
        return iFinanceExpenditureService.paging(map);
    }
}
