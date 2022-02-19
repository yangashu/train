package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.PersonalSend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.entity.SysStaff;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IPersonalSendService extends IService<PersonalSend> {

    //分页
    IPage<SendView> SelectPage(int page, int size, int id);
    //模糊
    public IPage<SendView> lickselect(int page, int size, String like, int id);
    //查询用户
    List<SysStaff> selectcheckd();
    //新增
    int adds(PersonalSend send);
    //删除
    int delete(int id);

    int ad(PersonalSend send);
}
