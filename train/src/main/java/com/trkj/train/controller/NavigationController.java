package com.trkj.train.controller;


import com.trkj.train.config.Result;
import com.trkj.train.entity.Navigation;
import com.trkj.train.service.INavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/navigation")
public class NavigationController {

    @Autowired
    private INavigationService iNavigationService;

    @GetMapping("/list")
    public Result<?> list(){
        List<Navigation> list=iNavigationService.list();
        List<Navigation> navigations=new ArrayList<>();
        for (Navigation navigation : list) {
            for (Navigation e : list) {
                if (e.getNavigationPid()==navigation.getNavigationId()){
                    navigation.getChild().add(e);
                }
            }
            if (navigation.getNavigationPid()==0){
                navigations.add(navigation);
            }
        }
        return Result.success(navigations);
    }
}
