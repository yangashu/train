package com.trkj.train.controller;


import com.trkj.train.service.INewsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.NoticeView;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.NewsNotice;
import com.trkj.train.service.impl.NewsNoticeServiceImpl;
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
@RequestMapping("/news-notice")
public class NewsNoticeController {
    @Autowired
    private INewsNoticeService service;

    @GetMapping("/one")
    public int one() {
        System.out.println("sssssssssssssssssssssssssssssss");
        return service.one();
    }

    @GetMapping("/select")
    public IPage<NoticeView> page(@RequestParam("page") int page, @RequestParam("size") int size,@RequestParam("id") int id){
        IPage<NoticeView> sendIPage = service.pageselect(page, size,id);
        return sendIPage;
    }

    @PostMapping("/up")
    public int up(@RequestBody NewsNotice newsNotice){
        int a = service.xiugai(newsNotice.getNoticeId());
        return a;
    }

    @PostMapping("/zt")
    public int zt(@RequestBody NewsNotice newsNotice){
        int a = service.zanting(newsNotice.getNoticeId());
        return a;
    }

    @PostMapping("/del")
    public int del(@RequestBody NewsNotice newsNotice){
        int a = service.del(newsNotice.getNoticeId());
        return a;
    }

    @PostMapping("/add")
    public int add(@RequestBody NewsNotice newsNotice){
        int a = service.add(newsNotice);
        return a;
    }

    @GetMapping("/selectlike")
    public IPage<NoticeView> pagelike(@RequestParam("page") int page, @RequestParam("size") int size,@RequestParam String like,@RequestParam String mode,@RequestParam("id") int id){
        IPage<NoticeView> noticeViewIPage = service.pageselectLike(page, size,like,mode,id);
        return noticeViewIPage;
    }
}
