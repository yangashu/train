package com.trkj.train.config.dto.controller;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.trkj.train.config.dto.domain.AliPay;
import com.trkj.train.config.dto.mapper.RefundAndLeaveSchoolAndStudentAndStaffMapper;
import com.trkj.train.config.dto.service.IAliPayService;
import com.trkj.train.config.dto.vo.RefundAndLeaveSchoolAndStudentAndStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/alipay")
public class AliPayController {

    @Autowired
    private IAliPayService iAliPayService;

    @GetMapping("/pay")
    public String pay(AliPay aliPay) {
     return iAliPayService.pay(aliPay);
    }


    @PostMapping("/notify")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request) throws Exception {
        return iAliPayService.alinotify(request);
    }
}
