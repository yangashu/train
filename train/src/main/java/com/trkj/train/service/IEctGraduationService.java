package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.ectGraduationDo;
import com.trkj.train.entity.EctGraduation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctGraduationService extends IService<EctGraduation> {
    //学员中心  历史学员查询
    IPage<ectGraduationDo> selectlscx(int page,int size);
//学员中心  历史学员搜索查询
    IPage<ectGraduationDo> selectiptionhistry(int page,int size,String valueone,String inputone,int deleted);
//    班级管理 结课
    int insertstudnetaaa(EctGraduation ectGraduation);
}
