package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.entity.RecruitChannel;
import com.trkj.train.service.IRecruitChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/recruit-channel")
public class RecruitChannelController {
    @Autowired
    private IRecruitChannelService iChannelService;
    //    分页
    @GetMapping("chenlpage")
    public IPage<RecruitChannel> selectchannel(@RequestParam("currentPage") int page, @RequestParam("size") int size){
        IPage<RecruitChannel> page1=iChannelService.page(page,size);
        return page1;
    }
    //    添加渠道
    @PostMapping("/addqudao")
    public int addqudao(@RequestBody RecruitChannel channel){
        int addqudao= iChannelService.addqudao(channel);
        return addqudao;
    }
    //    修改渠道
    @PostMapping("/updatequdao")
    public int updatequdao(@RequestBody RecruitChannel channel){
        int updatequdao= iChannelService.updatequdao(channel);
        return updatequdao;
    }
    //    根据渠道名称分页查询
    @GetMapping("/likeselect")
    public IPage<RecruitChannel> likeselect(@RequestParam("currentPage") int page,@RequestParam("size") int size, @RequestParam("shoushuokuan") String channelName){
        IPage<RecruitChannel> channelIPage=iChannelService.likeselect(page,size,channelName);
        return channelIPage;
    }
    //    删除
    @PostMapping("/delectchannel")
    public int delectchannel(@RequestBody RecruitChannel channel){
        return iChannelService.delectchannel(channel);
    }

//    查询所有渠道
    @GetMapping("selectqd")
    public List<RecruitChannel> selectqudao(){
        return iChannelService.selectqd();
    }
}
