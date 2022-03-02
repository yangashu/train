package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.ectGraduationDo;
import com.trkj.train.entity.EctGraduation;
import com.trkj.train.service.IEctGraduationService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/ect-graduation")
public class EctGraduationController {
    @Autowired
    private IEctGraduationService iEctGraduationService;
//学员中心  历史学员查询
    @GetMapping("selectHistro")
    public IPage<ectGraduationDo> selecthistroy(@RequestParam("currentPageOne") int page,@RequestParam("sizeOne") int size){
        return iEctGraduationService.selectlscx(page, size);
    }
//   学员中心  历史学员搜索查询
    @GetMapping("selectiptionlsss")
    public  IPage<ectGraduationDo> selectiptionssss(@RequestParam("currentPageOne") int page,@RequestParam("sizeOne") int size,@RequestParam("valueone") String valueone,@RequestParam("inputone") String inputone,@RequestParam("deleted") int deleted){
        return iEctGraduationService.selectiptionhistry(page, size, valueone, inputone, deleted);
    }

//    班级管理  结课
    @PostMapping("insertstudentaaa")
    public int insertstudenr(@RequestBody EctGraduation ectGraduation){
        return iEctGraduationService.insertstudnetaaa(ectGraduation);
    }
}
