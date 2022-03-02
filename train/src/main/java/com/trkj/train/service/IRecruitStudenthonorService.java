package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.recruitStudentHonorDo;
import com.trkj.train.entity.RecruitStudenthonor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IRecruitStudenthonorService extends IService<RecruitStudenthonor> {
//学员中心 详情弹框  学员荣誉查询
    IPage<recruitStudentHonorDo> selectxyry(int page,int size,int studentId);
//    学员中心  详情弹框  学员荣誉添加
    int insertstudentry(RecruitStudenthonor recruitStudenthonor);
}
