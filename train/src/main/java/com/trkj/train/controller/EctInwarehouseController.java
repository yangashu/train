package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.FinancePurchaseDo;
import com.trkj.train.entity.EctInwarehouse;
import com.trkj.train.service.IEctInwarehouseService;
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
@RequestMapping("/ect-inwarehouse")
public class EctInwarehouseController {
    @Autowired
    private IEctInwarehouseService iEctInwarehouseService;
//  教程管理  添加入库表
    @PostMapping("insertrktable")
    public int insertrktable(@RequestBody EctInwarehouse ectInwarehouse){
        return iEctInwarehouseService.insertrkjc(ectInwarehouse);
    }

    //    教程入库搜索查询
    @GetMapping("selectiptionjc")
    public IPage<FinancePurchaseDo> selectiptionjc(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("deleted") int deleted, @RequestParam("shoushuokuan") String shoushuokuan){
        return iEctInwarehouseService.selectiptionjc(page, size, deleted, shoushuokuan);
    }
}
