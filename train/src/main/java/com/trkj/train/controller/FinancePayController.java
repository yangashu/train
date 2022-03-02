package com.trkj.train.controller;


import com.trkj.train.entity.FinancePay;
import com.trkj.train.service.IFinancePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    private IFinancePayService iFinancePayService;

//    添加
    @PostMapping("/insertpay")
    public int insertpay(@RequestBody FinancePay financePay){
        return iFinancePayService.insertpay(financePay);
    }

}
