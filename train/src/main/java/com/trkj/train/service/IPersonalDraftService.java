package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.DraftView;
import com.trkj.train.entity.PersonalDraft;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IPersonalDraftService extends IService<PersonalDraft> {
    //添加草稿
    int add(PersonalDraft draft);
    //查询
    IPage<DraftView> pageselect(int page, int size, int id);
    //模糊查询
    IPage<DraftView>pagelike(int page,int size,String like,int id);
    //修改状态
    int upzt(PersonalDraft id);
}
