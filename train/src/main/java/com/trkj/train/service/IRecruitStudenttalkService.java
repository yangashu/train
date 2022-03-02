package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.TalkeDo;
import com.trkj.train.entity.RecruitStudenttalk;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IRecruitStudenttalkService extends IService<RecruitStudenttalk> {
// 学员谈话表查询
    IPage<TalkeDo> selecttalk(int page,int size,int studentId);
//    添加学员谈话表
    int inserttalk(RecruitStudenttalk recruitStudenttalk);

//    删除
    int deletetalk(RecruitStudenttalk recruitStudenttalk);
}
