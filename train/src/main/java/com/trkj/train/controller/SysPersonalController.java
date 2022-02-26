package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.vo.staffAndSign;
import com.trkj.train.service.ISysPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/sys-personal")
public class SysPersonalController {

    @Autowired
    private ISysPersonalService iPersonalService;

    //员工考勤分页模糊查询
    @GetMapping("/one")
    public IPage<staffAndSign> one(@RequestParam("information") String information, @RequestParam("mode") String mode, @RequestParam("mycurrentPage") int page, @RequestParam("mypagesize") int size){
        return  iPersonalService.   two(information,mode,page,size);
    }

    //查询未入职用户
    @GetMapping("/notEmployed")
    public Result<IPage<SysPersonal>> notEmployed(@RequestParam("currentPage") int page,@RequestParam("pagesize") int size){
        IPage<SysPersonal> ipage=iPersonalService.selectPer(page,size);
        return Result.success(ipage);
    }

    //未入职用户模糊查询
    @GetMapping("/likePersonal")
    public Result<IPage<SysPersonal>> ontEmployedLike(@RequestParam("currentPage") int page,@RequestParam("pagesize") int size,@RequestParam("like") String like){
        return Result.success(iPersonalService.likePersonal(new Page(page,size),like));
    }

    //导出
    @RequestMapping("/export")
    public Result export(HttpServletResponse response,@RequestBody Paging paging) throws Exception {
        return iPersonalService.export(response,paging);
    }
    //导入
    @PostMapping("/import")
    public Result saveAll(@RequestParam("file") MultipartFile excelFile) throws Exception {
        return iPersonalService.saveAll(excelFile);
    }

}
