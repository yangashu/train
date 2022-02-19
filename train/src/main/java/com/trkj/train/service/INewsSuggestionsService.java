package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.ReceivingView;
import com.trkj.train.config.dto.SuggestionsView;
import com.trkj.train.entity.NewsSuggestions;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface INewsSuggestionsService extends IService<NewsSuggestions> {

    //分页查询
    IPage<SuggestionsView> PageSelect(int page, int size);
    //添加
    int addnews(NewsSuggestions suggestions);
    //分页查询
    IPage<SuggestionsView> Page(int page, int size,int id);
}
