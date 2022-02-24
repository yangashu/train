package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.NoticeView;
import com.trkj.train.entity.NewsNotice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface INewsNoticeService extends IService<NewsNotice> {

    //模糊查询
    IPage<NoticeView> pageselectLike (int page, int size,String like,String mode);
    //查询
    IPage<NoticeView> pageselect (int page, int size);
    //修改为发布
    int xiugai(int id);
    //修改为暂停
    int zanting(int id);
    //删除
    int del(int id);
    //新增
    int add(NewsNotice newsNotice);
}
