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

    //查询
    IPage<NoticeView> pageselect (int page, int size);
    //修改状态
    int xiugai(NewsNotice newsNotice);
}
