package com.trkj.train.service;

import com.trkj.train.entity.PersonalDraft;
import com.trkj.train.entity.PersonalNotepad;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IPersonalNotepadService extends IService<PersonalNotepad> {
    //添加
    int tj(PersonalNotepad notepad);
    //查询
    List<PersonalNotepad> selectDate();
    //修改
    int up(PersonalNotepad notepad);

}
