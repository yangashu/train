package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.FinancePurchaseDo;
import com.trkj.train.entity.FinancePurchase;
import com.trkj.train.service.IFinancePurchaseService;
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
@RequestMapping("/finance-purchase")
public class FinancePurchaseController {
    @Autowired
    private IFinancePurchaseService iFinancePurchaseService;

    //教程入库查询
//    @GetMapping("selectcxjc")
//    public IPage<FinancePurchaseDo> selectcxjc(@RequestParam("page") int page,@RequestParam("size") int size){
//        return iFinancePurchaseService.selectcgjc(page, size);
//    }

    //    教程入库搜索查询
//    @GetMapping("selectiptionjc")
//    public IPage<FinancePurchaseDo> selectiptionjc(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("deleted") int deleted,@RequestParam("shoushuokuan") String shoushuokuan){
//        return iFinancePurchaseService.selectiptionjc(page, size, deleted, shoushuokuan);
//    }
//    教程入库 添加
    @PostMapping("insertjcrk")
    public int insertjcrk(@RequestBody FinancePurchase financePurchase){
        return iFinancePurchaseService.insertjcrk(financePurchase);
    }

//    教程入库  编辑
    @PostMapping("updatjcrk")
    public int updatejcrk(@RequestBody FinancePurchase financePurchase){
        return iFinancePurchaseService.updatejcrk(financePurchase);
    }
}
