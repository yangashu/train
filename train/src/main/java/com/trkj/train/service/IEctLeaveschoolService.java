package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.tuixuesqDo;
import com.trkj.train.entity.EctLeaveschool;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctLeaveschoolService extends IService<EctLeaveschool> {
//   查询退学申请表
    IPage<tuixuesqDo> selecttuixue(int page,int size,String studentName,int deleted);

//    添加
    int inserttuixue(EctLeaveschool ectLeaveschool);
}
