package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.punishDo;
import com.trkj.train.entity.RecruitStundentpunish;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IRecruitStundentpunishService extends IService<RecruitStundentpunish> {
//查询处分表
    IPage<punishDo> selectpunish(int page,int size,int studentId);
//    添加处分表
    int insertpunish(RecruitStundentpunish recruitStundentpunish);
}
