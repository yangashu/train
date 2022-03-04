package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysMenu;
import com.trkj.train.entity.SysPosition;
import com.trkj.train.entity.SysPositionMenu;
import com.trkj.train.service.ISysMenuService;
import com.trkj.train.service.ISysPositionMenuService;
import com.trkj.train.service.ISysPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/sys-position-menu")
public class SysPositionMenuController {
    @Autowired
    private ISysPositionService iPositionService;
    @Autowired
    private ISysPositionMenuService service;
    @Autowired
    private ISysMenuService iMenuService;

    @GetMapping("/find")
    public Result<?> find(){
        List<SysMenu> list=iMenuService.list();
        List<SysMenu> menus=new ArrayList<>();
        List<SysMenu> menuList=new ArrayList<>();
        for (SysMenu menu : list) {
            for (SysMenu item : list) {
                if (menu.getMenuId() == item.getMenuPid()) {
                    menu.getChildren().add(item);
                }
            }
        }
        for (SysMenu menu : list) {
            for (SysMenu item : menus) {
                if (menu.getMenuId()==item.getMenuPid()){
                    menu.getChildren().add(item);
                }
            }
            if (menu.getMenuPid()==0){
                menuList.add(menu);
            }
        }
        return Result.success(menuList);
    }
    @GetMapping("/menu")
    public Result<?> menu(int id){
        List<SysMenu> list=iMenuService.list(new QueryWrapper<SysMenu>().eq("menu_state",0));
        List<SysMenu> menus=new ArrayList<>();
        List<SysMenu> menuList=new ArrayList<>();
        for (SysMenu menu : list) {
            for (SysMenu item : list) {
                if (menu.getMenuId() == item.getMenuPid()) {
                    menu.getChildren().add(item);
                }
            }
        }
        for (SysMenu menu : list) {
            for (SysMenu item : menus) {
                if (menu.getMenuId()==item.getMenuPid()){
                    menu.getChildren().add(item);
                }
            }
            if (menu.getMenuPid()==0){
                menuList.add(menu);
            }
        }
        List<SysPositionMenu> positionMenu=service.list(new QueryWrapper<SysPositionMenu>().eq("position_id",id));
        for (SysMenu menu : list) {
            for (SysPositionMenu positionMenu1 : positionMenu) {
                if (menu.getMenuId()==positionMenu1.getMenuId()){
                    positionMenu1.getMenus().add(menu);
                }
            }

        }
        return Result.success(positionMenu);
    }
    @GetMapping("/info")
    public Result info(int id) {
        SysPosition position = iPositionService.getById(id);
        List<SysPositionMenu> positionMenus = service.list(new QueryWrapper<SysPositionMenu>().eq("position", id));
        List<Integer> menuIds = positionMenus.stream().map(p -> p.getMenuId()).collect(Collectors.toList());
        position.setMenus(menuIds);
        return Result.success(position);
    }

    //    分配权限
    @PreAuthorize("hasAnyAuthority('sys:role','sys:role:perm','sys:manage')")
    @PostMapping("/perm/{roleId}")
//    @PreAuthorize("hasAuthority('sys:role:perm')")
    public Result perm(@PathVariable int roleId, @RequestBody int[] menuIds) {
        List<SysPositionMenu> sysRoleMenus = new ArrayList<>();
        Arrays.stream(menuIds).forEach(menuId -> {
            SysPositionMenu roleMenu = new SysPositionMenu();
            roleMenu.setMenuId(menuId);
            roleMenu.setPositionId(roleId);
            sysRoleMenus.add(roleMenu);
        });

        service.remove(new QueryWrapper<SysPositionMenu>().eq("position_id", roleId));

        service.saveBatch(sysRoleMenus);

        // 清除所有用户的权限缓存信息
//        sysUserService.clearUserAuthorityInfoByRoleId(roleId);
        return Result.success(menuIds);
    }
}
