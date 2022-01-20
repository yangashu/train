package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysMenu;
import com.trkj.train.mapper.SysMenuMapper;
import com.trkj.train.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/sys-menu")
public class SysMenuController {
    @Autowired
    private ISysMenuService iMenuService;
    @Autowired
    private SysMenuMapper mapper;
    @GetMapping("/findbyPid")
    public Result<?> findbyPid(@RequestParam("size") int size, @RequestParam("page") int page, @RequestParam(defaultValue = "") String keyword){
        IPage<SysMenu> pageing=iMenuService.pageing(page,size,keyword);
        return Result.success(pageing);
    }
    @GetMapping("/findbyId")
    public Result<?> findbyId(){
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper();
        queryWrapper.gt("menu_pid",0);
        List<SysMenu> list=iMenuService.list(queryWrapper);
        return Result.success(list);
    }
    //    添加
    @PostMapping("/insert")
    public Result<?> insert(@RequestBody SysMenu menu){
        boolean x=iMenuService.save(menu);
        if (x){
            return Result.success();
        }else
            return Result.error("-1","出问题了！！！");
    }
    //    修改
    @PostMapping("/update")
    public Result<?> update(@RequestBody SysMenu menu){
        boolean x=iMenuService.updateById(menu);
        if(x){
            return Result.success();
        }else{
            return Result.error("-1","出问题了丫");
        }
    }

    //    分页查询
    @GetMapping("paging")
    public Result<?> paging(@RequestParam(defaultValue = "1") int currentPage,
                            @RequestParam(defaultValue = "1") int pageSize,
                            @RequestParam(defaultValue = "") String keyword){
        List<SysMenu> list=iMenuService.list();
        IPage<SysMenu> page=mapper.selectPage(new Page<SysMenu>(currentPage,pageSize),new QueryWrapper<SysMenu>().like("menu_name",keyword).eq("menu_pid",0));
        List<SysMenu> menus=new ArrayList<>();
        IPage<SysMenu> iPage= new Page<>();
        List<SysMenu> list1=new ArrayList<>();
        for (SysMenu e : list){
            for (SysMenu menu : list) {
                if (e.getMenuId() == menu.getMenuPid()) {
                    e.getChildren().add(menu);
                }
            }
            list1.add(e);
        }
        for (int i=0;i<page.getRecords().size();i++){
            for (SysMenu e : list1){
                if(page.getRecords().get(i).getMenuId()==e.getMenuPid()){
                    page.getRecords().get(i).getChildren().add(e);
                }
            }
            menus.add(page.getRecords().get(i));
        }
        iPage.setRecords(menus);
        iPage.setPages(page.getPages());
        iPage.setCurrent(page.getCurrent());
        iPage.setTotal(page.getTotal());
        iPage.setSize(page.getSize());
        return Result.success(iPage);
    }
    //    查询全部
    @GetMapping("/list")
    public Result<?> list(){
        List<SysMenu> list=iMenuService.list();
        List<SysMenu> menus=new ArrayList<>();
        for (SysMenu menu : list) {
            for (SysMenu e : list) {
                if (e.getMenuPid()==menu.getMenuId()){
                    menu.getChildren().add(e);
                }
            }
            if (menu.getMenuPid()==0){
                menus.add(menu);
            }
        }
        return Result.success(menus);
    }

    //    删除
    @DeleteMapping("/deleteByid")
    public Result<?> deleteByid(int id){
        int x= iMenuService.deelteByid(id);
        if (x > 0) {
            return Result.success();
        }else
            return Result.error("-1","操作失败！！！");
    }
    //    根据id查询
    @GetMapping("/findByid")
    public Result<?> findByid(int id){
        return Result.success(iMenuService.getById(id));
    }
}
