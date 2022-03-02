package com.trkj.train.controller;


import com.trkj.train.entity.EctRefund;
import com.trkj.train.service.IEctRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/ect-refund")
public class EctRefundController {
    @Autowired
    private IEctRefundService iEctRefundService;
    //添加退费表
    @PostMapping("/inserttuifei")
    public int inserttuifei(@RequestBody EctRefund ectRefund){
        return iEctRefundService.inserttuifei(ectRefund);
    }

}
