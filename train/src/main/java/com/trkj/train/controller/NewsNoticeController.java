package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.NoticeView;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.NewsNotice;
import com.trkj.train.service.impl.NewsNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
    private NewsNoticeServiceImpl newsNoticeService;

    @GetMapping("/select")
    public IPage<NoticeView> page(@RequestParam("page") int page, @RequestParam("size") int size){
        IPage<NoticeView> sendIPage = newsNoticeService.pageselect(page, size);
        return sendIPage;
    }

    @PostMapping("/up")
    public int up(@RequestBody NewsNotice newsNotice){
        int a = newsNoticeService.xiugai(newsNotice.getNoticeId());
        return a;
    }

    @PostMapping("/zt")
    public int zt(@RequestBody NewsNotice newsNotice){
        int a = newsNoticeService.zanting(newsNotice.getNoticeId());
        return a;
    }

    @PostMapping("/del")
    public int del(@RequestBody NewsNotice newsNotice){
        int a = newsNoticeService.del(newsNotice.getNoticeId());
        return a;
    }

    @PostMapping("/add")
    public int add(@RequestBody NewsNotice newsNotice){
        int a = newsNoticeService.add(newsNotice);
        return a;
    }

    @GetMapping("/selectlike")
    public IPage<NoticeView> pagelike(@RequestParam("page") int page, @RequestParam("size") int size,@RequestParam String like,@RequestParam String mode){
        IPage<NoticeView> noticeViewIPage = newsNoticeService.pageselectLike(page, size,like,mode);
        return noticeViewIPage;
    }
}
