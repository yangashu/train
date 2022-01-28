package com.trkj.train.controller;


import com.trkj.train.service.INewsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/news-notice")
public class NewsNoticeController {
    @Autowired
    private INewsNoticeService service;

    @GetMapping("/one")
    public int one(){
        return service.one();
    }

}
