package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.tuixuesqDo;
import com.trkj.train.entity.EctLeaveschool;
import com.trkj.train.service.IEctLeaveschoolService;
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
@RequestMapping("/ect-leaveschool")
public class EctLeaveschoolController {
    @Autowired
    private IEctLeaveschoolService iEctLeaveschoolService;

    //   查询退学申请表
    @GetMapping("/selecttuixue")
    public IPage<tuixuesqDo> selecttuixue(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("studentName") String studentName,@RequestParam("deleted") int deleted){
        return iEctLeaveschoolService.selecttuixue(page, size, studentName, deleted);
    }

//    添加退学申请表
    @PostMapping("/inserttuixue")
    public int inserttuixue(@RequestBody EctLeaveschool ectLeaveschool){
        return iEctLeaveschoolService.inserttuixue(ectLeaveschool);
    }
}
