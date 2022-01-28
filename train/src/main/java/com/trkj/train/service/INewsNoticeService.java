package com.trkj.train.service;

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
    public int one();
}
